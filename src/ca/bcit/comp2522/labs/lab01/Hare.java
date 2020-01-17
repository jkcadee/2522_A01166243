package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Creates a Hare object with an integer type position attribute and ability to
 * call a move() method to modify the attribute position.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Hare {
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
     * Gets the value of the attribute position.
     *
     * @return The integer type attribute position specific to the instance of the object.
     */

    public final int getPosition() {
        return this.position;
    }

    /**
     * Moves the Hare object by increasing or decreasing the position attribute by random chance.
     *
     * @return The integer type attribute position.
     */

    public final int move() {
        if (randomNumber == null) {
            randomNumber = new Random();
        }

        int generateRandomNum = randomNumber.nextInt(101);

        if (generateRandomNum <= 20) {
            return position;
        } else if (generateRandomNum <= 30) {
            return position += 9;
        } else if (generateRandomNum <= 40) {
            return position -= 12;
        } else if (generateRandomNum <= 70) {
            return position += 1;
        } else {
            return position -= 2;
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

        Hare object = (Hare) obj;

        if (object.getPosition() == this.position) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Converts the attributes in the class into a String object and displays them in a informative manner.
     *
     * @return The integer type attribute position.
     */

    @Override
    public final String toString() {
        return "Hare's position is: " + position;
    }
}
