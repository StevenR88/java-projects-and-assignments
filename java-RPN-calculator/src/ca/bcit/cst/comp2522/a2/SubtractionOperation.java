package ca.bcit.cst.comp2522.a2;

public class SubtractionOperation extends AbstractOperation {
    private static final char SUBTRACTION_CODE = '-';

    /**
     * Constructor for SubtractionOperation object.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * Performs subtraction operation.
     * @param operandA as an int
     * @param operandB as an int
     * @return integer result
     */
    public int perform(int operandA, int operandB) {
        return operandB - operandA;
    }
}
