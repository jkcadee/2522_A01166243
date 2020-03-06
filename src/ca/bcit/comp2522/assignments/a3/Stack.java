package ca.bcit.comp2522.assignments.a3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class that simulates a Stack.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public class Stack {
    private int[] stackValues;
    private int count;

    /**
     * Constructs the Stack object. Will throw an IllegalArgumentException if the passed in
     * parameter is too low.
     *
     * @param arraySize The size of the array that holds the values within the Stack.
     */
    public Stack(final int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Array size value is too low.");
        }
        this.stackValues = new int[arraySize];
    }

    /**
     * Gets the current capacity of the Stack.
     *
     * @return The length of the stackValues array.
     */
    final public int capacity() {
        return stackValues.length;
    }

    /**
     * Gets the current size of the Stack.
     *
     * @return The count of elements in the stackValues array.
     */
    final public int size() {
        return count;
    }

    /**
     * Gets the amount of unused space in the stackValues array.
     * The amount of unused space is calculated by subtracting the amount of elements the
     * stackValues array can hold by the number of elements currently stored within the array.
     *
     * @return The unused space in the stackValues array.
     */
    final public int unused() {
        return capacity() - size();
    }

    /**
     * Pushes a value into the Stack into the last element.
     * Will throw a StackOverflowException if there is no space to put the value in.
     *
     * @param value The value to be put into the Stack.
     * @throws StackOverflowException Throws this exception if there is no space in stackValues.
     */
    final public void push(final int value) throws StackOverflowException {
        if (unused() == 0) {
            throw new StackOverflowException("The stack is full!");
        }
        stackValues[count] = value;
        count++;
    }

    /**
     * Pops the last element in the Stack.
     * Will throw a StackUnderflowException if there are no elements inside the Stack.
     *
     * @return The value that was popped out.
     * @throws StackUnderflowException Throws this exception if there are no elements within
     * stackValues.
     */
    final public int pop() throws StackUnderflowException {
        if (size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.pop() on an empty stack!");
        }
        final int poppedValue;
        poppedValue = stackValues[count - 1];
        count--;
        return poppedValue;
    }

    /**
     * Returns the last element in the Stack.
     * Will throw a StackUnderflowException if there are no elements inside the Stack.
     *
     * @return The value at the top of the Stack
     * @throws StackUnderflowException Throws this exception if there are no elements within
     * stackValues.
     */
    final public int peek() throws StackUnderflowException {
        if (size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stack!");
        }
        count = 0;
        return stackValues[size()];
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Stack stack = (Stack) o;
        return count == stack.count
                && Arrays.equals(stackValues, stack.stackValues);
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(stackValues);
        return result;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Stack.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stack{");
        sb.append("stackValues=").append(Arrays.toString(stackValues));
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }


}
