package ca.bcit.COMP2522.assignments.assignment01;

import java.io.Serializable;

public interface Sellable extends Serializable {
    /**
     * Empty method for isSellable implementation.
     * @return boolean
     */
    boolean isSellable();

    /**
     * Empty method for setSellable implementation.
     * @param state as a boolean
     */
    void setSellable(boolean state);
}
