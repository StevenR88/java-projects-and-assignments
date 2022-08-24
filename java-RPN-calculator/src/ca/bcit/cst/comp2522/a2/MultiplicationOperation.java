package ca.bcit.cst.comp2522.a2;

public class MultiplicationOperation extends AbstractOperation {
    private static final char MULTIPLICATION_CODE = '*';

    /**
     * Constructor for MultiplicationOperation object.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Performs multiplication operation.
     * @param operandA as an int
     * @param operandB as an int
     * @return integer result
     */
    public int perform(int operandA, int operandB) {
        return operandB * operandA;
    }
}
