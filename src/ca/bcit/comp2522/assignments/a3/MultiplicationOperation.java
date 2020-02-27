package ca.bcit.comp2522.assignments.a3;

public class MultiplicationOperation extends AbstractOperation{
    private static final char SUBTRACTION_CODE = '*';

    public MultiplicationOperation() {
        super(SUBTRACTION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA * operandB;
    }
}
