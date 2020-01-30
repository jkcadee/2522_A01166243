package ca.bcit.comp2522.labs.lab03;

public class Driver {
    public static void main(String[] args) {
        final int seeding = 5;

        int numberOfTrees = 0;
        Plantation lotuslandLumber = new Plantation();

        for (int timesSeeded = 0; timesSeeded < seeding; timesSeeded++) {
            numberOfTrees += lotuslandLumber.seed();
        }

        System.out.println(numberOfTrees);
    }
}
