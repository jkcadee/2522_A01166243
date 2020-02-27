package ca.bcit.comp2522.assignments.a3;

public class PowerOperation extends AbstractOperation{
    private static final char POWER_CODE = '^';

    public PowerOperation() {
        super(POWER_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        int originalOperandA = operandA;
        for (int pow = 0; pow < operandB; pow++) {
            operandA *= originalOperandA;
        }
        return operandA;
     }
}
