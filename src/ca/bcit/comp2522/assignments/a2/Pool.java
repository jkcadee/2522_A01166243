package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Objects;
import java.util.Arrays;

/**
 * Creates a realistic simulation of a pool.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Pool {
    /**
     * Default constant for pool name.
     */
    public static final String DEFAULT_POOL_NAME = "Unnamed";
    /**
     * Default constant for pool temperature.
     */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    /**
     * Minimum constant for pool temperature.
     */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    /**
     * Maximum constant for pool temperature.
     */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    /**
     * Neutral constant for pH.
     */
    public static final double NEUTRAL_PH = 7.0;
    /**
     * Minimum constant for pH.
     */
    public static final double MINIMUM_PH = 0.0;
    /**
     * Maximum constant for pH.
     */
    public static final double MAXIMUM_PH = 14.0;
    /**
     * Default constant for nutrient coefficient.
     */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    /**
     * Minimum constant for nutrient coefficient.
     */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    /**
     * Maximum constant for nutrient coefficient.
     */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;
    /**
     * One litre.
     */
    public static final double ONE_LITRE = 1000.0;

    private static int numberOfPools;
    
    private final String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private final int identificationNumber;
    private final ArrayList<Guppy> guppiesInPool;
    private final Random randomNumberGenerator;

    /**
     * Default constructor for the Pool object.
     */

    public Pool() {
        this(DEFAULT_POOL_NAME, 0.0, DEFAULT_POOL_TEMP_CELSIUS,
                NEUTRAL_PH, DEFAULT_NUTRIENT_COEFFICIENT);
    }

    /**
     * Constructor for the Pool object.
     * This constructor is used when arguments are specified.
     * Will increment numberOfPools by one when called.
     *
     * @param name Name of the Pool. String.
     * @param volumeLitres The Pool's volume in litres. Double.
     * @param temperatureCelsius The Pool's temperature in celsius. Double.
     * @param pH The Pool's pH level. Double.
     * @param nutrientCoefficient The Pool's nutrient coefficient. Double.
     */

    public Pool(final String name, final double volumeLitres,
                final double temperatureCelsius, final double pH,
                final double nutrientCoefficient) {
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
            this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
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

    /**
     * Sets the current volumeLitres of the Pool to the value passed in the parameter.
     *
     * @param volumeLitres The new value that volumeLitres will be set to.
     */

    public void setVolumeLitres(final double volumeLitres) {
        if (volumeLitres < 0) {
            this.volumeLitres = 0.0;
        } else {
            this.volumeLitres = volumeLitres;
        }
    }

    /**
     * Sets the current temperatureCelsius of the Pool to the value passed in the parameter.
     *
     * @param temperatureCelsius The new value that temperatureCelsius will be set to.
     */

    public void setTemperatureCelsius(final double temperatureCelsius) {
        if (MINIMUM_POOL_TEMP_CELSIUS <= temperatureCelsius
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        } else {
            this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }
    }

    /**
     * Sets the current pH of the Pool to the value passed in the parameter.
     *
     * @param pH The new value that pH will be set to.
     */

    public void setPH(final double pH) {
        if (MINIMUM_PH <= pH && pH <= MAXIMUM_PH) {
            this.pH = pH;
        } else {
            this.pH = NEUTRAL_PH;
        }
    }

    /**
     * Sets the current nutrientCoefficient of the Pool to the value passed in the parameter.
     *
     * @param nutrientCoefficient The new value nutrientCoefficient will be set to.
     */

    public void setNutrientCoefficient(final double nutrientCoefficient) {
        if (MINIMUM_NUTRIENT_COEFFICIENT <= nutrientCoefficient
                && nutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = nutrientCoefficient;
        } else {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }

    }

    /**
     * Gets the current Name of the Pool.
     *
     * @return The value that is stored at Name.
     */

    public String getName() {
        return name;
    }

    /**
     * Gets the current volume litres of the Pool.
     *
     * @return The value that is stored at volumeLitres.
     */

    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Gets the current temperature celsius of the Pool.
     *
     * @return The value that is stored at temperatureCelsius.
     */

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Gets the current pH of the Pool.
     *
     * @return The value that is stored at pH.
     */

    public double getPH() {
        return pH;
    }

    /**
     * Gets the current nutrient coefficient of the Pool.
     *
     * @return The value that is stored at nutrientCoefficient.
     */

    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * Gets the current identification number of the Pool.
     *
     * @return The value that is stored at identificationNumber.
     */

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Changes the nutrient coefficient of the Pool based on the passed in value.
     * If the value is invalid, it will default to either a minimum or maximum value.
     *
     * @param delta The value that is either added or subtracted to the current nutrientCoefficient.
     */

    public void changeNutrientCoefficient(final double delta) {
        this.nutrientCoefficient += delta;
        if (nutrientCoefficient <= MINIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else if (nutrientCoefficient >= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        }
    }

    /**
     * Changes the temperature of the Pool based on the passed in value.
     * If the value is invalid, it will default to either a minimum or maximum value.
     *
     * @param delta The value that is either added or subtracted to the current temperatureCelsius.
     */

    public void changeTemperature(final double delta) {
        this.temperatureCelsius += delta;
        if (temperatureCelsius <= MINIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else if (temperatureCelsius >= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        }
    }

    /**
     * Gets the total number of Pools created.
     *
     * @return The total number of Pools created.
     */

    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * Adds a Guppy to the Pool.
     * If the Guppy is equal to null, it is not added.
     *
     * @param guppy The Guppy to be added.
     * @return A boolean signifying whether or not the Guppy was added successfully.
     */

    public boolean addGuppy(final Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        guppiesInPool.add(guppy);
        return true;
    }

    /**
     * Gets the current amount of living Guppies in the Pool.
     *
     * @return The amount of living Guppies in the Pool.
     */

    public int getPopulation() {
        int numberOfAliveGuppies = 0;
        for (Guppy aliveGuppy : guppiesInPool) {
            if (aliveGuppy.getIsAlive()) {
                numberOfAliveGuppies++;
            }
        }
        return numberOfAliveGuppies;
    }

    /**
     * Applies the current nutrientCoefficient of the Pool to each Guppy.
     * This determines if the starve and die or not.
     * The method will return the amount of Guppies who starved to death.
     *
     * @return The amount of Guppies who starved to death.
     */

    public int applyNutrientCoefficient() {
        Iterator<Guppy> guppies = guppiesInPool.iterator();
        int starvedGuppies = 0;
        while (guppies.hasNext()) {
            Guppy currentGuppy = guppies.next();
            double nutrients = randomNumberGenerator.nextDouble();
            if (nutrients > this.nutrientCoefficient && currentGuppy.getIsAlive()) {
                currentGuppy.setIsAlive(false);
                starvedGuppies++;
            }
        }
        return starvedGuppies;
    }

    /**
     * Removes any Guppies that are dead from the Pool.
     * Returns the amount of Guppies removed from the Pool.
     *
     * @return Amount of dead Guppies removed from the Pool.
     */

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

    /**
     * Gets the amount of water the living Guppies require to survive.
     *
     * @return The amount of water all living Guppies need to survive.
     */

    public double getGuppyVolumeRequirementInLitres() {
        double guppyVolumeRequired = 0.0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive()) {
                guppyVolumeRequired += aliveGuppies.getVolumeNeeded();
           }
        }
        guppyVolumeRequired /= ONE_LITRE;
        return guppyVolumeRequired;
    }

    /**
     * Gets the average age of all living Guppies in the Pool.
     *
     * @return The average age of all living Guppies.
     */

    public double getAverageAgeInWeeks() {
        double averageAgeInWeeks = 0.0;
        int livingGuppies = 0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive()) {
                averageAgeInWeeks += aliveGuppies.getAgeInWeeks();
                livingGuppies++;
            }
        }
        if (livingGuppies == 0) {
            return 0.0;
        }
        return averageAgeInWeeks / livingGuppies;
    }

    /**
     * Gets the average health coefficient of all living Guppies in the Pool.
     *
     * @return The average health coefficient of all living Guppies.
     */

    public double getAverageHealthCoefficient() {
        double averageHealthCoefficient = 0.0;
        int livingGuppies = 0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive()) {
                averageHealthCoefficient += aliveGuppies.getHealthCoefficient();
                livingGuppies++;
            }
        }
        if (livingGuppies == 0) {
            return 0.0;
        }
        return averageHealthCoefficient / livingGuppies;
    }

    /**
     * Gets the percentage of females of all living Guppies in the Pool.
     *
     * @return The percentage of females of all living Guppies.
     */

    public double getFemalePercentage() {
        double averageFemalePercentage = 0;
        int livingFemaleGuppies = 0;
        for (Guppy aliveGuppies : guppiesInPool) {
            if (aliveGuppies.getIsAlive() && aliveGuppies.getIsFemale()) {
                averageFemalePercentage++;
                livingFemaleGuppies++;
            }
        }
        if (livingFemaleGuppies == 0) {
            return 0.0;
        }
        return averageFemalePercentage / guppiesInPool.size();
    }

    /**
     * Gets the median age of all living Guppies in the Pool.
     *
     * @return The median age of all living Guppies.
     */

    public double getMedianAge() {
        Iterator<Guppy> guppies = guppiesInPool.iterator();
        int aliveGuppies = 0;
        for (Guppy aliveGuppy: guppiesInPool) {
            if (aliveGuppy.getIsAlive()) {
                aliveGuppies++;
            }
        }
        if (aliveGuppies == 0) {
            return 0.0;
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
        if (guppyAgeArray.length % 2 == 0) {
            int medianAgeIndex = guppyAgeArray.length / 2;
            int medianAgeIndexOther = Math.floorDiv(guppyAgeArray.length + 1, 2);
            return Math.floorDiv(guppyAgeArray[medianAgeIndex]
                    + guppyAgeArray[medianAgeIndexOther], 2);
        }
        int medianAgeIndex = Math.floorDiv(guppyAgeArray.length + 1, 2);
        return guppyAgeArray[medianAgeIndex];
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Pool.
     */

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

    /**
     * Spawns new Guppies if the current Guppy fulfills the requirements to.
     * It adds all the babies to a separate list and adds that list
     * into the main list after,
     *
     * @return The amount of newly generated baby Guppies.
     */

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

    /**
     * Increments all the ages of each Guppy in the Pool.
     * If the Guppy exceeds the max age, it will be killed.
     *
     * @return The amount of Guppies killed from old age.
     */

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

    /**
     * Kills Guppies if the water volume of the current population
     * exceeds that of the current water volume of the Pool itself.
     * The Guppy with the lowest health coefficient will be killed first.
     * Until the required water volume of the Guppies is less than or equal
     * to the water volume of the Pool itself.
     *
     * @return The amount of Guppies killed from overcrowding.
     */

    public int adjustForCrowding() {
        guppiesInPool.sort(Comparator.comparingDouble(Guppy::getHealthCoefficient));
        Iterator<Guppy> killingCrowdedGuppies = guppiesInPool.iterator();
        int crowdedGuppies = 0;
        double volumeRequirement = this.getGuppyVolumeRequirementInLitres();
        while (volumeRequirement > volumeLitres && killingCrowdedGuppies.hasNext()) {
            Guppy weakestGuppy = killingCrowdedGuppies.next();
            if (weakestGuppy.getIsAlive()) {
                volumeRequirement -= weakestGuppy.getVolumeNeeded() / ONE_LITRE;
                weakestGuppy.setIsAlive(false);
                crowdedGuppies++;
            }
        }
        return crowdedGuppies;
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
    public boolean equals(final Object o) {
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

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(name, volumeLitres, temperatureCelsius, pH,
                nutrientCoefficient, identificationNumber, guppiesInPool, randomNumberGenerator);
    }
}
