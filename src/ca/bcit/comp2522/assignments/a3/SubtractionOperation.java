package ca.bcit.comp2522.assignments.a3;

public class SubtractionOperation extends AbstractOperation{
    private static final char SUBTRACTION_CODE = '-';

    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA - operandB;
    }
}
