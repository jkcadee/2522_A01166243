package ca.bcit.comp2522.labs.lab01;

/**
 * Simulates the races by running them in the main method of the program.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Driver {

    /**
     * Simulates multiple races between the Hare and Tortoise objects.
     *
     * @param numOfRaces The first parameter for this method. It specifies the number of races done.
     *                   It is an integer type value.
     * @param lengthOfRace The second parameter for this method. It specifies the length of the race.
     *                     It is an integer type value.
     * @return A formatted String object stating the amount of times the Hare and Tortoise objects won the race.
     */

    public static String simulateRaces(int numOfRaces, int lengthOfRace) {
        Race race = new Race(lengthOfRace);

        for (int races = 0; races < numOfRaces; races++) {
            race.simulateRace();
        }
        return String.format("Hare won %d time(s).\nTortoise won %d times.", race.getHareWins(), race.getTortoiseWins());
    }

    /**
     * Runs the simulateRaces method to simulate the races. Prints out the results.
     *
     * @param args The only parameter for this method. It is not used.
     */

    public static void main(String[] args) {
        Race oneRace = new Race(100);

        String resultOneRace = oneRace.simulateRace();

        if (resultOneRace.equals("Tortoise")) {
            resultOneRace = resultOneRace + " wins in " + oneRace.getClockTicks() + " clock ticks at position "
                    + oneRace.tortoise.getPosition() + "." + " Hare was at position " + oneRace.hare.getPosition()
                    + ".";
        } else {
            resultOneRace = resultOneRace + " wins in " + oneRace.getClockTicks() + " clock ticks at position "
                    + oneRace.hare.getPosition() + "." + " Tortoise was at position " + oneRace.tortoise.getPosition()
                    + ".";
        }

        System.out.println(resultOneRace);
        System.out.println(simulateRaces(100, 100));
        System.out.println(simulateRaces(1000, 100));
    }
}
