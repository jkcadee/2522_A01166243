package ca.bcit.comp2522.assignments.a3;

abstract public class AbstractOperation implements Operation{
    protected char operationType;

    public AbstractOperation(char operationType) {
        this.operationType = operationType;
    }

    @Override
    public final char getSymbol() {
        return this.operationType;
    }
}
