package ca.bcit.cst.comp2522.a2;

import java.util.Scanner;

public class RPNCalculator {

    protected static final int MIN_STACK_SIZE = 2;
    private final Stack stack;

    /**
     * Constructor for RPNCalculator object.
     *
     * @param stackSize as an int
     */
    public RPNCalculator(int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        }
        this.stack = new Stack(stackSize);
    }

    /**
     * Method to process a formula and add it to stack.
     * @param formula as a String
     * @return int
     * @throws StackOverflowException exception
     */
    public int processFormula(final String formula)
            throws StackOverflowException, InvalidOperationTypeException,
            StackUnderflowException {
        if (formula == null) {
            throw new IllegalArgumentException();
        }
        Scanner scan = new Scanner(formula);
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                push(scan.nextInt());
            } else {
                perform(getOperation(scan.next().charAt(0)));
            }
        }
        return getResult();
}

    /**
     * Pushes an operand to the stack.
     * @param operand as an int
     * @throws StackOverflowException exception
     */
    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("Stack is full.");
        } else {
            stack.push(operand);
        }
    }

    private Operation getOperation(final char symbol)
            throws InvalidOperationTypeException {
        return switch (symbol) {
            case '+' -> new AdditionOperation();
            case '-' -> new SubtractionOperation();
            case '*' -> new MultiplicationOperation();
            case '/' -> new DivisionOperation();
            case '%' -> new RemainderOperation();
            default -> throw new InvalidOperationTypeException(
                    "Invalid Operation.");
        };
    }

    /**
     * Gets final result of stack operations.
     * @return result as an int
     * @throws StackUnderflowException exception
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException(
                    "There are no operands");
        } else {
            return stack.peek();
        }
    }

    protected void perform(final Operation operation) throws
            StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        } else {
            stack.push(operation.perform(stack.pop(), stack.pop()));
        }
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     * Example usage: RPNCalculator 10 "1 2 +"
     * Note that the formula MUST be placed inside of double quotes.
     * @param argv - the command line arguments are the size of the Stack
     * to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {

// Checks for correct number of command line arguments.

        if (argv.length != 2) {
            System.err.println(
                    "Usage: Main <stack size> <formula>"); System.exit(1);
        }

// Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);

        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain"
                    + "integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula,"
                    + " increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }

}
