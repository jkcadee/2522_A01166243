package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * Calculates different mathematical equations.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Mathematics {
    public static final double PI = 3.14159;
    public static final double ONE_FOOT_TO_KILOMETER_RATIO = 0.0003048;
    private final Random randomNumber;

    public Mathematics() {
        this.randomNumber = new Random();
    }

    public double getCircleArea(double v) {
        return PI * Math.pow(v, 2);
    }

    public double getSquareArea(double v) {
        return Math.pow(v, 2);
    }

    public double add(double v, double v1) {
        return v + v1;
    }

    public double multiply(double v, double v1) {
        return v * v1;
    }

    public double subtract(double v, double v1) {
        return v - v1;
    }

    public double divide(int i, int i1) {
        if (i1 == 0) {
            return 0.0;
        }
        return Math.floorDiv(i, i1);
    }

    public int absoluteValue(int i) {
        return Math.abs(i);
    }

    public int getRandomNumberBetweenTenAndTwentyButNotFifteen() {
        final int ten = 10;
        final int fifteen = 15;
        final int upperbound = 21;
        int newRandomNumber;

        do {
            newRandomNumber = randomNumber.nextInt(upperbound);
        } while (newRandomNumber < ten || newRandomNumber == fifteen);

        return newRandomNumber;
    }

    public double convertFeetToKilometres(double v) {
        return ONE_FOOT_TO_KILOMETER_RATIO * v;
    }

    public int sumOfInts(int i) {
        int intSum = 0;

        for (int num = 0; num <= i; num++) {
            intSum += num;
        }

        return intSum;
    }

    public boolean isPositive(int i) {
        return i > 0;
    }

    public boolean isEven(int i) {
        return i % 2 == 0;
    }

    public int sumOfEvens(int i) {
        int evenSum = 0;

        if (i < 0) {
            for (int num = 0; num >= i; num--) {
                if (num % 2 == 0) {
                    evenSum += num;
                }
            }
        } else {
            for (int num = 0; num <= i; num++) {
                if (num % 2 == 0) {
                    evenSum += num;
                }
            }
        }
        return evenSum;
    }

    public int sumOfProducts(int i, int i1) {
        int productSum = 0;

        if (i < 0) {
            for (int num = 0; num >= i; num--) {
                if (num % i1 == 0) {
                    productSum += num;
                }
            }
        } else {
            for (int num = 0; num <= i; num++) {
                if (num % i1 == 0) {
                    productSum += num;
                }
            }
        }
        return productSum;
    }
}

class Test {
    public static void main(String[] args) {
        Mathematics math = new Mathematics();

        System.out.println(math.getRandomNumberBetweenTenAndTwentyButNotFifteen());
    }
}
