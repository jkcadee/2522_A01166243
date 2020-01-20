package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Creates a Tortoise object with an integer type position attribute and
 * ability to call a move() method to modify the attribute position.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Tortoise {
    private static final int RANGE = 101;
    private static final int FIFTY_PERCENT = 50;
    private static final int TWENTY_PERCENT = 70;
    private static final int SMALL_TROT = 3;
    private static final int BIG_SLIP = 6;

    private int position;
    private Random randomNumber = new Random();

    /**
     * Sets the value of the attribute position.
     *
     * @param position The only parameter for this method. It is an integer type value.
     */

    public final void setPosition(int position) {
        this.position = position;
    }

    /**
     * Gets the value of the position attribute.
     *
     * @return The integer type attribute position specific to the instance of the object.
     */

    public final int getPosition() {
        return this.position;
    }

    /**
     * Moves the Tortoise object by increasing or decreasing the
     * position attribute by random chance.
     *
     * @return The integer type attribute position.
     */

    public final int move() {
        if (randomNumber == null) {
            randomNumber = new Random();
        }

        int generateRandomNum = randomNumber.nextInt(RANGE);

        if (generateRandomNum <= FIFTY_PERCENT) {
            position += SMALL_TROT;
            return position;
        } else if (generateRandomNum <= TWENTY_PERCENT) {
            position -= BIG_SLIP;
            return position;
        } else {
            position += 1;
            return position;
        }
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param obj The only parameter for this method. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Tortoise object = (Tortoise) obj;

        return object.getPosition() == this.position;
    }

    /**
     * Converts the attributes in the class into a String object
     * and displays them in a informative manner.
     *
     * @return The integer type attribute position.
     */

    @Override
    public final String toString() {
        return "Tortoise's position is: " + position;
    }
}
