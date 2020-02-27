package ca.bcit.comp2522.assignments.a3;

public class Stack {
    private int[] stackValues;
    private int count;

    public Stack(final int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Array size value is too low.");
        }
        this.stackValues = new int[arraySize];
    }

    public int capacity() {
        return stackValues.length;
    }

    public int size() {
        return count;
    }

    public int unused() {
        return capacity() - size();
    }

    public void push(int value) throws StackOverflowException{
        if (unused() == 0) {
            throw new StackOverflowException("The stack is full!");
        }
        stackValues[count] = value;
        count++;
    }

    public int pop() throws StackUnderflowException{
        if (size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.pop() on an empty stack!");
        }
        int poppedValue;
        poppedValue = stackValues[count - 1];
        count--;
        return poppedValue;
    }

    public int peek() throws StackUnderflowException{
        if (size() == 0) {
            count = 0;
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stack!");
        }
        count = 0;
        return stackValues[size()];
    }
}
