package ca.bcit.comp2522.quizzes.quiz03;

import java.util.Objects;

/**
 * A class for simulating Roads.
 *
 * @author Janelle A01166243
 * @author Kayden A01174919
 */
public class Road {
    /* The name of the Road */
    protected String name;
    /* The direction of the Road */
    protected Direction direction;

    /**
     * Instantiates a Road.
     *
     * @param name the name for the new Road
     * @param direction the direction for the new Road
     */
    public Road(final String name, final Direction direction){
        this.name = name;
        this.direction = direction;
    }

    /**
     * Returns a string representation for the Road.
     *
     * @return a string representation for the Road
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Road{");
        sb.append("name='").append(name).append('\'');
        sb.append(", direction=").append(direction);
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
        final Road road = (Road) o;
        return Objects.equals(name, road.name) &&
                direction == road.direction;
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(name, direction);
    }
}
