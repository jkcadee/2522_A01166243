package ca.bcit.comp2522.labs.lab09;

/**
 * Runs the logarithmic and quadratic sorts and gets an average from them.
 *
 * @author Janelle Kwok
 * @version 2020
 */
public class Driver {
    /**
     * Drives the program, and simulates various sorts and prints their times.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        int[] sizes = {SortTester.SIZE_TEN, SortTester.SIZE_HUNDRED, SortTester.SIZE_THOUSAND,
                SortTester.SIZE_TEN_THOUSAND, SortTester.SIZE_ONE_HUNDRED_THOUSAND,
                SortTester.SIZE_ONE_MILLION, SortTester.SIZE_TEN_MILLION};

        SortTester sortTester = new SortTester();

        for (int arraySize : sizes) {
            sortTester.averageLogTime(arraySize, sortTester);
            sortTester.averageQuadraticTime(arraySize, sortTester);
        }
    }
}
