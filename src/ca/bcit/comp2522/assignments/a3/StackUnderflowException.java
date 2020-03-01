package ca.bcit.comp2522.assignments.a3;

public class StackUnderflowException extends Exception {

    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(final String s) {
        super(s);
    }
}
