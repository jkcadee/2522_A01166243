package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates a Division Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public class DivisionOperation extends AbstractOperation {
    private static final char DIVISION_CODE = '/';

    /**
     * Constructs the DivisionOperation object.
     */

    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * Performs a division operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the division operation.
     */

    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within DivisionOperation.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DivisionOperation{");
        sb.append('}');
        return sb.toString();
    }
}
