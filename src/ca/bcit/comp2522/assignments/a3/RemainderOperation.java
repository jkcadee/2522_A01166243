package ca.bcit.comp2522.assignments.a3;

public class RemainderOperation extends AbstractOperation{
    private static final char REMAINDER_CODE = '%';

    public RemainderOperation() {
        super(REMAINDER_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA % operandB;
    }
}
