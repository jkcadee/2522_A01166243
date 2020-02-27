package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

public class RPNCalculator {
    public static final int MIN_STACK_SIZE = 2;
    private Stack stack;

    public RPNCalculator(final int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        }
        this.stack = new Stack(stackSize);
    }

    public int processFormula(final String formula) throws StackOverflowException, InvalidOperationTypeException, StackUnderflowException {
        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException();
        }

        Scanner input = new Scanner(formula);

        while(input.hasNext()) {
            if (input.hasNextInt()) {
                this.push(input.nextInt());
            } else {
                Operation operation = this.getOperation(input.next().charAt(0));
                this.perform(operation);
            }

        }
        input.close();
        return this.getResult();
    }

    void push (final int operand) throws StackOverflowException{
        if (stack.unused() == 0) {
            throw new StackOverflowException("Cannot push to a full stack!");
        }
        stack.push(operand);
    }

    private Operation getOperation(final char symbol) throws InvalidOperationTypeException{
        switch(symbol) {
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
            default:
                throw new InvalidOperationTypeException("Invalid operation symbol.");
        }
    }

    public int getResult() throws StackUnderflowException{
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }

    private void perform(final Operation operation) throws StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        int operandOne = stack.pop();
        int operandTwo = stack.pop();

        int result = operation.perform(operandOne, operandTwo);
        this.push(result);
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
    public static void main(final String[] argv) {
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
