package ca.bcit.cst.comp2522.a2;

public class DivisionOperation extends AbstractOperation {
    private static final char DIVISION_CODE = '/';

    /**
     * Constructor for DivisionOperation object.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * Performs division operation.
     * @param operandA as an int
     * @param operandB as an int
     * @return integer result
     */
    public int perform(int operandA, int operandB) {
        return operandB / operandA;
    }
}
