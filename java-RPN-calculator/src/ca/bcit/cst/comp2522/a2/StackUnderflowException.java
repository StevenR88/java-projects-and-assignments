package ca.bcit.cst.comp2522.a2;

public class StackUnderflowException extends Exception {
    /**
     * Creates a new exception for Stack Underflow.
     * @param message as a string
     */
    public StackUnderflowException(final String message) {
        super(message);
    }
}
