package ca.bcit.comp2522.assignments.a3;

public class AdditionOperation extends AbstractOperation {
    private static final char ADDITION_CODE = '+';

    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA + operandB;
    }
}
