package ca.bcit.comp2522.assignments.a1;

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
        this.identificationNumber = numberOfGuppiesBorn;
    }

    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {
        this.genus = newGenus;
        this.species = newSpecies.toLowerCase();
    }
}
