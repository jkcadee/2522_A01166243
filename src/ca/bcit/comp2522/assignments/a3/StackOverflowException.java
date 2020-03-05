package ca.bcit.comp2522.assignments.a3;

/**
 * Throws an StackOverflowException. This exception is thrown if the Stack is full and a value is
 * attempted to be added.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class StackOverflowException extends Exception {

    public StackOverflowException() {
        super();
    }

    public StackOverflowException(final String s) {
        super(s);
    }
}
