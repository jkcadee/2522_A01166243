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
}
