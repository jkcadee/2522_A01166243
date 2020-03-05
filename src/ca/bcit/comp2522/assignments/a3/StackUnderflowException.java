package ca.bcit.comp2522.assignments.a3;

/**
 * Throws an InvalidOperationTypeException. This exception is thrown if the Stack is empty and
 * value is attempted to removed.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class StackUnderflowException extends Exception {

    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(final String s) {
        super(s);
    }
}
