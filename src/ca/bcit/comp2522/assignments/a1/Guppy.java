package ca.bcit.comp2522.assignments.a1;

public class Guppy {
    static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    static final int MAXIMUM_AGE_IN_WEEKS = 50;
    static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    static final String DEFAULT_GENUS = "Poecilia";
    static final String DEFAULT_SPECIES = "reticulata";
    static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    static final double ONE_POINT_FIVE = 1.5;

    private static int numberOfGuppiesBorn;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    public Guppy() {
        this.ageInWeeks = 0;
        this.generationNumber = 0;
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        numberOfGuppiesBorn++;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks,
                 boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {
        if (newGenus == null || newGenus.trim().isEmpty()
                || newSpecies == null || newSpecies.trim().isEmpty()
                || newAgeInWeeks < 0 || newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS
                || newGenerationNumber < 0 || newHealthCoefficient < 0.0
                || newHealthCoefficient > 1.0) {
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
        numberOfGuppiesBorn++;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    public final void incrementAge() {
        this.ageInWeeks++;
        if (this.ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.isAlive = false;
        }
    }

    public final String getGenus() {
        return this.genus;
    }

    public final String getSpecies() {
        return this.species;
    }

    public final int getAgeInWeeks() {
        return this.ageInWeeks;
    }

    public final boolean getIsFemale() {
        return this.isFemale;
    }

    public final int getGenerationNumber() {
        return this.generationNumber;
    }

    public final boolean getIsAlive() {
        return this.isAlive;
    }

    public final double getHealthCoefficient() {
        return this.healthCoefficient;
    }

    public final int getIdentificationNumber() {
        return this.identificationNumber;
    }

    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    public final void setAgeInWeeks(int ageInWeeks) {
        if (ageInWeeks < 0) {
            this.ageInWeeks = Math.max(this.ageInWeeks, ageInWeeks);
        } else if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = Math.min(this.ageInWeeks, ageInWeeks);
        } else {
            this.ageInWeeks = ageInWeeks;
        }
    }

    public final void setAlive(boolean alive) {
        isAlive = alive;
    }

    public final void setHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient < 0.0) {
            this.healthCoefficient = Double.max(this.healthCoefficient, healthCoefficient);
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.min(this.healthCoefficient, healthCoefficient);
        } else {
            this.healthCoefficient = healthCoefficient;
        }
    }

    public final double getVolumeNeeded() {
        if (this.ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {
            return  MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (this.ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ONE_POINT_FIVE;
        } else {
            return 0.0;
        }
    }

    public final void changeHealthCoefficient(double delta) {
        this.healthCoefficient += delta;
        if (this.healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = 0.0;
            this.isAlive = false;
        }
        if (this.healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }

    @Override
    public final String toString() {
        return String.format("Guppy's genus: %s\nGuppy's species: %s\n"
                        + "Guppy's age: %d\nGuppy is female: %s\n"
                        + "Guppy's generation number: %d\nGuppy is alive: %s\n"
                        + "Guppy's health coefficient: %f\nGuppy's ID: %d",
                genus, species, ageInWeeks, isFemale, generationNumber,
                isAlive, healthCoefficient, identificationNumber);
    }

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
}
