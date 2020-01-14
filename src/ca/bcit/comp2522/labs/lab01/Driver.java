package ca.bcit.comp2522.labs.lab01;

public class Driver {
    public static void main(String[] args) {
        Race race = new Race(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(race.simulateRace());
        }
    }
}
