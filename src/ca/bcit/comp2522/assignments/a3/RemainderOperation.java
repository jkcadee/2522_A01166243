package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates a Remainder Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class RemainderOperation extends AbstractOperation {
    private static final char REMAINDER_CODE = '%';

    /**
     * Constructs the remainder operation.
     */
    public RemainderOperation() {
        super(REMAINDER_CODE);
    }

    /**
     * Performs a remainder operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the remainder operation.
     */
    @Override
    final public int perform(final int operandA, final int operandB) {
        return operandA % operandB;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within RemainderOperation.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RemainderOperation{");
        sb.append('}');
        return sb.toString();
    }
}
