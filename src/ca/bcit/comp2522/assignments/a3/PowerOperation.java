package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates a Power Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class PowerOperation extends AbstractOperation {
    private static final char POWER_CODE = '^';

    /**
     * Constructs the PowerOperation object.
     */
    public PowerOperation() {
        super(POWER_CODE);
    }

    /**
     * Performs a power operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the power operation.
     */
    @Override
    final public int perform(int operandA, final int operandB) {
        if (operandB == 0) {
            return 1;
        }

        int powerProduct = 1;

        for (int pow = 0; pow < operandB; pow++) {
            powerProduct *= operandA;
        }

        return powerProduct;
     }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within PowerOperation.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PowerOperation{");
        sb.append('}');
        return sb.toString();
    }
}
