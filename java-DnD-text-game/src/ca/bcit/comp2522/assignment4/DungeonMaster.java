package ca.bcit.comp2522.assignment4;

import java.util.ArrayList;
import java.util.Random;

public class DungeonMaster {

    /**
     * Is valid character boolean.
     *
     * @param character the character
     * @return the boolean
     */
    private boolean isValidCharacter(final Character character) {
        if (character.getCharName() == null
                || character.getCharName().isEmpty()) {
            return false;
        } else {
            return !((character.getCategory("Weapons").size()) < 2)
                    && !((character.getCategory("Potions").size()) < 1)
                    && !((character.getCategory("Equipment").size()) < 1);
        }
    }

    /**
     * Combat attack int.
     *
     * @param opponentOne the opponent one
     * @param opponentTwo the opponent two
     * @param charHP      the char hp
     * @return the int
     */
    private int combatAttack(final Character opponentOne,
                                         final Character opponentTwo,
                                         int charHP) {
        Die20 die20 = new Die20();
        System.out.println(opponentOne.getCharName() + " attacks!");
        if (die20.rollDie() > opponentTwo.getCharDex()) {
            System.out.println(opponentOne.getCharName()
                    + " has struck " + opponentTwo.getCharName());
            int damageReceived = (new Random().nextInt(
                    opponentOne.getCharHit()) + 1);
            System.out.println(opponentTwo.getCharName() + " receives "
                    + damageReceived + " damage.");
            charHP = charHP - damageReceived;
        } else {
            System.out.println(opponentOne.getCharName() + " has missed!");
        }
        System.out.println(opponentTwo.getCharName() + " has " + charHP
                + " health remaining.");
        return charHP;
    }

    /**
     * Combat result.
     *
     * @param opponentOne the opponent one
     * @param opponentTwo the opponent two
     */
    private void combatResult(final Character opponentOne,
                             final Character opponentTwo) {
        int xpReward = 10;
        System.out.println(opponentOne.getCharName()
                + " has defeated "
                + opponentTwo.getCharName() + ".");
        System.out.println(opponentOne.getCharName() + " gains "
                + xpReward + "XP.\n");
        opponentOne.setCharXp(opponentOne.getCharXp() + xpReward);
    }

    /**
     * Combat round.
     *
     * @param opponentOne   the opponent one
     * @param opponentTwo   the opponent two
     * @param initialStrike the initial strike
     */
    private void combatRound(final Character opponentOne,
                            final Character opponentTwo, int initialStrike) {
        int char1HP = opponentOne.getCharHP();
        int char2HP = opponentTwo.getCharHP();

        while (char1HP >= 0 && char2HP >= 0) {
            if (initialStrike == 1) {
                char2HP = combatAttack(opponentOne, opponentTwo, char2HP);
                if (char2HP <= 0) {
                    combatResult(opponentOne, opponentTwo);
                    return;
                }
                char1HP = combatAttack(opponentTwo, opponentOne, char1HP);
            } else {
                char1HP = combatAttack(opponentTwo, opponentOne, char1HP);
                if (char1HP <= 0) {
                    combatResult(opponentTwo, opponentOne);
                    return;
                }
                char2HP = combatAttack(opponentOne, opponentTwo, char2HP);
            }
            if (char1HP <= 0) {
                combatResult(opponentTwo, opponentOne);
                return;
            }
            if (char2HP <= 0) {
                combatResult(opponentOne, opponentTwo);
                return;
            }
        }
    }

    /**
     * Sets up inventory.
     *
     * @param newCharacter the new character
     */
    private void setUpInventory(final Character newCharacter) {
        ArrayList<String> weaponList = new ArrayList<>();
        ArrayList<String> potionList = new ArrayList<>();
        ArrayList<String> equipmentList = new ArrayList<>();
        newCharacter.getCharInventory().put("Weapons", weaponList);
        newCharacter.getCharInventory().put("Potions", potionList);
        newCharacter.getCharInventory().put("Equipment", equipmentList);
    }

    /**
     * Create barbarian character.
     *
     * @param charName  the char name
     * @param charClass the char class
     * @param charRace  the char race
     * @return the character
     */
    public Character createBarbarian(final String charName, final int charClass,
                                     final int charRace) {
        Character barbarian = new Character(charName, charClass, charRace);
        setUpInventory(barbarian);
        barbarian.addWeapon("Golden Sword");
        barbarian.addWeapon("Silver Sword");
        barbarian.addPotion("Health");
        barbarian.addEquipment("Plate Mail");
        return barbarian;
    }

    /**
     * Create warlock character.
     *
     * @param charName  the char name
     * @param charClass the char class
     * @param charRace  the char race
     * @return the character
     */
    public Character createWarlock(final String charName, final int charClass,
                                   final int charRace) {
        Character warlock = new Character(charName, charClass, charRace);
        setUpInventory(warlock);
        warlock.addWeapon("Dagger");
        warlock.addWeapon("Staff");
        warlock.addPotion("Mana");
        warlock.addEquipment("Robe");
        return warlock;
    }

    /**
     * Create sorcerer character.
     *
     * @param charName  the char name
     * @param charClass the char class
     * @param charRace  the char race
     * @return the character
     */
    public Character createSorcerer(final String charName, final int charClass,
                                   final int charRace) {
        Character sorcerer = new Character(charName, charClass, charRace);
        setUpInventory(sorcerer);
        sorcerer.addWeapon("Wand");
        sorcerer.addWeapon("Staff");
        sorcerer.addPotion("Mana");
        sorcerer.addEquipment("Robe");
        return sorcerer;
    }

    /**
     * Create ranger character.
     *
     * @param charName  the char name
     * @param charClass the char class
     * @param charRace  the char race
     * @return the character
     */
    public Character createRanger(final String charName, final int charClass,
                                    final int charRace) {
        Character ranger = new Character(charName, charClass, charRace);
        setUpInventory(ranger);
        ranger.addWeapon("Longbow");
        ranger.addWeapon("Silver Sword");
        ranger.addPotion("Health");
        ranger.addEquipment("Wooden Shield");
        return ranger;
    }

    /**
     * Create cleric character.
     *
     * @param charName  the char name
     * @param charClass the char class
     * @param charRace  the char race
     * @return the character
     */
    public Character createCleric(final String charName, final int charClass,
                                  final int charRace) {
        Character cleric = new Character(charName, charClass, charRace);
        setUpInventory(cleric);
        cleric.addWeapon("Staff");
        cleric.addWeapon("Silver Sword");
        cleric.addPotion("Mana");
        cleric.addEquipment("Robe");
        return cleric;
    }

    /**
     * Create rogue character.
     *
     * @param charName  the char name
     * @param charClass the char class
     * @param charRace  the char race
     * @return the character
     */
    public Character createRogue(final String charName, final int charClass,
                                  final int charRace) {
        Character rogue = new Character(charName, charClass, charRace);
        setUpInventory(rogue);
        rogue.addWeapon("Dagger");
        rogue.addWeapon("Dagger");
        rogue.addPotion("Stamina");
        rogue.addEquipment("Chain mail");
        return rogue;
    }

    /**
     * Print intro.
     *
     * @param newCharacter1 the new character 1
     * @param newCharacter2 the new character 2
     */
    private void printIntro(final Character newCharacter1,
                                  final Character newCharacter2) {
        System.out.println(newCharacter1.getCharName() + " the "
                + newCharacter1.getCharRaceName() + " "
                + newCharacter1.getCharClassName()
                + " vs " + newCharacter2.getCharName() + " the "
                + newCharacter2.getCharRaceName() + " "
                + newCharacter2.getCharClassName());
        System.out.println(newCharacter1.getCharName() + " has "
                + newCharacter1.getCharHP() + "HP.");
        System.out.println(newCharacter2.getCharName() + " has "
                + newCharacter2.getCharHP() + "HP.");
    }

    /**
     * Run combat.
     *
     * @param newOpponent1  the new opponent 1
     * @param newOpponent2  the new opponent 2
     * @param initialStrike the initial strike
     */
    public void runCombat(final Character newOpponent1,
                          final Character newOpponent2,
                          final int initialStrike) {
        printIntro(newOpponent1, newOpponent2);
        if (isValidCharacter(newOpponent1) && isValidCharacter(newOpponent2)) {
            combatRound(newOpponent1, newOpponent2, initialStrike);
        }
    }


}
