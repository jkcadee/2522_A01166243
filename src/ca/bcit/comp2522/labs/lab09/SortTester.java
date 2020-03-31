package ca.bcit.comp2522.labs.lab09;

import java.util.Random;

public class SortTester {

    public static final int SIZE_TEN = 10;
    public static final int SIZE_HUNDRED = 100;
    public static final int SIZE_THOUSAND = 1_000;
    public static final int SIZE_TEN_THOUSAND = 10_000;
    public static final int SIZE_ONE_HUNDRED_THOUSAND = 100_000;
    public static final int SIZE_ONE_MILLION = 1_000_000;
    public static final int SIZE_TEN_MILLION = 10_000_000;

    /**
     *
     * https://www.hackerearth.com/practice/algorithms/sorting/insertion-sort/tutorial/
     * https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
     *
     * @param array
     * @return
     */
    public long quadraticSort(int[] array) {
        long time = System.nanoTime();

        for (int index = 0; index < array.length; index++) {
            int pickedValue = array[index];
            int indexTwo = index;
            while (indexTwo > 0 && pickedValue >= array[index - 1]) {
                    array[indexTwo] = array[indexTwo - 1];
                    indexTwo--;
            }
            array[indexTwo] = pickedValue;
        }

        return System.nanoTime() - time;
    }

    /**
     *
     * https://www.geeksforgeeks.org/quick-sort/
     *
     * @param array
     * @param lowerBound
     * @param upperBound
     * @return
     */
    private int partition(int[] array, int lowerBound, int upperBound) {
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


    public long logarithmicSort(int[] array, int lowerBound, int upperBound) {
        long beginning = System.nanoTime();

        if (lowerBound < upperBound) {
            int p = partition(array, lowerBound, upperBound);
            logarithmicSort(array, lowerBound, p - 1);
            logarithmicSort(array, p + 1, upperBound);
        }

        return (System.nanoTime() - beginning);
    }

    private static int[] createArray(int size) {
        int[] newArray = new int[size];
        final Random randomNumberGenerator = new Random();
        for (int index = 0; index < size; index++) {
            newArray[index] = randomNumberGenerator.nextInt(SIZE_TEN_MILLION);
        }
        return newArray;
    }

    private void averageLogTime(int arraySize, SortTester sortTester) {
        final int amountOfTestCases = 10;
        long overallTime = 0;
        for (int index = 0; index < amountOfTestCases; index++) {
            int[] array = SortTester.createArray(arraySize);
            overallTime += sortTester.logarithmicSort(array, 0, array.length - 1);
        }
        System.out.println("For length: " + arraySize + ", the average time to complete 10 calls of this " +
                "logarithmic algorithm is " + overallTime / amountOfTestCases);
    }

    private void averageQuadraticTime(int arraySize, SortTester sortTester) {
        final int amountOfTestCases = 10;
        long overallTime = 0;
        for (int index = 0; index < amountOfTestCases; index++) {
            int[] array = SortTester.createArray(arraySize);
            overallTime += sortTester.quadraticSort(array);
        }
        System.out.println("For length: " + arraySize + ", the average time to complete 10 sorts of calls " +
                "quadratic algorithm is " + overallTime / amountOfTestCases);
    }

    public static void main(String[] args) {
        int[] sizes = {SIZE_TEN, SIZE_HUNDRED, SIZE_THOUSAND, SIZE_TEN_THOUSAND,
                SIZE_ONE_HUNDRED_THOUSAND, SIZE_ONE_MILLION, SIZE_TEN_MILLION};

        SortTester sortTester = new SortTester();

        // Buffer Tester, as there is a spike in time during the first call.
        sortTester.averageLogTime(SIZE_TEN, sortTester);

        for (int arraySize : sizes) {
            sortTester.averageLogTime(arraySize, sortTester);
            sortTester.averageQuadraticTime(arraySize, sortTester);
        }
    }
}
