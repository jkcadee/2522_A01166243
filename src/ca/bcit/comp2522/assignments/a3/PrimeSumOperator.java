package ca.bcit.comp2522.assignments.a3;

/**
 * Class that simulates a PrimeSum Operation.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public class PrimeSumOperator extends AbstractOperation {
    private static final char PRIMESUM_CODE = '@';

    /**
     * Constructs the PrimeSumOperator object.
     */

    public PrimeSumOperator() {
        super(PRIMESUM_CODE);
    }

    /**
     * Performs a prime sum operation with the operands.
     *
     * @param operandA First operand to be used.
     * @param operandB Second operand to be used.
     * @return The result of the prime sum operation.
     */

    @Override
    public int perform(final int operandA, final int operandB) {
        int sum = 0;

        if (operandA > operandB) {
            return this.perform(operandB, operandA);
        }

        for (int num = operandA; num <= operandB; num++) {
            boolean isPrime = true;
            for (int checkAgainst = 2; checkAgainst < num; checkAgainst++) {
                if (num % checkAgainst == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && num > 1) {
                sum += num;
            }
        }
        return sum;
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within PrimeSumOperator.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrimeSumOperator{");
        sb.append('}');
        return sb.toString();
    }
}
