package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates a Subtraction Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public class SubtractionOperation extends AbstractOperation {
    private static final char SUBTRACTION_CODE = '-';

    /**
     * Constructs the SubtractionOperation object.
     */

    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * Performs a subtraction operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the subtraction operation.
     */

    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA - operandB;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within SubtractionOperation.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubtractionOperation{");
        sb.append('}');
        return sb.toString();
    }
}
