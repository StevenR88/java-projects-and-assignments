package ca.bcit.comp2522.assignment4;

import java.util.Random;

public class Die10 extends Die6 {

    /**
     * Simulates rolling a 10 sided die.
     * @return int
     */
    public int rollDie() {
        final Random diceRoll = new Random();
        return diceRoll.nextInt(10) + 1;
    }
}
