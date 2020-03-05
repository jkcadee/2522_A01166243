package ca.bcit.comp2522.assignments.a3;

/**
 * Throws an InvalidOperationTypeException. This exception is thrown if the inputted operation
 * is not valid.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class InvalidOperationTypeException extends Exception {

    public InvalidOperationTypeException() {
        super();
    }

    public InvalidOperationTypeException(final String s) {
        super(s);
    }
}
