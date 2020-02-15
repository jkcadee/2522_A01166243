package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Simulates an Ecosystem.
 * It also allows the user to specify how many weeks they want simulated.
 * The process is run in the main method.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Driver {

    /**
     * Runs the simulate method by asking the user how many weeks they want simulated.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        Scanner input = new Scanner(System.in);

        System.out.println("How many weeks would you like simulated?");
        int amountOfWeeks = input.nextInt();

        ecosystem.simulate(amountOfWeeks);
        input.close();
    }
}
