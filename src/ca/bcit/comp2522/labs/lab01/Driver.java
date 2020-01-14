package ca.bcit.comp2522.labs.lab01;

public class Driver {

    public static String simulateRaces(int numOfRaces, int lengthOfRace) {
        return String.format("The number of races was %d and the length of the race was %d.", numOfRaces, lengthOfRace);
    }

    public static void main(String[] args) {
        Race race100units = new Race(100);
        Race race1000units = new Race(1000);

    }
}
