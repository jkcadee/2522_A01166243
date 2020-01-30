package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import ca.bcit.comp2522.labs.lab03.Tree.Species;

/**
 * Creates a Plantation that is filled with Tree objects.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Plantation {
    /*
    * Private constants for the seed() method.
    */
    private static final Random RANDOM_NUMBER = new Random();
    private static final int MAX = 1000;
    private static final int MIN = 10;
    private static final double CIRCUMFERENCE_MAX = 100.0;
    private static final double CIRCUMFERENCE_MIN = 10.0;
    private static final int TREE_TYPE_VALUE = 3;

    private ArrayList<Tree> farm = new ArrayList<>();

    /**
     * Returns the size of the farm ArrayList.
     *
     * @return The size of the farm ArrayList as an integer.
     */

    public final int size() {
        return farm.size();
    }

    /**
     * Adds a new Tree object to the farm ArrayList.
     * Will check if the object passed in is null,
     * if it is, it will throw a NullPointerException.
     *
     * @param tree A Tree type object to be added to the farm ArrayList.
     * @return The size of the farm ArrayList as an integer.
     */

    public final int add(final Tree tree) {
        if (tree == null) {
            throw new NullPointerException();
        }
        farm.add(tree);
        return farm.size();
    }

    /**
     * Generates a random amount of random Tree objects and
     * populates the farm ArrayList with the Tree objects.
     *
     * @return The amount of trees added to the farm ArrayList.
     */

    public int seed() {
        final int previousSize = farm.size();

        int generateRandomNumber = RANDOM_NUMBER.nextInt((MAX - MIN + 1)) + MIN;

        for (int treesPlanted = 0; treesPlanted < generateRandomNumber; treesPlanted++) {
            Species randomTreeType = null;
            int generateTreeType = RANDOM_NUMBER.nextInt(TREE_TYPE_VALUE);
            int generateAge = RANDOM_NUMBER.nextInt(MAX);
            double generateTreeCircumference = CIRCUMFERENCE_MIN
                    + (CIRCUMFERENCE_MAX - CIRCUMFERENCE_MIN + 1)
                    * RANDOM_NUMBER.nextDouble();

            for (Species treeSpecies : Species.values()) {
                if (treeSpecies.getValue() == generateTreeType) {
                    randomTreeType = treeSpecies;
                    break;
                }
            }

            Tree newTree = new Tree(randomTreeType, generateAge, generateTreeCircumference);
            farm.add(newTree);

        }
        return farm.size() - previousSize;
    }

    /**
     * Calculates and returns the amount of trees ready for harvesting
     * depending on the value passed through the parameter.
     *
     * @param cutOffCircumference The minimum circumference valid
     *                            to be considered ready for harvest.
     * @return The amount of trees ready to be harvested.
     */

    public int harvestCount(final double cutOffCircumference) {
        int treesReadyForHarvest = 0;
        for (Tree tree : farm) {
            if (tree.getTrunkCircumference() >= cutOffCircumference) {
                    treesReadyForHarvest++;
            }
        }
        return treesReadyForHarvest;
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param obj The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Plantation that = (Plantation) obj;
        return farm.equals(that.farm);
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(farm);
    }

    /**
     * Creates a String representation of the attributes in the Plantation class.
     *
     * @return The String representation of the Tree class.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plantation{");
        sb.append("farm=").append(farm);
        sb.append('}');
        return sb.toString();
    }
}
