package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Creates a Race object that simulates a race between a Hare and Tortoise object using their respective move() methods.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Race {
    private int length;
    private int clockTicks;
    private int hareWins;
    private int tortoiseWins;
    private Random randomNumber;
    private Hare hare;
    private Tortoise tortoise;

    /**
     * Constructs a new Race object with a specified length attribute and instantiates a new Hare, Tortoise and Random
     * object.
     *
     * @param length The only parameter for this method. It is an integer type value.
     */

    public Race(int length) {
        this.length = length;
        hare = new Hare();
        tortoise = new Tortoise();
        randomNumber = new Random();
    }

    public final Hare getHare() {
        return this.hare;
    }

    public final Tortoise getTortoise() {
        return this.tortoise;
    }

    /**
     * Gets the value of the attribute hareWins.
     *
     * @return The integer type attribute hareWins specific to the instance of the object.
     */

    public final int getHareWins() {
        return this.hareWins;
    }

    /**
     * Gets the value of the attribute tortoiseWins.
     *
     * @return The integer type attribute tortoiseWins specific to the instance of the object.
     */

    public final int getTortoiseWins() {
        return this.tortoiseWins;
    }

    /**
     * Gets the value of the attribute clockTicks.
     *
     * @return The integer type attribute clockTicks specific to the instance of the object.
     */

    public final int getClockTicks() {
        return this.clockTicks;
    }

    /**
     * Resets the positions of the Hare and Tortoise objects to 0.
     */

    public final void reset() {
        hare.setPosition(0);
        tortoise.setPosition(0);
    }

    /*
    Generates a random number that determines if the Hare or Tortoise object calls their move method first.
    This loops until either the Hare or Tortoise object reach or exceed the length.
    Each time it is looped, the clockTicks attribute is incremented.
    Once the loop is left, there is a conditional statement that checks whether or not the position attribute in the
    Tortoise object is higher or equal to the length and if it is, the tortoiseWins attribute is incremented.
    If not, the hareWins attribute is incremented.
    The return value is a String displaying their final positions and the amount of iterations it took for one of them
    to reach or exceed the length.
     */

    private String race() {
        do {
            int generateRandomNum = randomNumber.nextInt(101);

            if (generateRandomNum <= 50) {
                hare.move();
                tortoise.move();
            } else if (generateRandomNum <= 100) {
                tortoise.move();
                hare.move();
            }
            clockTicks++;

        } while (tortoise.getPosition() < length && hare.getPosition() < length);

        if (tortoise.getPosition() >= length) {
            tortoiseWins++;
            return "Tortoise";
        } else {
            hareWins++;
            return "Hare";
        }
    }

    /**
     * Simulates the race between the Hare and Tortoise objects. Calls the reset method to reset their positions to 0
     * and returns the result of the race method.
     *
     * @return A String representation of the winner of the race.
     */

    public final String simulateRace() {
        reset();
        return race();
    }
}
