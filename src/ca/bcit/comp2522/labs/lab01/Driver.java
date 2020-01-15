package ca.bcit.comp2522.labs.lab01;

public class Driver {

    public static String simulateRaces(int numOfRaces, int lengthOfRace) {
        Race race = new Race(lengthOfRace);

        for(int races = 0; races < numOfRaces; races++) {
            race.simulateRace();
        }
        return String.format("Hare won %d times.\nTortoise won %d times.", race.getHareWins(), race.getTortoiseWins());
    }

    public static void main(String[] args) {
        System.out.println(simulateRaces(100, 100));
    }
}
