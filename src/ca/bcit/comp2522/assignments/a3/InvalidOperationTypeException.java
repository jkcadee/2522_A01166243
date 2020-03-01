package ca.bcit.comp2522.assignments.a3;

public class InvalidOperationTypeException extends Exception {

    public InvalidOperationTypeException() {
        super();
    }

    public InvalidOperationTypeException(final String s) {
        super(s);
    }
}
