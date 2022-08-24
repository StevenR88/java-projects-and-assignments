package ca.bcit.cst.comp2522.a2;

public class InvalidOperationTypeException extends Exception {
    /**
     * Creates a new exception for Invalid Operations.
     * @param message as a string
     */
    public InvalidOperationTypeException(final String message) {
        super(message);
    }
}
