package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Objects;
import java.util.Arrays;

public class Pool {
    public static final String DEFAULT_POOL_NAME = "Unnamed";
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    public static final double NEUTRAL_PH = 7.0;
    public static final double MINIMUM_PH = 0.0;
    public static final double MAXIMUM_PH = 14.0;
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    private static int numberOfPools;
    
    private final String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private final int identificationNumber;
    private final ArrayList<Guppy> guppiesInPool;
    private final Random randomNumberGenerator;
    
    public Pool() {
        this(DEFAULT_POOL_NAME, 0.0, DEFAULT_POOL_TEMP_CELSIUS,
                NEUTRAL_PH, DEFAULT_NUTRIENT_COEFFICIENT);
    }

    public Pool(String name, double volumeLitres,
                double temperatureCelsius, double pH, double nutrientCoefficient) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name entered is invalid.");
        }

        this.name = name.strip().substring(0, 1).toUpperCase()
                + name.strip().substring(1).toLowerCase();

        if (volumeLitres < 0) {
            this.volumeLitres = 0.0;
        } else {
            this.volumeLitres = volumeLitres;
        }

        if (MINIMUM_POOL_TEMP_CELSIUS <= temperatureCelsius
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        } else {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        }

        if (MINIMUM_PH <= pH && pH <= MAXIMUM_PH) {
            this.pH = pH;
        } else {
            this.pH = NEUTRAL_PH;
        }

        if (MINIMUM_NUTRIENT_COEFFICIENT <= nutrientCoefficient
                && nutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = nutrientCoefficient;
        } else {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }

        this.identificationNumber = ++numberOfPools;
        this.guppiesInPool = new ArrayList<>();
        this.randomNumberGenerator = new Random();
    }

    public void setVolumeLitres(double volumeLitres) {
        if (volumeLitres < 0) {
            this.volumeLitres = 0.0;
        } else {
            this.volumeLitres = volumeLitres;
        }
    }

    public void setTemperatureCelsius(double temperatureCelsius) {
        if (MINIMUM_POOL_TEMP_CELSIUS <= temperatureCelsius
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        } else {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        }
    }

    public void setPH(double pH) {
        if (MINIMUM_PH <= pH && pH <= MAXIMUM_PH) {
            this.pH = pH;
        } else {
            this.pH = NEUTRAL_PH;
        }
    }

    public void setNutrientCoefficient(double nutrientCoefficient) {
        if (MINIMUM_NUTRIENT_COEFFICIENT <= nutrientCoefficient
                && nutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = nutrientCoefficient;
        } else {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }

    }

    public String getName() {
        return name;
    }

    public double getVolumeLitres() {
        return volumeLitres;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public double getPH() {
        return pH;
    }

    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void changeNutrientCoefficient(double delta) {
        this.nutrientCoefficient += delta;
        if (nutrientCoefficient <= MINIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else if (nutrientCoefficient >= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        }
    }

    public void changeTemperature(double delta) {
        this.temperatureCelsius += delta;
        if (temperatureCelsius <= MINIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else if (temperatureCelsius >= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        }
    }

    public static int getNumberCreated() {
        return numberOfPools;
    }

    public boolean addGuppy(Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        guppiesInPool.add(guppy);
        return true;
    }

    public int getPopulation() {
        int numberOfAliveGuppies = 0;
        for (Guppy aliveGuppy : guppiesInPool) {
            if (aliveGuppy.getIsAlive()) {
                numberOfAliveGuppies++;
            }
        }
        return numberOfAliveGuppies;
    }

    public int applyNutrientCoefficient() {
        Iterator<Guppy> guppies = guppiesInPool.iterator();
        int starvedGuppies = 0;
        while (guppies.hasNext()) {
            Guppy currentGuppy = guppies.next();
            double nutrients = randomNumberGenerator.nextDouble();
            if (nutrients > this.nutrientCoefficient) {
                currentGuppy.setIsAlive(false);
                starvedGuppies++;
            }
        }
        return starvedGuppies;
    }

    public int removeDeadGuppies() {
        Iterator<Guppy> guppies = guppiesInPool.iterator();
        int deadGuppies = 0;
        while (guppies.hasNext()) {
            Guppy currentGuppy = guppies.next();
            if (!currentGuppy.getIsAlive()) {
                guppies.remove();
                deadGuppies++;
            }
        }
        return deadGuppies;
    }

    public double getGuppyVolumeRequirementInLitres() {
        final double oneLitre = 1000.0;
        double guppyVolumeRequired = 0.0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive()) {
                guppyVolumeRequired += aliveGuppies.getVolumeNeeded();
           }
        }
        guppyVolumeRequired /= oneLitre;
        return guppyVolumeRequired;
    }

    public double getAverageAgeInWeeks() {
        double averageAgeInWeeks = 0.0;
        int guppies = 0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive()) {
                averageAgeInWeeks += aliveGuppies.getAgeInWeeks();
                guppies++;
            }
        }
        return averageAgeInWeeks / guppies;
    }

    public double getAverageHealthCoefficient() {
        double averageHealthCoefficient = 0.0;
        int guppies = 0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive()) {
                averageHealthCoefficient += aliveGuppies.getHealthCoefficient();
                guppies++;
            }
        }
        return averageHealthCoefficient / guppies;
    }

    public double getFemalePercentage() {
        final int oneHundred = 100;
        double averageFemalePercentage = 0;
        int guppies = 0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive() && aliveGuppies.getIsFemale()) {
                averageFemalePercentage++;
                guppies++;
            }
        }
        return averageFemalePercentage / guppies * oneHundred;
    }

    public double getMedianAge() {
        Iterator<Guppy> guppies = guppiesInPool.iterator();
        int aliveGuppies = 0;
        for (Guppy aliveGuppy: guppiesInPool) {
            if (aliveGuppy.getIsAlive()) {
                aliveGuppies++;
            }
        }
        int[] guppyAgeArray = new int[aliveGuppies];
        int guppyAmount = 0;
        while (guppies.hasNext()) {
            Guppy currentGuppy = guppies.next();
            if (currentGuppy.getIsAlive()) {
                guppyAgeArray[guppyAmount] = currentGuppy.getAgeInWeeks();
                guppyAmount++;
            }
        }
        Arrays.sort(guppyAgeArray);
        int medianAgeIndex = Math.floorDiv(guppyAgeArray.length + 1, 2);
        return guppyAgeArray[medianAgeIndex];
    }

    public double getMedianHealthCoefficient() {
        Iterator<Guppy> guppies = guppiesInPool.iterator();
        int aliveGuppies = 0;
        for (Guppy aliveGuppy: guppiesInPool) {
            if (aliveGuppy.getIsAlive()) {
                aliveGuppies++;
            }
        }
        double[] guppyAgeArray = new double[aliveGuppies];
        int guppyAmount = 0;
        while (guppies.hasNext()) {
            Guppy currentGuppy = guppies.next();
            if (currentGuppy.getIsAlive()) {
                guppyAgeArray[guppyAmount] = currentGuppy.getHealthCoefficient();
                guppyAmount++;
            }
        }
        Arrays.sort(guppyAgeArray);
        int medianHealthIndex = Math.floorDiv(guppyAgeArray.length + 1, 2);
        return guppyAgeArray[medianHealthIndex];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pool{");
        sb.append("name='").append(name).append('\'');
        sb.append(", volumeLitres=").append(volumeLitres);
        sb.append(", temperatureCelsius=").append(temperatureCelsius);
        sb.append(", pH=").append(pH);
        sb.append(", nutrientCoefficient=").append(nutrientCoefficient);
        sb.append(", identificationNumber=").append(identificationNumber);
        sb.append(", guppiesInPool=").append(guppiesInPool);
        sb.append(", randomNumberGenerator=").append(randomNumberGenerator);
        sb.append('}');
        return sb.toString();
    }

    public int spawn() {
        int addedBabies = 0;
        ArrayList<Guppy> newBabiesArrayList = new ArrayList<>();
        for (Guppy currentGuppy : guppiesInPool) {
            ArrayList<Guppy> newBabies = currentGuppy.spawn();
            if (newBabies != null) {
                newBabiesArrayList.addAll(newBabies);
            }
        }
        addedBabies += newBabiesArrayList.size();
        guppiesInPool.addAll(newBabiesArrayList);
        return addedBabies;
    }

    public int incrementAges() {
        int deadGuppies = 0;
        for (Guppy currentGuppy : guppiesInPool) {
            currentGuppy.incrementAge();
            if (!currentGuppy.getIsAlive()) {
                deadGuppies++;
            }
        }
        return deadGuppies;
    }

    public int adjustForCrowding() {
        guppiesInPool.sort(Comparator.comparingDouble(Guppy::getHealthCoefficient));
        Iterator<Guppy> killingCrowdedGuppies = guppiesInPool.iterator();
        int crowdedGuppies = 0;
        while (this.getGuppyVolumeRequirementInLitres() >= volumeLitres && killingCrowdedGuppies.hasNext()) {
            Guppy weakestGuppy = killingCrowdedGuppies.next();
            if (weakestGuppy.getIsAlive()) {
                weakestGuppy.setIsAlive(false);
                crowdedGuppies++;
            }
        }
        return crowdedGuppies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pool pool = (Pool) o;
        return Double.compare(pool.volumeLitres, volumeLitres) == 0
                && Double.compare(pool.temperatureCelsius, temperatureCelsius) == 0
                && Double.compare(pool.pH, pH) == 0
                && Double.compare(pool.nutrientCoefficient, nutrientCoefficient) == 0
                && identificationNumber == pool.identificationNumber
                && Objects.equals(name, pool.name)
                && Objects.equals(guppiesInPool, pool.guppiesInPool)
                && Objects.equals(randomNumberGenerator, pool.randomNumberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, volumeLitres, temperatureCelsius, pH, nutrientCoefficient, identificationNumber, guppiesInPool, randomNumberGenerator);
    }
}
