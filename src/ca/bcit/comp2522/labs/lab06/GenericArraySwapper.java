package ca.bcit.comp2522.labs.lab06;

public class GenericArraySwapper {
    public static <T> void genericArraySwapper(T[] array, int indexOne, int indexTwo) throws GenericBoundsException {
        if (indexOne < 0 || indexTwo < 0 || indexOne >= array.length || indexTwo >= array.length) {
            throw new GenericBoundsException();
        }

        T temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static <T> void sort(int[] data) {
        for (int i = 1; i < data.length; ++i) {
            int currentValue = data[i];
            int latestValue = i - 1;

            while (latestValue >= 0 && data[latestValue] > currentValue) {
                data[latestValue + 1] = data[latestValue];
                latestValue = latestValue - 1;
            }
            data[latestValue + 1] = currentValue;
        }
    }

    public static void main(String[] args) throws GenericBoundsException {
        Integer[] integerArray = {1, 2, 4, 6, 5};

        genericArraySwapper(integerArray, 0, 2);

        for (Integer i: integerArray) {
            System.out.println(i);
        }

        int[] intArray = {3, 1, 2, 4, 6, 5};

        sort(intArray);

        for (int i: intArray) {
            System.out.println(i);
        }
    }
}
