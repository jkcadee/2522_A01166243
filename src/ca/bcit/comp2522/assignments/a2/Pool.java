package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;

public class Pool {
    static final String DEFAULT_POOL_NAME = "Unnamed";
    static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    static final double NEUTRAL_PH = 7.0;
    static final double MINIMUM_PH = 0.0;
    static final double MAXIMUM_PH = 14.0;
    static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

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
        this(DEFAULT_POOL_NAME, 0.0, DEFAULT_POOL_TEMP_CELSIUS, NEUTRAL_PH, DEFAULT_NUTRIENT_COEFFICIENT);
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

    public void setpH(double pH) {
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

    public double getpH() {
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

}
