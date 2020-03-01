package ca.bcit.comp2522.assignments.a3;

/**
 * Interface that simulates a Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public interface Operation {
    /**
     * Gets the symbol of the operation.
     *
     * @return Returns the symbol.
     */

    char getSymbol();

    /**
     * Performs the specified operations with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the operation.
     */

    int perform(final int operandA, final int operandB);
}
