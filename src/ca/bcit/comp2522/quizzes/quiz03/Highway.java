package ca.bcit.comp2522.quizzes.quiz03;

import java.util.Objects;

/**
 * A class for simulating Highways.
 *
 * @author Janelle A01166243
 * @author Kayden A01174919
 */
public class Highway extends Road{
    /* Whether or not the Highway has an HOV lane */
    private boolean hasHOVlane;

    /**
     * Instantiates a Highway.
     *
     * @param name the name of the new Highway
     * @param direction the direction of the new Highway
     * @param hasHOVlane whether or not the new Highway has an HOV lane
     */
    public Highway(final String name, final Direction direction, final boolean hasHOVlane){
        super(name, direction);
        this.hasHOVlane = hasHOVlane;
    }

    /**
     * Returns a string representation for the Highway.
     *
     * @return a string representation for the Highway
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Highway{");
        sb.append("name='").append(super.name).append('\'');
        sb.append(", direction=").append(super.direction).append(", ");
        sb.append("hasHOVlane=").append(hasHOVlane);
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
        final Highway highway = (Highway) o;
        return hasHOVlane == highway.hasHOVlane;
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(hasHOVlane);
    }
}
