package ca.bcit.comp2522.assignment4;

public class TestDandD {

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        DungeonMaster dm = new DungeonMaster();
        Character barbarian = dm.createBarbarian("Fyorg", 0, 1);
        Character warlock = dm.createWarlock("Malice", 10, 7);
        Character sorcerer = dm.createSorcerer("Saruman", 9, 7);
        Character ranger = dm.createRanger("Aragorn", 7, 7);
        Character cleric = dm.createCleric("Uther", 2, 7);
        Character rogue = dm.createRogue("Maris", 8, 2);

        dm.runCombat(barbarian, warlock, 1);
        dm.runCombat(sorcerer, ranger, 1);
        dm.runCombat(cleric, rogue, 2);
        dm.runCombat(barbarian, ranger, 2);
        dm.runCombat(sorcerer, rogue, 1);
        dm.runCombat(cleric, warlock, 2);
    }
}
