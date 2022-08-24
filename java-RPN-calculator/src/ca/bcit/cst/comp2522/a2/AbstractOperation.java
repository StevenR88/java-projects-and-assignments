package ca.bcit.cst.comp2522.a2;

public abstract class AbstractOperation implements Operation {
    protected char operationType;

    /**
     * Constructor for AbstractOperation object.
     * @param operator as a char
     */
    public AbstractOperation(char operator) {
        this.operationType = operator;
    }

    @Override
    public char getSymbol() {
        return operationType;
    }
}
