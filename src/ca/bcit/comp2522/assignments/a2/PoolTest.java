package ca.bcit.comp2522.assignments.a2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class PoolTest {

    private Pool defaultPool;
    private Pool testPool;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {

        defaultPool = new Pool();
        testPool = new Pool("Skookumchuk",
                1000.0,
                40.0,
                7.0,
                0.5);
    }

    @Test
    public void containsConstantCalledDEFAULT_POOL_NAME() {
        assertTrue(Pool.DEFAULT_POOL_NAME.equals(Pool.DEFAULT_POOL_NAME));
    }

    @Test
    public void containsConstantCalledDEFAULT_POOL_TEMP_CELSIUS() {
        assertEquals(40.0, Pool.DEFAULT_POOL_TEMP_CELSIUS, 0.0);
    }

    @Test
    public void containsConstantCalledMINIMUM_POOL_TEMP_CELSIUS() {
        assertEquals(0.0, Pool.MINIMUM_POOL_TEMP_CELSIUS, 0.0);
    }

    @Test
    public void containsConstantCalledMAXIMUM_POOL_TEMP_CELSIUS() {
        assertEquals(100.0, Pool.MAXIMUM_POOL_TEMP_CELSIUS, 0.0);
    }

    @Test
    public void containsConstantCalledNEUTRAL_PH() {
        assertEquals(7.0, Pool.NEUTRAL_PH, 0.0);
    }

    @Test
    public void containsConstantCalledDEFAULT_NUTRIENT_COEFFICIENT() {
        assertEquals(0.5, Pool.DEFAULT_NUTRIENT_COEFFICIENT, 0.0);
    }

    @Test
    public void containsConstantCalledMINIMUM_NUTRIENT_COEFFICIENT() {
        assertEquals(0.0, Pool.MINIMUM_NUTRIENT_COEFFICIENT, 0.0);
    }

    @Test
    public void containsConstantCalledMAXIMUM_NUTRIENT_COEFFICIENT() {
        assertEquals(1.0, Pool.MAXIMUM_NUTRIENT_COEFFICIENT, 0.0);
    }

    @Test
    public void staticPoolCounterIsCorrectlyTrackingPoolsInDefaultConstructor() {
        final int numberAlreadyCreated = Pool.getNumberCreated();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            final Pool aPool = new Pool();
        }
        assertEquals(numberAlreadyCreated + numberCreated, Pool.getNumberCreated());
    }

    @Test
    public void staticPoolCounterIsCorrectlyTrackingPoolsInMultiParamConstructor() {
        final int numberAlreadyCreated = Pool.getNumberCreated();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i)
            new Pool("Skookumchuk",
                    1000.0,
                    Pool.DEFAULT_POOL_TEMP_CELSIUS,
                    Pool.NEUTRAL_PH,
                    Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertEquals(numberAlreadyCreated + numberCreated, Pool.getNumberCreated());
    }

    @Test
    public void defaultPoolIsSetToCorrectValues() {
        assertTrue(defaultPool.getName().equals(Pool.DEFAULT_POOL_NAME));
        assertEquals(0, defaultPool.getVolumeLitres(), 0.0);
        assertEquals(Pool.DEFAULT_POOL_TEMP_CELSIUS, defaultPool.getTemperatureCelsius(), 0.0);
        assertEquals(Pool.NEUTRAL_PH, defaultPool.getPH(), 0.0);
        assertEquals(Pool.DEFAULT_NUTRIENT_COEFFICIENT, defaultPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void multiParamPoolIsSetToCorrectValues() {
        assertTrue(testPool.getName().equals("Skookumchuk"));
        assertEquals(1000.0, testPool.getVolumeLitres(), 0.0);
        assertEquals(Pool.DEFAULT_POOL_TEMP_CELSIUS, testPool.getTemperatureCelsius(), 0.0);
        assertEquals(Pool.NEUTRAL_PH, testPool.getPH(), 0.0);
        assertEquals(Pool.DEFAULT_NUTRIENT_COEFFICIENT, testPool.getNutrientCoefficient(), 0.0);
    }


    @Test
    public void identificationNumbersAreSequentialAndUniqueInDefaultConstruction() {
        final Pool first = new Pool();
        final int firstID = first.getIdentificationNumber() + 1;
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            final Pool littlePool = new Pool();
            assertEquals(firstID + i, littlePool.getIdentificationNumber());
        }
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        final Pool first = new Pool();
        final int firstID = first.getIdentificationNumber() + 1;
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            final Pool newPool = new Pool("Skookumchuk",
                    1000.0,
                    Pool.DEFAULT_POOL_TEMP_CELSIUS,
                    Pool.NEUTRAL_PH,
                    Pool.DEFAULT_NUTRIENT_COEFFICIENT);
            assertEquals(firstID + i, newPool.getIdentificationNumber());
        }
    }

    @Test
    public void poolNameIsCorrectlyFormattedAndStored() {
        final Pool newPool = new Pool("     ohmy     ",
                1000.0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                Pool.NEUTRAL_PH,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertTrue(newPool.getName().equals("Ohmy"));
    }

    @Test
    public void createExceptionWithWhitespaceName() {
        thrown.expect(IllegalArgumentException.class);
        final Pool newPool = new Pool("           ",
                1000.0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                Pool.NEUTRAL_PH,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
    }

    @Test
    public void multiParamConstructorSubsZeroForNegativeVolume() {
        final Pool newPool = new Pool("Skookumchuk",
                -1.0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                Pool.NEUTRAL_PH,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertEquals(0.0, newPool.getVolumeLitres(), 0.0);
    }

    @Test
    public void multiParamConstructorSubsDEFAULTForNegativeTemperature() {
        final Pool newPool = new Pool("Skookumchuk",
                0,
                -1.0,
                Pool.NEUTRAL_PH,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertEquals(Pool.DEFAULT_POOL_TEMP_CELSIUS, newPool.getTemperatureCelsius(), 0.0);
    }

    @Test
    public void multiParamConstructorSubDEFAULTForOverlyHighTemperature() {
        final Pool newPool = new Pool("Skookumchuk",
                0,
                1000.0,
                Pool.NEUTRAL_PH,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertEquals(Pool.DEFAULT_POOL_TEMP_CELSIUS, newPool.getTemperatureCelsius(), 0.0);
    }

    @Test
    public void multiParamConstructorSubsNEUTRALForNegativePH() {
        final Pool newPool = new Pool("Skookumchuk",
                0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                -1,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertEquals(Pool.NEUTRAL_PH, newPool.getPH(), 0.0);
    }

    @Test
    public void multiParamConstructorSubsNEUTRALForOverlargePH() {
        final Pool newPool = new Pool("Skookumchuk",
                0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                15,
                Pool.DEFAULT_NUTRIENT_COEFFICIENT);
        assertEquals(Pool.NEUTRAL_PH, newPool.getPH(), 0.0);
    }

    @Test
    public void multiParamConstructorSubsDEFAULTForNegativeNutrientCoefficient() {
        final Pool newPool = new Pool("Skookumchuk",
                0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                Pool.NEUTRAL_PH,
                -0.01);
        assertEquals(Pool.DEFAULT_NUTRIENT_COEFFICIENT, newPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void multiParamConstructorSubsDEFAULTForOverlargeNutrientCoefficient() {
        final Pool newPool = new Pool("Skookumchuk",
                0,
                Pool.DEFAULT_POOL_TEMP_CELSIUS,
                Pool.NEUTRAL_PH,
                1.01);
        assertEquals(Pool.DEFAULT_NUTRIENT_COEFFICIENT, newPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void nameAccessorReturnsCorrectName() {
        assertTrue(defaultPool.getName().equals(Pool.DEFAULT_POOL_NAME));
        assertTrue(testPool.getName().equals("Skookumchuk"));
    }

    @Test
    public void volumeAccessorReturnsCorrectVolume() {
        assertEquals(0.0, defaultPool.getVolumeLitres(), 0.0);
        assertEquals(1000.0, testPool.getVolumeLitres(), 0.0);
    }

    @Test
    public void temperatureAccessorReturnsCorrectTemperature() {
        assertEquals(40.0, defaultPool.getTemperatureCelsius(), 0.0);
        assertEquals(40.0, testPool.getTemperatureCelsius(), 0.0);
    }

    @Test
    public void nutrientCoefficientAccessorReturnsCorrectPH() {
        assertEquals(Pool.DEFAULT_NUTRIENT_COEFFICIENT, defaultPool.getNutrientCoefficient(), 0.0);
        assertEquals(Pool.DEFAULT_NUTRIENT_COEFFICIENT, testPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void volumeMutatorIgnoresNegativeArguments() {
        final double volume = defaultPool.getVolumeLitres();
        defaultPool.setVolumeLitres(-0.01);
        assertEquals(volume, defaultPool.getVolumeLitres(), 0.0);
    }

    @Test
    public void temperatureMutatorIgnoresNegativeArguments() {
        final double temperature = defaultPool.getTemperatureCelsius();
        defaultPool.setTemperatureCelsius(Pool.MINIMUM_POOL_TEMP_CELSIUS - 0.01);
        assertEquals(temperature, defaultPool.getTemperatureCelsius(), 0.0);
    }

    @Test
    public void temperatureMutatorIgnoresOverlargeArguments() {
        final double temperature = defaultPool.getTemperatureCelsius();
        defaultPool.setTemperatureCelsius(Pool.MAXIMUM_POOL_TEMP_CELSIUS + 0.01);
        assertEquals(temperature, defaultPool.getTemperatureCelsius(), 0.0);
    }

    @Test
    public void pHMutatorIgnoresNegativeArguments() {
        final double pH = defaultPool.getPH();
        defaultPool.setPH(-0.01);
        assertEquals(pH, defaultPool.getPH(), 0.0);
    }

    @Test
    public void pHMutatorIgnoresOverlargeArguments() {
        final double pH = defaultPool.getPH();
        defaultPool.setPH(14.01);
        assertEquals(pH, defaultPool.getPH(), 0.0);
    }

    @Test
    public void nutrientCoefficientMutatorIgnoresNegativeArguments() {
        final double nutrientCoefficient = defaultPool.getNutrientCoefficient();
        defaultPool.setNutrientCoefficient(-0.01);
        assertEquals(nutrientCoefficient, defaultPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void nutrientCoefficientMutatorIgnoresOverlargeArguments() {
        final double nutrientCoefficient = defaultPool.getNutrientCoefficient();
        defaultPool.setNutrientCoefficient(1.01);
        assertEquals(nutrientCoefficient, defaultPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void changeNutrientCoefficientWillNotPermitOverlargeNutrientCoefficients() {
        testPool.changeNutrientCoefficient(1.5);
        assertEquals(1.0, testPool.getNutrientCoefficient(), 0.0);
    }


    @Test
    public void changeNutrientCoefficientWillNotPermitNegativeNutrientCoefficients() {
        testPool.changeNutrientCoefficient(-1.5);
        assertEquals(Pool.MINIMUM_NUTRIENT_COEFFICIENT, testPool.getNutrientCoefficient(), 0.0);
    }

    @Test
    public void changeTemperatureWillNotPermitOverhighTemperature() {
        testPool.changeTemperature(150.0);
        assertEquals(Pool.MAXIMUM_POOL_TEMP_CELSIUS, testPool.getTemperatureCelsius(), 0.0);
    }


    @Test
    public void changeTemperatureWillNotPermitNegativeTemperature() {
        testPool.changeTemperature(-150.0);
        assertEquals(Pool.MINIMUM_POOL_TEMP_CELSIUS, testPool.getTemperatureCelsius(), 0.0);
    }

    @Test
    public void cannotAddNullGuppy() {
        assertFalse(testPool.addGuppy(null));
        assertEquals(0, testPool.getPopulation());
    }

    @Test
    public void addingGuppyReturnsTrue() {
        assertTrue(testPool.addGuppy(new Guppy()));
        assertEquals(1, testPool.getPopulation());
    }

    @Test
    public void removeDeadGuppiesCullsDeadGuppies() {
        final Guppy deadGuppy = new Guppy();
        deadGuppy.setIsAlive(false);
        assertTrue(testPool.addGuppy(deadGuppy));
        assertEquals(0, testPool.getPopulation());
        assertEquals(1, testPool.removeDeadGuppies());
        assertEquals(0, testPool.getPopulation());
    }

    @Test
    public void deadGuppiesNeedNoWater() {
        for (int i = 0; i < 100; ++i) {
            final Guppy deadGuppy = new Guppy();
            deadGuppy.setIsAlive(false);
            assertTrue(testPool.addGuppy(deadGuppy));
        }
        assertEquals(0.0, testPool.getGuppyVolumeRequirementInLitres(), 0.0);
    }

    @Test
    public void emptyPoolHasAverageAgeOfZero() {
        assertEquals(0.0, testPool.getAverageAgeInWeeks(), 0.0);
    }

    @Test
    public void poolOfLivingGuppiesCalculatesCorrectAverageAge() {
        final Random random = new Random();
        final int count = 100;
        double ageSum = 0;
        for (int i = 0; i < count; ++i) {
            final int randomAge = random.nextInt(50);
            ageSum += randomAge;
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    randomAge,
                    true,
                    3,
                    0.75);
            testPool.addGuppy(newGuppy);
        }
        assertEquals(ageSum / count, testPool.getAverageAgeInWeeks(), 0.05);
    }

    @Test
    public void deadGuppiesAreNotCountedWhenCalculatingAverageAge() {
        for (int i = 0; i < 100; ++i) {
            final Guppy deadGuppy = new Guppy();
            deadGuppy.setIsAlive(false);
            assertTrue(testPool.addGuppy(deadGuppy));
        }
        assertEquals(0.0, testPool.getAverageAgeInWeeks(), 0.0);
    }

    @Test
    public void deadGuppiesAreNotCountedWhenCalculatingAverageHealthCoefficient() {
        for (int i = 0; i < 100; ++i) {
            final Guppy deadGuppy = new Guppy();
            deadGuppy.setIsAlive(false);
            assertTrue(testPool.addGuppy(deadGuppy));
        }
        assertEquals(0.0, testPool.getAverageHealthCoefficient(), 0.0);
    }

    @Test
    public void calculatesAverageHealthCoefficientCorrectly() {
        final Random random = new Random();
        final int count = 100;
        double healthCoefficientSum = 0;
        for (int i = 0; i < count; ++i) {
            final double randomHealthCoefficient = random.nextDouble();
            healthCoefficientSum += randomHealthCoefficient;
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    0,
                    true,
                    3,
                    randomHealthCoefficient);
            testPool.addGuppy(newGuppy);
        }
        assertEquals(healthCoefficientSum / count, testPool.getAverageHealthCoefficient(), 0.05);
    }

    @Test
    public void emptyPoolHasNoFemales() {
        assertEquals(0.0, testPool.getFemalePercentage(), 0.0);
    }

    @Test
    public void mixedPoolCalculatesFemalePercentageCorrectly() {
        final Random random = new Random();
        final int count = 100;
        int females = 0;
        for (int i = 0; i < count; ++i) {
            final boolean female = random.nextBoolean();
            if (female) { females++; }
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    0,
                    female,
                    3,
                    0.75);
            testPool.addGuppy(newGuppy);
        }
        assertEquals((double) females / count, testPool.getFemalePercentage(), 0.05);
    }

    @Test
    public void spawnIsFiftyPercent() {
        int couldBirth = 0;
        final int count = 100;
        final Random random = new Random();
        final Guppy newGuppy = new Guppy("Poecilia",
                "elegans",
                25,
                true,
                3,
                0.75);
        testPool.addGuppy(newGuppy);
        for (int i = 0; i < count; i++) {
            final int oldPop = testPool.getPopulation();
            testPool.spawn();
            final int newPop = testPool.getPopulation();
            if (oldPop < newPop) {
                couldBirth++;
            }
            System.out.println(couldBirth);
        }
        assertTrue(40 <= couldBirth && couldBirth <= 60);
    }

    @Test
    public void emptyPoolHasNoMedianAge() {
        assertEquals(0.0, testPool.getMedianAge(), 0.0);
    }

    @Test public void allOldGuppiesDie() {
        final int count = 100;
        for (int i = 0; i < count; ++i) {
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    49,
                    true,
                    3,
                    0.75);
            testPool.addGuppy(newGuppy);
            newGuppy.setAgeInWeeks(50);
        }
        assertEquals(100, testPool.incrementAges(), 0.0);
    }

    @Test
    public void medianAgeIsCalculatedCorrectly() {
        final Random random = new Random();
        final int count = 100;
        final double medianAge;
        final ArrayList<Integer> ageArray = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            final int randomAge = random.nextInt(50);
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    randomAge,
                    true,
                    3,
                    0.75);
            testPool.addGuppy(newGuppy);
            ageArray.add(randomAge);
        }
        Collections.sort(ageArray);
        if (ageArray.size() % 2 == 0) {
            final int medianAgeIndex = ageArray.size() / 2;
            final int medianAgeIndexOther = Math.floorDiv(ageArray.size() + 1, 2);
            medianAge = Math.floorDiv(ageArray.get(medianAgeIndex) + ageArray.get(medianAgeIndexOther), 2);
        } else {
            final int medianAgeIndex = Math.floorDiv(ageArray.size() + 1, 2);
            medianAge = ageArray.get(medianAgeIndex);
        }
        assertEquals(medianAge, testPool.getMedianAge(), 0.05);
    }

    @Test
    public void weakGuppiesDieFromOvercrowding() {
        final int count = 50;
        for (int i = 0; i < count; ++i) {
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    15,
                    true,
                    3,
                    0.9);
            testPool.addGuppy(newGuppy);
        }
        for (int i = 0; i < count; ++i) {
            final Guppy newGuppy = new Guppy(  "Poecilia",
                    "elegans",
                    15,
                    true,
                    3,
                    0.5);
            testPool.addGuppy(newGuppy);
        }
        testPool.setVolumeLitres(100.0);
        final int dead = testPool.adjustForCrowding();
        assertEquals(dead, testPool.adjustForCrowding(), 0.05);
    }
}