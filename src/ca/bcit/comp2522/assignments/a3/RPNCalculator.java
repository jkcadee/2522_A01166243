package ca.bcit.comp2522.assignments.a3;

import java.util.Objects;
import java.util.Scanner;

/**
 * Class that simulates a RPN Calculator.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */

public class RPNCalculator {
    /**
     * The minimum size a Stack can be to perform an Operation.
     */
    public static final int MIN_STACK_SIZE = 2;
    private Stack stack;

    /**
     * Constructs the RPNCalculator object.
     * Throws IllegalArgumentException if the passed in parameter is too low.
     *
     * @param stackSize The size of the Stack.
     */

    public RPNCalculator(final int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException("Size cannot be smaller than 2!");
        }
        this.stack = new Stack(stackSize);
    }

    /**
     * Processes the command line arguments and calculates them.
     * The result is stored in the Stack.
     *
     * @param formula The command line argument.
     * @return A select operation.
     * @throws StackOverflowException Throws this exception if there is no space in stackValues.
     * @throws InvalidOperationTypeException Throws this exception is an invalid operation
     * symbol is passed.
     * @throws StackUnderflowException Throws this exception if there are no elements within
     * the Stack.
     */

    public int processFormula(final String formula) throws StackOverflowException,
            InvalidOperationTypeException, StackUnderflowException {
        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException();
        }

        final Scanner input = new Scanner(formula);

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                this.push(input.nextInt());
            } else {
                final Operation operation = this.getOperation(input.next().charAt(0));
                this.perform(operation);
            }

        }
        input.close();
        return this.getResult();
    }

    /**
     * Pushes the operand into the stack. Will throw a StackOverflowException if the stack is full.
     *
     * @param operand The value to be pushed into the stack.
     */

    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("Cannot push to a full stack!");
        }
        stack.push(operand);
    }

    /*
     * Gets the operation depending on the passed in symbol. Will throw an
     * InvalidOperationTypeException if the symbol is not within a case statement.
     */

    private Operation getOperation(final char symbol) throws InvalidOperationTypeException {
        switch (symbol) {
            case '+':
                return new AdditionOperation();
            case '-':
                return new SubtractionOperation();
            case '*':
                return new MultiplicationOperation();
            case '/':
                return new DivisionOperation();
            case '%':
                return new RemainderOperation();
            case '^':
                return new PowerOperation();
            case '@':
                return new PrimeSumOperator();
            default:
                throw new InvalidOperationTypeException("Invalid operation symbol.");
        }
    }

    /**
     * Gets the result at the top of Stack, being the result of the operation(s).
     *
     * @return The last element in the Stack.
     * @throws StackUnderflowException Throws this exception if there are no elements within
     * the Stack.
     */

    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }

    /**
     * Performs the operation using the requisite Operation object and the last two values in the
     * Stack.
     *
     * @param operation The operation that will be applied to the two operands.
     */

    public void perform(final Operation operation) throws StackUnderflowException,
            StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        final int operandTwo = stack.pop();
        final int operandOne = stack.pop();

        final int result = operation.perform(operandOne, operandTwo);
        this.push(result);
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RPNCalculator that = (RPNCalculator) o;
        return Objects.equals(stack, that.stack);
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */

    @Override
    public int hashCode() {
        return Objects.hash(stack);
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within RPNCalculator.
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RPNCalculator{");
        sb.append("stack=").append(stack);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     * to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) throws StackUnderflowException {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
