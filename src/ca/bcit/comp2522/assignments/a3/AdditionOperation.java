package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates an Addition Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {
    private static final char ADDITION_CODE = '+';

    /**
     * Constructs an AdditionOperation object.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Performs an addition operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the addition operation.
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within AdditionOperation.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdditionOperation{");
        sb.append('}');
        return sb.toString();
    }
}
