package ca.bcit.comp2522.labs.lab02;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * MathematicsTest.
 *
 * @author BCIT
 * @version 2.0
 */
public class MathematicsTest {

    /**
     * The Mathematics object to test.
     */
    private Mathematics math;

    /**
     * Creates a new Mathematics objects before each test is executed.
     *
     * @throws Exception if a Mathematics object cannot be created.
     */
    @Before
    public void setUp() throws Exception {
        math = new Mathematics();
    }

    /**
     * Test method for the value of PI.
     */
    @Test
    public void testPIValue() {
        assertEquals(3.14159, Mathematics.PI, 0.00001);
    }

    /**
     * Test method for the value of ONE_FOOT_TO_KILOMETER_RATIO.
     */
    @Test
    public void testFeetToKMRatioValue() {
        assertEquals(0.0003048, Mathematics.ONE_FOOT_TO_KILOMETRE_RATIO, 0.0000001);
    }

    /**
     * Tests getCircleArea method.
     */
    @Test
    public void testGetCircleArea1() {
        final double area = math.getCircleArea(1.0);
        assertEquals(3.14159, area, 0.00001);
    }

    /**
     * Tests getCircleArea method.
     */
    @Test
    public void testGetCircleArea2() {
        final double area = math.getCircleArea(15.0);
        assertEquals(706.85775, area, 0.00001);
    }

    /**
     * Tests getSquareArea method.
     */
    @Test
    public void testGetSquareArea1() {
        final double area = math.getSquareArea(2.0);
        assertEquals(4.0, area, 0.1);
    }

    /**
     * Tests getSquareArea method.
     */
    @Test
    public void testGetSquareArea2() {
        final double area = math.getSquareArea(32.0);
        assertEquals(1024.0, area, 0.1);
    }

    /**
     * Tests add method.
     */
    @Test
    public void testAdd1() {
        final double sum = math.add(6.0, 7.0);
        assertEquals(13.0, sum, 0.1);
    }

    /**
     * Tests add method.
     */
    @Test
    public void testAdd2() {
        final double sum = math.add(-6.0, 6.0);
        assertEquals(0.0, sum, 0.1);
    }

    /**
     * Tests multiply method.
     */
    @Test
    public void testMultiply1() {
        final double product = math.multiply(1.0, 5.0);
        assertEquals(5.0, product, 0.1);
    }

    /**
     * Tests multiply method.
     */
    @Test
    public void testMultiply2() {
        final double product = math.multiply(20.0, 20.0);
        assertEquals(400.0, product, 0.1);
    }

    /**
     * Tests subtract method.
     */
    @Test
    public void testSubtract1() {
        final double difference = math.subtract(0.0, 20.0);
        assertEquals(-20.0, difference, 0.1);
    }

    /**
     * Tests subtract method.
     */
    @Test
    public void testSubtract2() {
        final double difference = math.subtract(20.0, 20.0);
        assertEquals(0.0, difference, 0.1);
    }

    /**
     * Tests divide method.
     */
    @Test
    public void testDivide1() {
        final double division = math.divide(20, 10);
        assertEquals(2.0, division, 0.00001);
    }

    /**
     * Tests divide method.
     */
    @Test
    public void testDivide2() {
        final double division = math.divide(20, 0);
        assertEquals(0.0, division, 0.00001);
    }

    /**
     * Tests absolute value method.
     */
    @Test
    public void testAbsolute1() {
        final int abs = math.absoluteValue(1);
        assertEquals(1, abs);
    }

    /**
     * Tests absolute value method.
     */
    @Test
    public void testAbsolute2() {
        final int abs = math.absoluteValue(-5000);
        assertEquals(5000, abs);
    }

    /**
     * Tests the random number generator method.
     */
    @Test
    public void testRandomNumberBetweenTenAndTwentyButNotFifteen() {
        final HashSet<Integer> values = new HashSet<Integer>();

        for (int i = 0; i < 10000; i++) {
            final int number = math.getRandomNumberBetweenTenAndTwentyButNotFifteen();
            final boolean lessThanTen = number < 10;
            final boolean greaterThanTwenty = number > 20;
            final boolean notFifteen = number == 15;

            assertFalse(lessThanTen);
            assertFalse(greaterThanTwenty);
            assertFalse(notFifteen);
            values.add(number);
        }

        assertEquals(10, values.size());
    }

    /**
     * Tests the method that converts feet to kilometres.
     */
    @Test
    public void testFootToKM1() {
        final double km = math.convertFeetToKilometres(1.0);
        assertEquals(0.0003048, km, 0.1);
    }

    /**
     * Tests the method that converts feet to kilometres.
     */
    @Test
    public void testFootToKM2() {
        final double km = math.convertFeetToKilometres(892.0);
        assertEquals(0.272186, km, 0.1);
    }

    /**
     * Tests the method that sums the positive integers
     * between 0 and the specified value.
     */
    @Test
    public void testSumOfInts() {
        final int sumOfInts = math.sumOfInts(0);
        assertEquals(0, sumOfInts);
    }

    /**
     * Tests the method that sums the positive integers
     * between 0 and the specified value.
     */
    @Test
    public void testSumOfInts2() {
        final int sumOfInts = math.sumOfInts(10);
        assertEquals(55, sumOfInts);
    }

    /**
     * Tests the method that sums the positive integers
     * between 0 and the specified value.
     */
    @Test
    public void testSumOfInts3() {
        final int sumOfInts = math.sumOfInts(49);
        assertEquals(1225, sumOfInts);
    }

    /**
     * Tests the method that sums the positive integers
     * between 0 and the specified value.
     */
    @Test
    public void testSumOfInts4() {
        final int sumOfInts = math.sumOfInts(-49);
        assertEquals(0, sumOfInts);
    }

    /**
     * Tests the method that returns true if a specified
     * number is positive, else false.
     */
    @Test
    public void testIsPositive() {
        final boolean isPositive = math.isPositive(2);
        assertEquals(true, isPositive);
    }

    /**
     * Tests the method that returns true if a specified
     * number is positive, else false.
     */
    @Test
    public void testIsPositive2() {
        final boolean isPositive = math.isPositive(-2);
        assertEquals(false, isPositive);
    }

    /**
     * Tests the method that returns true if a specified
     * number is positive, else false.
     */
    @Test
    public void testIsPositive3() {
        final boolean isPositive = math.isPositive(0);
        assertEquals(false, isPositive);
    }

    /**
     * Tests the method that returns true if a specified
     * number is even, else false.
     */
    @Test
    public void testIsEven() {
        final boolean isEven = math.isEven(0);
        assertEquals(true, isEven);
    }

    /**
     * Tests the method that returns true if a specified
     * number is even, else false.
     */
    @Test
    public void testIsEven2() {
        final boolean isEven = math.isEven(1);
        assertEquals(false, isEven);
    }

    /**
     * Tests the method that returns true if a specified
     * number is even, else false.
     */
    @Test
    public void testIsEven3() {
        final boolean isEven = math.isEven(2);
        assertEquals(true, isEven);
    }

    /**
     * Tests the method that returns the sum of the even
     * numbers between 0 and the specified value inclusive.
     */
    @Test
    public void testSumOfEvens() {
        final int sumOfEvens = math.sumOfEvens(0);
        assertEquals(0, sumOfEvens);
    }

    /**
     * Tests the method that returns the sum of the even
     * numbers between 0 and the specified value inclusive.
     */
    @Test
    public void testSumOfEvens2() {
        final int sumOfEvens = math.sumOfEvens(10);
        assertEquals(30, sumOfEvens);
    }

    /**
     * Tests the method that returns the sum of the even
     * numbers between 0 and the specified value inclusive.
     */
    @Test
    public void testSumOfEvens3() {
        final int sumOfEvens = math.sumOfEvens(-10);
        assertEquals(-30, sumOfEvens);
    }

    /**
     * Tests the method that returns the sum of the numbers
     * between 0 and the first parameter that are divisible
     * by the second parameter.
     */
    @Test
    public void testSumOfProducts() {
        final int sumOfProducts = math.sumOfProducts(10, 3);
        assertEquals(18, sumOfProducts); // 3 + 6 + 9
    }

    /**
     * Tests the method that returns the sum of the numbers
     * between 0 and the first parameter that are divisible
     * by the second parameter.
     */
    @Test
    public void testSumOfProducts2() {
        final int sumOfProducts = math.sumOfProducts(-10, 3);
        assertEquals(-18, sumOfProducts); // -3 + -6 + -9
    }

    /**
     * Tests the method that returns the sum of the numbers
     * between 0 and the first parameter that are divisible
     * by the second parameter.
     */
    @Test
    public void testSumOfProducts3() {
        final int sumOfProducts = math.sumOfProducts(40, 5);
        assertEquals(180, sumOfProducts); // 5 + 10 + ... + 40
    }

}
