package ca.bcit.comp2522.labs.lab03;

import java.util.Scanner;

/**
 * Simulates the seeding of a Plantation object.
 * It also allows the user to specify what is the minimum circumference
 * to determine which trees are ready for harvest.
 * The process is run in the main method.
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Driver {

    /**
     * Runs the seed method and requests user input for the harvestCount method.
     * Prints out the returned values of both.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        final int seeding = 5;
        final Plantation lotuslandLumber = new Plantation();

        int numberOfTrees = 0;

        for (int timesSeeded = 0; timesSeeded < seeding; timesSeeded++) {
            numberOfTrees += lotuslandLumber.seed();
        }

        System.out.printf("The number of tree planted is: %d.\n", numberOfTrees);

        final Scanner scanner = new Scanner(System.in);

        System.out.println("What the minimum harvest circumference? "
                + "(Input a floating point number from 10.0 to 100.0)");
        double minimumHarvestCircumference = scanner.nextDouble();
        scanner.close();

        int treesReadyForHarvest = lotuslandLumber.harvestCount(minimumHarvestCircumference);
        System.out.printf("The amount of trees ready for harvest is: %d.\n", treesReadyForHarvest);
    }
}
