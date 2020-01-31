package ca.bcit.comp2522.labs.lab03;

import java.util.Objects;

/**
 * Creates a Tree with a Species type, an age, and a trunk circumference.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Tree {
    /**
     * Holds the tree type with a value corresponding to it.
     */
    public enum Species { MAPLE(0), ARBUTUS(1), BLUE_SPRUCE(2);
        private int value;

        Species(final int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }

    private Species treeType;
    private int ageInYears;
    private double trunkCircumference;

    /**
     * Constructs a tree object with a Species type, an age in years and a trunk circumference.
     * Throws an IllegalArgumentException if the values passed into the parameters are invalid.
     *
     * @param newTreeType The tree type for the Tree object. Must be of the Species data type.
     * @param newAgeInYears The age of the tree in years. Must be an integer type value.
     * @param newTrunkCircumference The circumference of the trunk. Must be a double type value.
     */

    public Tree(final Species newTreeType,
                final int newAgeInYears,
                final double newTrunkCircumference) {
        if (newAgeInYears < 0 || newTrunkCircumference < 0.0) {
            throw new IllegalArgumentException();
        }

        this.treeType = newTreeType;
        this.ageInYears = newAgeInYears;
        this.trunkCircumference = newTrunkCircumference;
    }

    /**
     * Constructs a tree object with an age in years and a trunk circumference.
     * The Species type parameter is defaulted to MAPLE.
     * Throws an IllegalArgumentException if the values passed into the parameters are invalid.
     *
     * @param newAgeInYears The age of the tree in years. Must be an integer type value.
     * @param newTrunkCircumference The circumference of the trunk. Must be a double type value.
     */

    public Tree(final int newAgeInYears, final double newTrunkCircumference) {
        this(Species.MAPLE, newAgeInYears, newTrunkCircumference);
    }

    /**
     * Sets the value of ageInYears. It increments the ageInYears value when being set.
     */

    public final void setAgeInYears() {
        this.ageInYears++;
    }

    /**
     * Sets the value of trunkCircumference.
     * It will ignore any values passed in that are less
     * than the current trunk circumference.
     *
     * @param trunkCircumference The value for trunkCircumference to be set at.
     *                           Must be a double type value.
     */

    public void setTrunkCircumference(final double trunkCircumference) {
        if (trunkCircumference >= this.trunkCircumference) {
            this.trunkCircumference = trunkCircumference;
        }
    }

    /**
     * Gets the value stored at treeType.
     *
     * @return The Species value stored ta treeTpe.
     */

    public Species getTreeType() {
        return treeType;
    }

    /**
     * Gets the value stored at ageInYears.
     *
     * @return The integer value stored at ageInYears.
     */

    public int getAgeInYears() {
        return ageInYears;
    }

    /**
     * Gets the value stored at trunkCircumference.
     *
     * @return The double value stored trunkCircumference.
     */

    public double getTrunkCircumference() {
        return trunkCircumference;
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
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tree tree = (Tree) obj;
        return ageInYears == tree.ageInYears
                && Double.compare(tree.trunkCircumference, trunkCircumference) == 0
                && treeType == tree.treeType;
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(treeType, ageInYears, trunkCircumference);
    }

    /**
     * Creates a String representation of the attributes in the Tree class.
     *
     * @return The String representation of the Tree class.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tree{");
        sb.append("treeType=").append(treeType);
        sb.append(", ageInYears=").append(ageInYears);
        sb.append(", trunkCircumference=").append(trunkCircumference);
        sb.append('}');
        return sb.toString();
    }
}
