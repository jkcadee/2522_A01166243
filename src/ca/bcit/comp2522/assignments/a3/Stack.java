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
        for (int value : stackValues) {
            if (value > 1) {
                count++;
            }
        }
        return count;
    }

    public int unused() {
        int unusedSpace = 0;
        for (int value : stackValues) {
            if (value == 0) {
                unusedSpace++;
            }
        }
        return unusedSpace;
    }

    public void push(int value) throws StackOverflowException{
        if (unused() == 0) {
            throw new StackOverflowException("The stack is full!");
        }
        for (int index = 0; index < stackValues.length; index++) {
            if (stackValues[index] == 0) {
                stackValues[index] = value;
                break;
            }
        }
    }

    public int pop() throws StackUnderflowException{
        if (size() == 0) {
            count = 0;
            throw new StackUnderflowException("Cannot call Stack.pop() on an empty stack!");
        }
        int poppedValue;
        for (int index = 0; index < stackValues.length; index++) {
            if (index == stackValues.length - 1) {
                poppedValue = stackValues[index];
                stackValues[index] = 0;
                return poppedValue;
            }

            if (stackValues[index + 1] == 0) {
                poppedValue = stackValues[index];
                stackValues[index] = 0;
                return poppedValue;
            }
        }
        return 0;
    }

    public int peek() throws StackUnderflowException{
        if (size() == 0) {
            count = 0;
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stack!");
        }
        count = 0;
        return stackValues[size() - 1];
    }
}
