package ca.bcit.comp2522.labs.lab06;

import java.util.Objects;

/**
 * A class that simulates a LinkedList and it's requisite methods.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 * @param <T> The type of element the LinkedList can hold.
 */
public class LinkedList<T> {

    /**
     * A class that simulates a Node and it's requisite methods.
     *
     * @author Janelle Kwok
     * @author BCIT
     * @version 2020
     * @param <T> The type of element the LinkedList can hold.
     */
    public static class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * Constructs the Node.
         *
         * @param data The data that the Node holds.
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Constructs the object.
         */
         Node(final T data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Sets the Node's current next value to whatever Node is passed in the parameter.
         *
         * @param next The Node that the current Node will point to.
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Sets the Node.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * Sets the data within the selected Node to whatever Object is passed in the parameter.
         *
         * @param data The Object data the current Node is to hold.
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Sets the data.
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * Gets the data within the selected Node.
         *
         * @return The T typed data the current Node has.
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Gets the object.
         */
        public T getObject() {
            return this.data;
        }

        /**
         * Gets the Node within the current Node.
         *
         * @return The Node the current Node is pointing to.
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Gets the Node.
         */
        public Node<T> getNext() {
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
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Checks if the object passed in is equal.
         */
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node =  (Node<?>) o;
            return Objects.equals(data, node.data)
                    && Objects.equals(next, node.next);
        }

        /**
         * Creates the hashcode for each instantiated object.
         * This hashcode will be based on the attributes in the object.
         *
         * @return The hashcode for the current object.
         * @pre All instance variables must have values.
         * @post Creates a hashcode for the object.
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
         * @pre Must have the same type of object inputted as data as the linked list.
         * @post Constructs a string representation the object.
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

    private Node<T> head;

    /**
     * Constructs the LinkedList with a head that points to null.
     * @pre Must have the same type of object inputted as data as the linked list.
     * @post Constructs the object.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Adds a node containing the data passed in the parameter to the front of the LinkedList.
     *
     * @param data The data the Node being prepended will contain.
     * @pre Must have the same type of object inputted as data as the linked list.
     * @post Adds the object to the front of the linked list.
     */
    public void prepend(final T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    /**
     * Adds a node containing the data passed in the parameter to the end of the LinkedList.
     *
     * @param data The data the Node being appended will contain.
     * @pre Must have the same type of object inputted as data as the linked list.
     * @post Adds the object to the end of the linked list.
     */
    public void append(final T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> headIterator = head;
            while (headIterator.getNext() != null) {
                headIterator = headIterator.getNext();
            }
            Node<T> newEndNode = new Node<>(data);
            headIterator.setNext(newEndNode);
        }
    }

    /**
     * Adds a node containing the data passed in the parameter to the area of the LinkedList the
     * index corresponds to.
     *
     * @param data The data the Node being added will contain.
     * @param index The area in the LinkedList the Node will be placed at.
     * @throws IndexOutOfBoundsException If the inputted index is too low or high,
     * this exception will be thrown.
     * @pre Must have the same type of object inputted as data as the linked list and
     * must not go out of range.
     * @post Adds the object at the specified index.
     */
    public void add(final T data, final int index) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            if (index == 0) {
                prepend(data);
                return;
            }
            Node<T> headIterator = head;
            if (index < 0) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> prevNode = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                if (headIterator == null) {
                    throw new IndexOutOfBoundsException();
                }
                prevNode = headIterator;
                headIterator = headIterator.getNext();
            }
            Node<T> node = new Node<>(data);
            prevNode.setNext(node);
            node.setNext(headIterator);
        }
    }

    /**
     * Counts the amount of elements in the LinkedList.
     *
     * @return The amount of elements in the LinkedList.
     * @pre Must have at least one element.
     * @post Counts the number of elements in the linked list.
     */
    public int size() {
        int counter = 0;
        if (head == null) {
            return counter;
        }
        Node<T> headIterator = head;
        while (headIterator.getNext() != null) {
            counter++;
            headIterator = headIterator.getNext();
        }
        return counter + 1;
    }

    /**
     * Clears the LinkedList of any Nodes.
     * @pre Object must be instantiated.
     * @post Clears the object.
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
     * @throws IndexOutOfBoundsException If the inputted index is too low or high,
     * this exception will be thrown.
     * @pre Must have the same type of object inputted as data as the linked list and
     * must not go out of range.
     * @post Gets the data at the specified index.
     */

    public T get(final int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> headIterator = head;
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
     * @throws IndexOutOfBoundsException If the inputted index is too low or high,
     * this exception will be thrown.
     * @pre Must have the same type of object inputted as data as the linked list and
     * must not go out of range.
     * @post Removes the Node at the specified index.
     */
    public T remove(final int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<T> removedNode = head;
            head = head.getNext();
            return removedNode.getObject();
        }

        Node<T> headIterator = head;
        Node<T> prevNode = head;
        Node<T> nextNode = null;

        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            prevNode = headIterator;
            headIterator = headIterator.getNext();
            nextNode = headIterator.getNext();
        }
        Node<T> removedNode = headIterator;
        prevNode.setNext(nextNode);
        return removedNode.getObject();
    }

    /**
     * Counts the number of nodes that contain an equal object to the one passed in the parameter.
     *
     * @param o Object against which to check.
     * @return The number of nodes that contain the object that was checked against.
     * @throws EmptyListException Throws this exception when the LinkedList has no elements.
     * @throws IllegalArgumentException If the inputted index is too low or high,
     * this exception will be thrown.
     * @pre Must have the same type of object inputted as data as the linked list.
     * @post Gets the amount of times the specified data can be found in the linked list.
     */
    public int count(final T o) throws EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        if (head == null) {
            throw new EmptyListException();
        } else {
            Node<T> iterator = head;
            while (iterator.getNext() != null) {
                if (iterator.getObject() != null && iterator.getObject().equals(o)) {
                    counter++;
                }
                iterator = iterator.getNext();
            }
            if (iterator.getObject() != null && iterator.getObject().equals(o)) {
                counter++;
            }
            return counter;
        }
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
     * @pre Must have the same type of object inputted as data as the linked list.
     * @post Checks if the object passed in is equal.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedList<?> that = (LinkedList<?>) o;
        return Objects.equals(head, that.head);
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     * @pre All instance variables must have values.
     * @post Creates a hashcode for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Node.
     * @pre Must have the same type of object inputted as data as the linked list.
     * @post Constructs a string representation the object.
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
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.add(7, 0);

        int size = linkedList.size();
        Object nodeGet = linkedList.get(2);

        System.out.println(linkedList.toString());
        System.out.println(size);
        System.out.println(nodeGet);

        Integer removedInt = linkedList.remove(0);
        System.out.println(removedInt);
        System.out.println(linkedList.toString());
    }
}
