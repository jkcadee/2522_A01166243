package ca.bcit.comp2522.assignments.a3;

import java.util.Objects;

/**
 * Class that simulates a Operation overall. It is an abstract class.
 * This class implements the Operation interface.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public abstract class AbstractOperation implements Operation {
    /**
     * The character representing the operation.
     */
    protected char operationType;

    /**
     * Constructs the AbstractOperation object.
     * Assigns the given parameter to the operationType attribute.
     *
     * @param operationType The symbol for the operation to be used.
     */
    public AbstractOperation(final char operationType) {
        this.operationType = operationType;
    }

    /**
     * Gets the symbol of the operation.
     *
     * @return Returns the symbol.
     */
    @Override
    public final char getSymbol() {
        return this.operationType;
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param o The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractOperation that = (AbstractOperation) o;
        return operationType == that.operationType;
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(operationType);
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within AbstractOperation.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractOperation{");
        sb.append("operationType=").append(operationType);
        sb.append('}');
        return sb.toString();
    }
}
