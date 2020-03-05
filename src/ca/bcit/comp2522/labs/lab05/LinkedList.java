package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

/**
 * A class that simulates a LinkedList and it's requisite methods.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public class LinkedList {
    private Node head;

    /**
     * Constructs the LinkedList with a head that points to null.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Adds a node containing the data passed in the parameter to the front of the LinkedList.
     *
     * @param data The data the Node being prepended will contain.
     */
    public void prepend(Object data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    /**
     * Adds a node containing the data passed in the parameter to the end of the LinkedList.
     *
     * @param data The data the Node being appended will contain.
     */
    public void append(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node headIterator = head;
            while (headIterator.getNext() != null) {
                headIterator = headIterator.getNext();
            }
            Node newEndNode = new Node(data);
            headIterator.setNext(newEndNode);
        }
    }

    /**
     * Adds a node containing the data passed in the parameter to the area of the LinkedList the
     * index corresponds to.
     *
     * @param data The data the Node being added will contain.
     * @param index The area in the LinkedList the Node will be placed at.
     */
    public void add(Object data, int index) {
        if (head == null) {
            head = new Node(data);
        } else {
            if (index == 0) {
                prepend(data);
                return;
            }
            Node headIterator = head;
            if (index < 0) {
                throw new IndexOutOfBoundsException();
            }
            Node prevNode = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                if (headIterator == null) {
                    throw new IndexOutOfBoundsException();
                }
                prevNode = headIterator;
                headIterator = headIterator.getNext();
            }
            Node node = new Node(data);
            prevNode.setNext(node);
            node.setNext(headIterator);
        }
    }

    /**
     * Counts the amount of elements in the LinkedList.
     *
     * @return The amount of elements in the LinkedList.
     */
    public int size() {
        int counter = 0;
        if (head == null) {
            return counter;
        }
        Node headIterator = head;
        while (headIterator.getNext() != null) {
            counter++;
            headIterator = headIterator.getNext();
        }
        return counter + 1;
    }

    /**
     * Clears the LinkedList of any Nodes.
     */
    public void clear() {
        head = null;
    }

    /**
     * Gets the Node at the specified index from the LinkedList. Will throw an Exception if the
     * index is out of range.
     *
     * @param index The index that you want to get the Node at.
     * @return The Node at the given index.
     */

    public Object get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node headIterator = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            headIterator = headIterator.getNext();
        }
        return headIterator.getObject();
    }

    /**
     * Removes the Node at the specified index from the LinkedList. Will throw an Exception if the
     * index is out of range.
     *
     * @param index The index at which the Node will be removed from the LinkedList.
     * @return The removed Node.
     */
    public Object remove(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node removedNode = head;
            head = head.getNext();
            return  removedNode;
        }

        Node headIterator = head;
        Node prevNode = head;
        Node nextNode = null;

        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            prevNode = headIterator;
            headIterator = headIterator.getNext();
            nextNode = headIterator.getNext();
        }
        Node removedNode = headIterator;
        prevNode.setNext(nextNode);
        return removedNode;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedList that = (LinkedList) o;
        return Objects.equals(head, that.head);
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within LinkedList.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedList{");
        sb.append("head=").append(head);
        sb.append('}');
        return sb.toString();
    }
}

/**
 * Drives the program. Primarily for testing.
 */

class LinkedListDriver {

    /**
     * Drives the program.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.add(7, 0);

        int size = linkedList.size();
        Object nodeGet = linkedList.get(2);

        System.out.println(linkedList.toString());
        System.out.println(size);
        System.out.println(nodeGet);

        linkedList.remove(0);
        System.out.println(linkedList.toString());
    }
}
