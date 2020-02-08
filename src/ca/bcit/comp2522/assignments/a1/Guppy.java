package ca.bcit.comp2522.assignments.a1;

/**
 * Creates a realistic simulation of a guppy fish.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Guppy {
    /**
     * Constant signifying a young Guppy's age.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    /**
     * Constant signifying a mature Guppy's age.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    /**
     * Constant signifying a Guppy's maximum age.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;
    /**
     * Constant signifying the minimum water volume in mL.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    /**
     * Constant signifying a Guppy's default genus.
     */
    public static final String DEFAULT_GENUS = "Poecilia";
    /**
     * Constant signifying a Guppy's default species.
     */
    public static final String DEFAULT_SPECIES = "reticulata";
    /**
     * Constant signifying a Guppy's default health coefficient.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    /**
     * Constant signifying a Guppy's minimum health coefficient.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    /**
     * Constant signifying a Guppy's maximum health coefficient.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    /**
     * Constant signifying the number 1.5.
     */
    public static final double ONE_POINT_FIVE = 1.5;
    /**
     * Constant signifying the amount of water a dead Guppy needs.
     */
    public static final double DEAD_GUPPY_WATER_VOL = 0.0;

    private static int numberOfGuppiesBorn;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    /**
     * Constructs a new Guppy object.
     * This constructor is used when no arguments are specified.
     * Will increment numberOfGuppiesBorn by one when called.
     */

    public Guppy() {
        this.ageInWeeks = 0;
        this.generationNumber = 0;
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        this.identificationNumber = ++numberOfGuppiesBorn;
    }

    /**
     * Creates a new Guppy object.
     * This constructor is used when arguments are specified.
     * Will increment numberOfGuppiesBorn by one when called.
     *
     * @param newGenus The first parameter for this method. It is a String type value.
     * @param newSpecies The second parameter for this method. It is a String type value.
     * @param newAgeInWeeks The third parameter for this method. It is a int type value.
     * @param newIsFemale The first parameter for this method. It is a boolean type value.
     * @param newGenerationNumber The first parameter for this method. It is a int type value.
     * @param newHealthCoefficient The first parameter for this method. It is a double type value.
     *
     */

    public Guppy(final String newGenus, final String newSpecies, final int newAgeInWeeks,
                 final boolean newIsFemale, final int newGenerationNumber,
                 final double newHealthCoefficient) {
        if (newGenus == null || newGenus.trim().isEmpty()
                || newSpecies == null || newSpecies.trim().isEmpty()
                || newAgeInWeeks < 0 || newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS
                || newGenerationNumber < 0 || newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT
                || newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            throw new IllegalArgumentException("Value is invalid.");
        }
        this.genus = newGenus.trim().substring(0, 1).toUpperCase()
                + newGenus.trim().substring(1).toLowerCase();
        this.species = newSpecies.trim().toLowerCase();
        this.ageInWeeks = Math.max(newAgeInWeeks, 0);
        this.isFemale = newIsFemale;
        this.generationNumber = newGenerationNumber;
        if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.min(newHealthCoefficient, MAXIMUM_HEALTH_COEFFICIENT);
        } else if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.max(newHealthCoefficient, MINIMUM_HEALTH_COEFFICIENT);
        } else {
            this.healthCoefficient = newHealthCoefficient;
        }
        this.isAlive = true;
        this.identificationNumber = ++numberOfGuppiesBorn;
    }

    /**
     * Gets the value at the attribute genus.
     *
     * @return The String type attribute genus.
     */

    public final String getGenus() {
        return this.genus;
    }

    /**
     * Gets the value at the attribute species.
     *
     * @return The String type attribute species.
     */

    public final String getSpecies() {
        return this.species;
    }

    /**
     * Gets the value at the attribute ageInWeeks.
     *
     * @return The int type attribute ageInWeeks.
     */

    public final int getAgeInWeeks() {
        return this.ageInWeeks;
    }

    /**
     * Gets the value at the attribute isFemale.
     *
     * @return The boolean type attribute isFemale.
     */

    public final boolean getIsFemale() {
        return this.isFemale;
    }

    /**
     * Gets the value at the attribute generationNumber.
     *
     * @return The int type attribute generationNumber.
     */

    public final int getGenerationNumber() {
        return this.generationNumber;
    }

    /**
     * Gets the value at the attribute isAlive.
     *
     * @return The boolean type attribute isAlive.
     */

    public final boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     * Gets the value at the attribute healthCoefficient.
     *
     * @return The double type attribute healthCoefficient.
     */

    public final double getHealthCoefficient() {
        return this.healthCoefficient;
    }

    /**
     * Gets the value at the attribute identificationNumber.
     *
     * @return The int type attribute identificationNumber.
     */

    public final int getIdentificationNumber() {
        return this.identificationNumber;
    }

    /**
     * Gets the value at the attribute getNumberOfGuppiesBorn.
     *
     * @return The int type attribute getNumberOfGuppiesBorn.
     */

    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Sets the value at the attribute ageInWeeks.
     * If the value is < 0, then it will take the current maximum at ageInWeeks.
     * If the value is > MAXIMUM_AGE_IN_WEEKS then it will take the current minimum at ageInWeeks.
     *
     * @param ageInWeeks The only parameter for this method. It is an integer type value.
     */

    public final void setAgeInWeeks(final int ageInWeeks) {
        if (ageInWeeks < 0) {
            this.ageInWeeks = Math.max(this.ageInWeeks, ageInWeeks);
        } else if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = Math.min(this.ageInWeeks, ageInWeeks);
        } else {
            this.ageInWeeks = ageInWeeks;
        }
    }

    /**
     * Sets the value at the attribute isAlive.
     *
     * @param alive The only parameter for this method. It is an boolean type value.
     */

    public final void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Sets the value at the attribute healthCoefficient.
     * If the value is < 0, then it will take the current maximum at healthCoefficient.
     * If the value is > MAXIMUM_HEALTH_COEFFICIENT then it will take
     * the current minimum at healthCoefficient.
     *
     * @param healthCoefficient The only parameter for this method. It is an double type value.
     */

    public final void setHealthCoefficient(final double healthCoefficient) {
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.max(this.healthCoefficient, healthCoefficient);
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.min(this.healthCoefficient, healthCoefficient);
        } else {
            this.healthCoefficient = healthCoefficient;
        }
    }

    /**
     * Increments the value in the attribute ageInWeeks.
     * If the value at ageInWeeks is greater than MAXIMUM_AGE_IN_WEEKS,
     * isAlive will be made false.
     */

    public final void incrementAge() {
        this.ageInWeeks++;
        if (this.ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.isAlive = false;
        }
    }

    /**
     * Calculates the water volume needed for the Guppy.
     * The value is dependent on the Guppy's ageInWeeks attribute.
     *
     * @return A double signifying the amount of water the Guppy needs.
     */

    public final double getVolumeNeeded() {
        if (this.ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {
            return  MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (this.ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ONE_POINT_FIVE;
        } else {
            return DEAD_GUPPY_WATER_VOL;
        }
    }

    /**
     * Changes the healthCoefficient attribute based on the value
     * passed in the parameter delta.
     * If healthCoefficient < MINIMUM_HEALTH_COEFFICIENT, then isAlive becomes false.
     * If healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT,
     * then healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT.
     *
     * @param delta The only parameter for this method. It is an double type value.
     */

    public final void changeHealthCoefficient(final double delta) {
        this.healthCoefficient += delta;
        if (this.healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
            this.isAlive = false;
        }
        if (this.healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param obj The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Guppy object = (Guppy) obj;
        return object.getAgeInWeeks() == this.getAgeInWeeks()
                && object.getGenerationNumber() == this.generationNumber
                && object.getGenus().equals(this.genus)
                && object.getHealthCoefficient() == this.healthCoefficient
                && object.getSpecies().equals(this.species)
                && object.getIsFemale() == this.isFemale
                && object.getIsAlive() == this.isAlive;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Guppy.
     */

    @Override
    public final String toString() {
        return String.format("Guppy's genus: %s\nGuppy's species: %s\n"
                        + "Guppy's age: %d\nGuppy is female: %s\n"
                        + "Guppy's generation number: %d\nGuppy is alive: %s\n"
                        + "Guppy's health coefficient: %f\nGuppy's ID: %d",
                genus, species, ageInWeeks, isFemale, generationNumber,
                isAlive, healthCoefficient, identificationNumber);
    }

}
