package ca.bcit.comp2522.quizzes.quiz03;

import java.util.Objects;

/**
 * A class for simulating Boulevards.
 *
 * @author Janelle A01166243
 * @author Kayden A01174919
 */
public class Boulevard extends Road {
    /* Whether or not the Boulevard has trees on its median */
    private boolean medianHasTrees;

    /**
     * Instantiates a Boulevard.
     *
     * @param name the name of the new Boulevard
     * @param direction the direction of the new Boulevard
     * @param medianHasTrees whether or not the new Boulevard has trees on its median
     */
    public Boulevard(final String name, final Direction direction, final boolean medianHasTrees){
        super(name, direction);
        this.medianHasTrees = medianHasTrees;
    }

    /**
     * Returns a string representation for the Boulevard.
     *
     * @return a string representation for the Boulevard
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Boulevard{");
        sb.append("name='").append(super.name).append('\'');
        sb.append(", direction=").append(super.direction).append(", ");
        sb.append("medianHasTrees=").append(medianHasTrees);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param o The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Boulevard boulevard = (Boulevard) o;
        return medianHasTrees == boulevard.medianHasTrees;
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(medianHasTrees);
    }
}
