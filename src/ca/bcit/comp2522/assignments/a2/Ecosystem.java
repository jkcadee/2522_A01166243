package ca.bcit.comp2522.assignments.a2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Ecosystem {
    private static final Random RANDOM_NUMBER = new Random();

    private ArrayList<Pool> pools;

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }

    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    public void reset() {
        pools.clear();
    }

    public int getGuppyPopulation() {
        int totalGuppies = 0;
        for (Pool currentPool : pools) {
            totalGuppies += currentPool.getPopulation();
        }
        return totalGuppies;
    }

    public int adjustForCrowding() {
        int destroyedGuppies = 0;
        for (Pool currentPool : pools) {
            destroyedGuppies += currentPool.adjustForCrowding();
        }
        return destroyedGuppies;
    }

    public void setupSimulation() {
        final double vol1 = 3000.0;
        final double temp1 = 42.0;
        final double pH1 = 7.9;
        final double nutcoe1 = 0.9;

        final double vol2 = 15000.0;
        final double temp2 = 39.0;
        final double pH2 = 7.7;
        final double nutcoe2 = 0.85;

        final double vol3 = 4500.0;
        final double temp3 = 37.0;
        final double pH3 = 7.5;
        final double nutcoe3 = 1.0;

        final int maxAmountOfGuppies1 = 300;
        final int maxAmountOfGuppies2 = 100;
        final int maxAmountOfGuppies3 = 200;

        final int minWeek1 = 10;
        final int maxWeek1 = 25;

        final int minWeek2 = 10;
        final int maxWeek2 = 15;

        final int minWeek3 = 15;
        final int maxWeek3 = 49;

        final double healthCoefficientMin1 = 0.5;
        final double healthCoefficientMax1 = 0.8;

        final double healthCoefficientMin2 = 0.8;
        final double healthCoefficientMax2 = 1.0;

        final double healthCoefficientMin3 = 0.0;
        final double healthCoefficientMax3 = 1.0;

        Pool skookumchuk = new Pool("Skookumchuk", vol1, temp1, pH1, nutcoe1);
        Pool squamish = new Pool("Squamish", vol2, temp2, pH2, nutcoe2);
        Pool semiahmoo = new Pool("Semiahmoo", vol3, temp3, pH3, nutcoe3);

        this.guppyGenerator(maxAmountOfGuppies1, minWeek1, maxWeek1,
                healthCoefficientMin1, healthCoefficientMax1,
                0.75, 1, skookumchuk);
        this.guppyGenerator(maxAmountOfGuppies2, minWeek2, maxWeek2,
                healthCoefficientMin2, healthCoefficientMax2,
                0.75, 1, squamish);
        this.guppyGenerator(maxAmountOfGuppies3, minWeek3, maxWeek3,
                healthCoefficientMin3, healthCoefficientMax3,
                0.35, 1, semiahmoo);

        this.addPool(skookumchuk);
        this.addPool(squamish);
        this.addPool(semiahmoo);
    }

    private void guppyGenerator(int guppyAmount, int ageMin, int ageMax, double healthCoefficientMin,
                                double healthCoefficientMax, double femalePercentage, int generationNumber, Pool pool) {
        boolean isFemale = false;
        BigDecimal femaleP = new BigDecimal(femalePercentage);
        for (int guppies = 0; guppies < guppyAmount; guppies++) {
            int generateRandomAge = RANDOM_NUMBER.nextInt((ageMax - ageMin + 1)) + ageMin;
            double generateRandomNutrientCoefficient = healthCoefficientMin
                    + (healthCoefficientMax - healthCoefficientMin) * RANDOM_NUMBER.nextDouble();
            double generateFemaleChance = RANDOM_NUMBER.nextDouble();
            BigDecimal genFemaleP = new BigDecimal(generateFemaleChance);
            if (genFemaleP.compareTo(femaleP) < 0) {
                isFemale = true;
            }
            Guppy guppy = new Guppy(Guppy.DEFAULT_GENUS, Guppy.DEFAULT_SPECIES, generateRandomAge,
                    isFemale, generationNumber, generateRandomNutrientCoefficient);
            pool.addGuppy(guppy);
            generationNumber++;
            isFemale = false;
        }
    }

    public void simulate(final int numberOfWeeks) {
        this.setupSimulation();
        for (int currentWeek = 1; currentWeek <= numberOfWeeks; currentWeek++) {
            this.simulateOneWeek(currentWeek);
        }
    }

    public void simulateOneWeek(final int currentWeek) {
        int diedOfOldAge = 0;
        int numberRemoved = 0;
        int starvedToDeath = 0;
        int newFry = 0;
        int crowdedOut = 0;
        ArrayList<String> poolNames = new ArrayList<>();
        ArrayList<Integer> poolPopulations = new ArrayList<>();

        for (Pool pool : pools) {
            diedOfOldAge += pool.incrementAges();
            numberRemoved += pool.removeDeadGuppies();
            starvedToDeath += pool.applyNutrientCoefficient();
            numberRemoved += pool.removeDeadGuppies();
            newFry += pool.spawn();
            crowdedOut += pool.adjustForCrowding();
            numberRemoved += pool.removeDeadGuppies();
            if (!poolNames.contains(pool.getName())) {
                poolNames.add(pool.getName());
            }
            if (!poolPopulations.contains(pool.getPopulation())) {
                poolPopulations.add(pool.getPopulation());
            }
        }

        if ((diedOfOldAge + starvedToDeath + crowdedOut) != numberRemoved) {
            System.out.println("Logic Error!");
        }

        StringBuilder displayEcosystem = new StringBuilder();
        displayEcosystem.append("Week: ").append(currentWeek).append("\n");
        displayEcosystem.append("Number of deaths from old age: ").append(diedOfOldAge).append("\n");
        displayEcosystem.append("Number of deaths from starvation: ").append(starvedToDeath).append("\n");
        displayEcosystem.append("Number of deaths from overpopulation: ").append(crowdedOut).append("\n");
        displayEcosystem.append("Total number of births: ").append(newFry).append("\n");
        displayEcosystem.append("Total number of deaths: ").append(numberRemoved).append("\n");
        displayEcosystem.append("Pools: ").append(poolNames).append("\n");
        displayEcosystem.append("Pool populations: ").append(poolPopulations).append("\n");
        displayEcosystem.append("Total Ecosystem population: ").append(this.getGuppyPopulation()).append("\n");

        System.out.println(displayEcosystem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ecosystem ecosystem = (Ecosystem) o;
        return pools.equals(ecosystem.pools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pools);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ecosystem{");
        sb.append("pools=").append(pools);
        sb.append('}');
        return sb.toString();
    }
}
