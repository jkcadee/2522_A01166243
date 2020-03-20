package ca.bcit.comp2522.labs.lab06;

import java.util.Arrays;

public class WarmUp {
    public static int getSumOfTwoLargest(int[] arrayOfInts) {
        if (arrayOfInts.length < 2) {
            throw new IllegalArgumentException("Not enough arguments.");
        }

        Arrays.sort(arrayOfInts);

        return arrayOfInts[arrayOfInts.length - 1] + arrayOfInts[arrayOfInts.length - 2];
    }

    public static void main(String[] args) {
        int[] newArray = {14, 12, 10, 8, 10, 12, 14};
        int sum = getSumOfTwoLargest(newArray);
        System.out.println(sum);
    }
}
