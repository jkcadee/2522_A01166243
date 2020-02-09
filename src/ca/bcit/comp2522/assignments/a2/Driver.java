package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        Scanner input = new Scanner(System.in);

        System.out.println("How many weeks would you like simulated?");
        int amountOfWeeks = input.nextInt();

        ecosystem.simulate(amountOfWeeks);
    }
}
