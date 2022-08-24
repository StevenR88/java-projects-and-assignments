package ca.bcit.cst.comp2522.a2;

public interface Operation {
    /**
     * Abstract method for returning operation symbol to user.
     * @return char
     */
    char getSymbol();

    /**
     * Abstract method for performing a math operation.
     * @param operandA as aa int
     * @param operandB as an int
     * @return int
     */
    int perform(int operandA, int operandB);
}

