package ca.bcit.cst.comp2522.a2;

public class RemainderOperation extends AbstractOperation {
    private static final char REMAINDER_CODE = '%';

    /**
     * Constructor for RemainderOperation object.
     */
    public RemainderOperation() {
        super(REMAINDER_CODE);
    }

    /**
     * Performs remainder operation.
     * @param operandA as an int
     * @param operandB as an int
     * @return integer result
     */
    public int perform(int operandA, int operandB) {
        return operandB % operandA;
    }
}
