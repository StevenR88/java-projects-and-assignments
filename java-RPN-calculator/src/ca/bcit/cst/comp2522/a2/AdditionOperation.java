package ca.bcit.cst.comp2522.a2;

public class AdditionOperation extends AbstractOperation {
    private static final char ADDITION_CODE = '+';

    /**
     * Constructor for AdditionOperation object.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Performs addition operation.
     * @param operandA as an int
     * @param operandB as an int
     * @return integer result
     */
    public int perform(int operandA, int operandB) {
        return operandB + operandA;
    }
}
