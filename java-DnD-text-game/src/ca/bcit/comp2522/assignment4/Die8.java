package ca.bcit.comp2522.assignment4;

import java.util.Random;

public class Die8 extends Die6 {

    /**
     * Simulates rolling an 8 sided die.
     * @return int
     */
    public int rollDie() {
        final Random diceRoll = new Random();
        return diceRoll.nextInt(8) + 1;
    }
}
