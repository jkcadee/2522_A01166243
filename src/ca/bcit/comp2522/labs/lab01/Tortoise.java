package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Creates a Tortoise object with an integer type position attribute and ability to call a move() method to modify the
 * attribute position.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Tortoise {
    private int position;
    Random randomNumber;

    /**
     * Sets the value of the attribute position.
     *
     * @param position The only parameter for this method. It is an integer type value.
     */

    final public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Gets the value of the position attribute.
     *
     * @return The integer type attribute position specific to the instance of the object.
     */

    final public int getPosition() {
        return this.position;
    }

    /**
     * Moves the Tortoise object by increasing or decreasing the position attribute by random chance.
     *
     * @return The integer type attribute position.
     */

    final public int move() {
        randomNumber = new Random();
        int generateRandomNum = randomNumber.nextInt(101);

        if (generateRandomNum <= 50) {
            return position += 3;
        }
        else if (generateRandomNum <= 70) {
            return position -= 6;
        }
        else {
            return position += 1;
        }
    }

    /**
     * Converts the attributes in the class into a String object and displays them in a informative manner.
     *
     * @return The integer type attribute position.
     */

    @Override
    final public String toString() {
        return "Tortoise's position is: " + position;
    }

    /**
     * Checks if the object passed into the method is: 1. Not null 2. The same object type 3. Has the same values within.
     *
     * @param obj The only parameter for this method. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the same as what it being checked against.
     */

    @Override
    final public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Tortoise object = (Tortoise) obj;

        if (object.getPosition() == this.position) {
            return true;
        }
        else {
            return false;
        }
    }
}
