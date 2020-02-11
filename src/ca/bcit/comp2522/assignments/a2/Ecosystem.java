package ca.bcit.comp2522.assignments.a2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Creates a realistic simulation of an ecosystem.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Ecosystem {
    private static final Random RANDOM_NUMBER = new Random();
    private static int currentWeek = 1;

    private ArrayList<Pool> pools;

    /**
     * Constructs the Ecosystem's ArrayList of Pools.
     */

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }

    /**
     * Add a new Pool object to the ArrayList of Pools.
     * If the Pool is null, it is not added.
     *
     * @param newPool The Pool object to be added.
     */

    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * Clears the pool that it is called on of all values.
     */

    public void reset() {
        pools.clear();
    }

    /**
     * Gets the total Guppy population in each Pool.
     * Adds then and returns them in a total.
     *
     * @return The total amount of Guppies in the Ecosystem.
     */

    public int getGuppyPopulation() {
        int totalGuppies = 0;
        for (Pool currentPool : pools) {
            totalGuppies += currentPool.getPopulation();
        }
        return totalGuppies;
    }

    /**
     * Adjusts for crowding in each Pool.
     * Returns the amount of Guppies killed.
     *
     * @return The amount of Guppies killed from overpopulation.
     */

    public int adjustForCrowding() {
        int destroyedGuppies = 0;
        for (Pool currentPool : pools) {
            destroyedGuppies += currentPool.adjustForCrowding();
        }
        return destroyedGuppies;
    }

    /**
     * Sets up the simulation by creating three new Pools and populating them.
     * Each Pool has a different number of Guppies with different values for their attributes.
     */

    public void setupSimulation() {
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

        final double femalePercentage1 = 0.75;
        final double femalePercentage2 = 0.75;
        final double femalePercentage3 = 0.35;

        final Pool skookumchuk = new Pool("Skookumchuk", 3000.0, 42.0, 7.9, 0.9);
        final Pool squamish = new Pool("Squamish", 15000.0, 39.0, 7.7, 0.85);
        final Pool semiahmoo = new Pool("Semiahmoo", 4500.0, 37.0, 7.5, 1.0);

        this.guppyGenerator(maxAmountOfGuppies1, minWeek1, maxWeek1,
                healthCoefficientMin1, healthCoefficientMax1,
                femalePercentage1, skookumchuk);
        this.guppyGenerator(maxAmountOfGuppies2, minWeek2, maxWeek2,
                healthCoefficientMin2, healthCoefficientMax2,
                femalePercentage2, squamish);
        this.guppyGenerator(maxAmountOfGuppies3, minWeek3, maxWeek3,
                healthCoefficientMin3, healthCoefficientMax3,
                femalePercentage3, semiahmoo);

        this.addPool(skookumchuk);
        this.addPool(squamish);
        this.addPool(semiahmoo);
    }

    /*
    * Generates each unique Guppy for the the Pools.
    * Takes in the passed in values and generates them based on the parameters
    * each Pool has.
    */

    private void guppyGenerator(final int guppyAmount, final int ageMin, final int ageMax,
                                final double healthCoefficientMin,
                                final double healthCoefficientMax, final double femalePercentage,
                                final Pool pool) {
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
                    isFemale, 1, generateRandomNutrientCoefficient);
            pool.addGuppy(guppy);
            isFemale = false;
        }
    }

    /**
     * Simulates the Ecosystem for however many weeks is specified.
     *
     * @param numberOfWeeks The amount of weeks that the Ecosystem will be simulated.
     */

    public void simulate(final int numberOfWeeks) {
        this.setupSimulation();
        for (int week = 0; week < numberOfWeeks; week++) {
            this.simulateOneWeek();
        }
    }

    /**
     * Simulates one week of the Ecosystem.
     * Guppies die of old age, starvation or overpopulation and are removed.
     * New Guppies are born if enough females exist to do so.
     * This method prints all this information to console.
     */

    public void simulateOneWeek() {
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
        displayEcosystem.append("Week: ").
                append(currentWeek).append("\n");
        displayEcosystem.append("Number of deaths from old age: ").
                append(diedOfOldAge).append("\n");
        displayEcosystem.append("Number of deaths from starvation: ").
                append(starvedToDeath).append("\n");
        displayEcosystem.append("Number of deaths from overpopulation: ").
                append(crowdedOut).append("\n");
        displayEcosystem.append("Total number of births: ").
                append(newFry).append("\n");
        displayEcosystem.append("Pools: ").
                append(poolNames).append("\n");
        displayEcosystem.append("Pool populations: ").
                append(poolPopulations).append("\n");
        displayEcosystem.append("Total Ecosystem population: ").
                append(this.getGuppyPopulation()).append("\n");

        System.out.println(displayEcosystem);
        currentWeek++;
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param o The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */

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

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(pools);
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Ecosystem.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ecosystem{");
        sb.append("pools=").append(pools);
        sb.append('}');
        return sb.toString();
    }
}
