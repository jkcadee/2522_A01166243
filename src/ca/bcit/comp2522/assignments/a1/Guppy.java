package ca.bcit.comp2522.assignments.a1;

import ca.bcit.comp2522.labs.lab01.Hare;

public class Guppy {
    final static int YOUNG_FISH_AGE_IN_WEEKS = 10;
    final static int MATURE_FISH_AGE_IN_WEEKS = 30;
    final static int MAXIMUM_AGE_IN_WEEKS = 50;
    final static double MINIMUM_WATER_VOLUME_ML = 250.0;
    final static String DEFAULT_GENUS = "Poecilia";
    final static String DEFAULT_SPECIES = "reticulata";
    final static double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    final static double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    final static double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    private static int numberOfGuppiesBorn;

    public Guppy() {
        this.ageInWeeks = 0;
        this.generationNumber = 0;
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        this.identificationNumber = numberOfGuppiesBorn+1;
    }

    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {
        this.genus = newGenus.substring(0, 1).toUpperCase() + newGenus.substring(1).toLowerCase();
        this.species = newSpecies.toLowerCase();
        this.ageInWeeks = Math.max(newAgeInWeeks, 0);
        this.isFemale = newIsFemale;
        if (newGenerationNumber < 0) {
            this.generationNumber = 1;
        } else {
            this.generationNumber = newGenerationNumber;
        }
        if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.min(newHealthCoefficient, MAXIMUM_HEALTH_COEFFICIENT);
        } else if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.max(newHealthCoefficient, MINIMUM_HEALTH_COEFFICIENT);
        } else {
            this.healthCoefficient = newHealthCoefficient;
        }
        this.isAlive = true;
        this.identificationNumber = numberOfGuppiesBorn+1;
    }

    public void incrementAge(){
        this.ageInWeeks++;
        if (this.ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.isAlive = false;
        }
    }

    public String getGenus() {
        return this.genus;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAgeInWeeks() {
        return this.ageInWeeks;
    }

    public boolean isFemale() {
        return this.isFemale;
    }

    public int getGenerationNumber() {
        return this.generationNumber;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public double getHealthCoefficient() {
        return this.healthCoefficient;
    }

    public int getIdentificationNumber() {
        return this.identificationNumber;
    }

    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    public void setAgeInWeeks(int ageInWeeks) {
        if (ageInWeeks < 0) {
            this.ageInWeeks = Math.max(this.ageInWeeks, ageInWeeks);
        } else if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = Math.min(this.ageInWeeks, ageInWeeks);
        } else {
            this.ageInWeeks = ageInWeeks;
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient < 0.0) {
            this.healthCoefficient = Double.max(this.healthCoefficient, healthCoefficient);
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = Double.min(this.healthCoefficient, healthCoefficient);
        } else {
            this.healthCoefficient = healthCoefficient;
        }
    }

    public double getVolumeNeeded() {
        if (this.ageInWeeks < 10) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.ageInWeeks <= 30) {
            return  MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (this.ageInWeeks < 50) {
            return MINIMUM_WATER_VOLUME_ML * 1.5;
        } else {
            return 0.0;
        }
    }

    public void changeHealthCoefficient(double delta) {
        this.healthCoefficient += delta;
        if (this.healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT ) {
            this.healthCoefficient = 0.0;
            this.isAlive = false;
        }
        if (this.healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }

    @Override
    public String toString() {
        return String.format("Guppy's genus: %s\nGuppy's species: %s\n" +
                "Guppy's age: %d\nGuppy is female: %s\n" +
                "Guppy's generation number: %d\nGuppy is alive: %s\n" +
                "Guppy's health coefficient: %f\nGuppy's ID: %d",
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

        if (object.getAgeInWeeks() == this.getAgeInWeeks() &&
                object.getGenerationNumber() == this.generationNumber &&
                object.getGenus().equals(this.genus) &&
                object.getHealthCoefficient() == this.healthCoefficient &&
                object.getSpecies().equals(this.species)) {
            return true;
        } else {
            return false;
        }
    }

}

class Driver {
    public static void main(String[] args) {
        Guppy newGuppy = new Guppy();
        Guppy newGuppy2 = new Guppy("gUppy", "GUPPY", 5, false, 30, 1.0);
        System.out.println(newGuppy2.getGenus());
        System.out.println(newGuppy2.getSpecies());
        newGuppy.changeHealthCoefficient(0.2);
        System.out.println(newGuppy.getIdentificationNumber());
        System.out.println(newGuppy.getHealthCoefficient());
        newGuppy.setAgeInWeeks(30);
        System.out.println(newGuppy.getAgeInWeeks());
        System.out.println(newGuppy.getVolumeNeeded());
    }
}