package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

public class Node {
    private Object data;
    private Node next;

    public Node(final Object data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getObject() {
        return this.data;
    }

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
