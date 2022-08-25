package ca.bcit.comp2522.assignment4;

import java.util.Random;

public class Die20 extends Die6 {

    /**
     * Simulates rolling a 20 sided die.
     * @return int
     */
    public int rollDie() {
        final Random diceRoll = new Random();
        return diceRoll.nextInt(20) + 1;
    }
}
