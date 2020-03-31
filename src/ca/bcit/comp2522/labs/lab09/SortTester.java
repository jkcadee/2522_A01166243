package ca.bcit.comp2522.labs.lab09;

import java.util.Random;

/**
 * Tests the running time of a quadratic sort and logarithmic sort algorithm.
 * Quadratic sort is insertion sort, and logarithmic sort is quick sort.
 *
 * @author Janelle Kwok
 * @version 2020
 */
public class SortTester {

    /**
     * Constant signifying the size an array size of 10.
     */
    public static final int SIZE_TEN = 10;
    /**
     * Constant signifying the size an array size of 100.
     */
    public static final int SIZE_HUNDRED = 100;
    /**
     * Constant signifying the size an array size of 1000.
     */
    public static final int SIZE_THOUSAND = 1_000;
    /**
     * Constant signifying the size an array size of 10000.
     */
    public static final int SIZE_TEN_THOUSAND = 10_000;
    /**
     * Constant signifying the size an array size of 100000.
     */
    public static final int SIZE_ONE_HUNDRED_THOUSAND = 100_000;
    /**
     * Constant signifying the size an array size of 1000000.
     */
    public static final int SIZE_ONE_MILLION = 1_000_000;
    /**
     * Constant signifying the size an array size of 10000000.
     */
    public static final int SIZE_TEN_MILLION = 10_000_000;

    /**
     * Sorts an array of integers in quadratic time. Also times the process.
     *
     * https://www.geeksforgeeks.org/insertion-sort/
     * https://www.hackerearth.com/practice/algorithms/sorting/insertion-sort/tutorial/
     * https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
     *
     * @pre The array has elements.
     * @post The array is sorted.
     * @param array An array of integers to be sorted.
     * @return The time it takes for the array to be sorted, as well as the sorted array.
     */
    public long quadraticSort(final int[] array) {
        long time = System.nanoTime();

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return System.nanoTime() - time;
    }

    /*
     * Determines the partition point for quick sort.
     * For each call of the logarithmic sort method, it will go up to the returned index -1,
     * or start at the returned index +1.
     */
    private int partition(final int[] array, final int lowerBound, final int upperBound) {
        int pivot = array[upperBound];
        int smallestIndex = (lowerBound - 1);

        for (int index = lowerBound; index < upperBound; index++) {
            if (array[index] < pivot) {
                smallestIndex++;
                int temp =  array[smallestIndex];
                array[smallestIndex] = array[index];
                array[index] = temp;
            }
        }
        int temp = array[smallestIndex + 1];
        array[smallestIndex + 1] = array[upperBound];
        array[upperBound] = temp;

        return smallestIndex + 1;
    }

    /**
     * Sorts an array of integers in logarithmic time. Also times the process.
     *
     * https://www.geeksforgeeks.org/quick-sort/
     *
     * @pre The array has elements.
     * @post The array is sorted.
     * @param array An array of integers to be sorted.
     * @param lowerBound The lowest index in the array.
     * @param upperBound The highest index in the array.
     * @return The time it takes for the array to be sorted, as well as the sorted array.
     */
    public long logarithmicSort(final int[] array, final int lowerBound, final int upperBound) {
        long beginning = System.nanoTime();

        if (lowerBound < upperBound) {
            int p = partition(array, lowerBound, upperBound);
            logarithmicSort(array, lowerBound, p - 1);
            logarithmicSort(array, p + 1, upperBound);
        }

        return (System.nanoTime() - beginning);
    }

    /*
     * Creates a new array based on the size inputted.
     * Fills it with random numbers from 0 to ten million.
     */
    private static int[] createArray(int size) {
        int[] newArray = new int[size];
        final Random randomNumberGenerator = new Random();
        for (int index = 0; index < size; index++) {
            newArray[index] = randomNumberGenerator.nextInt(SIZE_TEN_MILLION);
        }
        return newArray;
    }

    /**
     * Gets the average time of ten logarithmic sorts. Prints the time and the length for each.
     *
     * @pre The array has elements.
     * @post The array is sorted and the time is printed.
     * @param arraySize The array size to create an array to be created from.
     * @param sortTester The SortTester object.
     */
    public void averageLogTime(final int arraySize, final SortTester sortTester) {
        final int amountOfTestCases = 10;
        long overallTime = 0;
        for (int index = 0; index < amountOfTestCases; index++) {
            int[] array = SortTester.createArray(arraySize);
            overallTime += sortTester.logarithmicSort(array, 0, array.length - 1);
        }
        System.out.println("For length: " + arraySize
                + ", the average time to complete 10 calls of this "
                + "logarithmic algorithm is " + overallTime / amountOfTestCases);
    }

    /**
     * Gets the average time of ten quadratic sorts. Prints the time and the length for each.
     *
     * @pre The array has elements.
     * @post The array is sorted and the time is printed.
     * @param arraySize The array size to create an array to be created from.
     * @param sortTester The SortTester object.
     */
    public void averageQuadraticTime(final int arraySize, final SortTester sortTester) {
        final int amountOfTestCases = 10;
        long overallTime = 0;
        for (int index = 0; index < amountOfTestCases; index++) {
            int[] array = SortTester.createArray(arraySize);
            overallTime += sortTester.quadraticSort(array);
        }
        System.out.println("For length: " + arraySize
                + ", the average time to complete 10 sorts of calls "
                + "quadratic algorithm is " + overallTime / amountOfTestCases);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SortTester{");
        sb.append('}');
        return sb.toString();
    }
}
