package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates a Multiplication Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {
    private static final char MULTIPLICATION_CODE = '*';

    /**
     * Constructs the MultiplicationOperation object.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Performs a multiplication operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the multiplication operation.
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within MultiplicationOperation.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MultiplicationOperation{");
        sb.append('}');
        return sb.toString();
    }
}
