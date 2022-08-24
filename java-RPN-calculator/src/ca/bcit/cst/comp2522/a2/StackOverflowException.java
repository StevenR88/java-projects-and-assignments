package ca.bcit.cst.comp2522.a2;

public class StackOverflowException  extends Exception {
    /**
     * Creates a new exception for Stack Overflow.
     * @param message as a string
     */
    public StackOverflowException(final String message) {
        super(message);
    }
}
