package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

/**
 * A class that simulates a Node and it's requisite methods.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class Node {
    private Object data;
    private Node next;

    /**
     * Constructs the Node.
     *
     * @param data The data that the Node holds.
     */
    public Node(final Object data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Sets the Node's current next value to whatever Node is passed in the parameter.
     *
     * @param next The Node that the current Node will point to.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Sets the data within the selected Node to whatever Object is passed in the parameter.
     *
     * @param data The Object data the current Node is to hold.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Gets the Object within the selected Node.
     *
     * @return The Object data the current Node has.
     */
    public Object getObject() {
        return this.data;
    }

    /**
     * Gets the Node within the current Node.
     *
     * @return The Node the current Node is pointing to.
     */
    public Node getNext() {
        return this.next;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Node.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
