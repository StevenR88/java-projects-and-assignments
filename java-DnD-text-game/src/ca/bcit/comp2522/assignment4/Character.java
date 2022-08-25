package ca.bcit.comp2522.assignment4;

import java.util.ArrayList;
import java.util.Hashtable;

public class Character {
    private final String charName;
    private final Hashtable<String, ArrayList<String>> charInventory;
    private enum Class {
        /**
         * Barbarian class.
         */
        Barbarian,
        /**
         * Bard class.
         */
        Bard,
        /**
         * Cleric class.
         */
        Cleric,
        /**
         * Druid class.
         */
        Druid,
        /**
         * Fighter class.
         */
        Fighter,
        /**
         * Monk class.
         */
        Monk,
        /**
         * Paladin class.
         */
        Paladin,
        /**
         * Ranger class.
         */
        Ranger,
        /**
         * Rogue class.
         */
        Rogue,
        /**
         * Sorcerer class.
         */
        Sorcerer,
        /**
         * Warlock class.
         */
        Warlock,
        /**
         * Wizard class.
         */
        Wizard
    }
    private enum Race {
        /**
         * Dragonborn race.
         */
        Dragonborn,
        /**
         * Dwarf race.
         */
        Dwarf,
        /**
         * Elf race.
         */
        Elf,
        /**
         * Gnome race.
         */
        Gnome,
        /**
         * Half elf race.
         */
        HalfElf,
        /**
         * Halfling race.
         */
        Halfling,
        /**
         * Half orc race.
         */
        HalfOrc,
        /**
         * Human race.
         */
        Human,
        /**
         * Tiefling race.
         */
        Tiefling
    }
    private int charXp;
    private final int charClass;
    private final int charRace;
    private final int charHP;
    private final int charDex;
    private final int charHit;

    /**
     * Instantiates a new Character.
     *
     * @param characterName  the character name
     * @param characterClass the character class
     * @param characterRace  the character race
     */
    public Character(final String characterName,
                     final int characterClass, final int characterRace) {
        Die6 die6 = new Die6();
        Die8 die8 = new Die8();
        Die10 die10 = new Die10();
        Die12 die12 = new Die12();
        this.charName = characterName;
        this.charInventory = new Hashtable<>();
        this.charXp = 0;
        this.charClass = characterClass;
        this.charRace = characterRace;
        this.charHP = switch (characterClass) {
            case 0 -> die12.rollDie();
            case 4, 6, 7 -> die10.rollDie();
            case 1, 2, 3, 5, 8, 10 -> die8.rollDie();
            case 9, 11 -> die6.rollDie();
            default -> 0;
        };
        this.charDex = die12.rollDie() + 8;
        this.charHit = switch (characterClass) {
            case 0 -> 12;
            case 4, 6, 7 -> 10;
            case 1, 2, 3, 5, 8, 10 -> 8;
            case 9, 11 -> 6;
            default -> 0;
        };
    }


    /**
     * List class.
     */
    public static void listClass() {
        System.out.println("Select your class: ");
        for (Class selection : Class.values()) {
            System.out.println(selection);
        }
    }

    /**
     * List race.
     */
    public static void listRace() {
        System.out.println("Select your race: ");
        for (Race selection : Race.values()) {
            System.out.println(selection);
        }
    }

    /**
     * Choose inventory.
     */
    public static void chooseInventory() {
        ArrayList<String> weaponList = new ArrayList<>();
        weaponList.add("Golden Sword");
        weaponList.add("Silver Sword");
        weaponList.add("Bronze Sword");
        weaponList.add("Crossbow");
        weaponList.add("Longbow");
        weaponList.add("Battle Axe");
        weaponList.add("Rapier");
        weaponList.add("Dagger");
        weaponList.add("Staff");
        ArrayList<String> potionList = new ArrayList<>();
        potionList.add("Mana");
        potionList.add("Health");
        potionList.add("Rejuvenation");
        potionList.add("Stamina");
        ArrayList<String> equipmentList = new ArrayList<>();
        equipmentList.add("Wooden Shield");
        equipmentList.add("Steel Shield");
        equipmentList.add("Chain Mail");
        equipmentList.add("Plate Mail");
        equipmentList.add("Eternium Shield");
        weaponList.add("Robe");

        System.out.println("Select your weapons:");
        for (String weapon : weaponList) {
            System.out.println(weapon);
        }

        System.out.println("Select your potions:");
        for (String potion : potionList) {
            System.out.println(potion);
        }

        System.out.println("Select your equipment:");
        for (String equipment : equipmentList) {
            System.out.println(equipment);
        }
    }
    /**
     * Gets char inventory.
     *
     * @return the char inventory
     */
    public Hashtable<String, ArrayList<String>> getCharInventory() {
        return charInventory;
    }

    /**
     * Add weapon.
     *
     * @param weaponName the weapon name
     */
    public void addWeapon(final String weaponName) {
        charInventory.get("Weapons").add(weaponName);
    }

    /**
     * Add potion.
     *
     * @param potionName the potion name
     */
    public void addPotion(final String potionName) {
        charInventory.get("Potions").add(potionName);
    }

    /**
     * Add equipment.
     *
     * @param equipmentName the equipment name
     */
    public void addEquipment(final String equipmentName) {
        charInventory.get("Equipment").add(equipmentName);
    }

    /**
     * Gets category.
     *
     * @param category the category
     * @return the category
     */
    public ArrayList<String> getCategory(final String category) {
        return charInventory.get(category);
    }

    /**
     * Gets char name.
     *
     * @return the char name
     */
    public String getCharName() {
        return charName;
    }

    /**
     * Gets char xp.
     *
     * @return the char xp
     */
    public int getCharXp() {
        return charXp;
    }

    /**
     * Gets char class.
     *
     * @return the char class
     */
    public int getCharClass() {
        return charClass;
    }

    /**
     * Gets char class name by taking index of Class enum from int
     * present as charClass variable.
     *
     * @return the char class name
     */
    public Class getCharClassName() {
        return Class.values()[this.getCharClass()];
    }

    /**
     * Gets char race.
     *
     * @return the char race
     */
    public int getCharRace() {
        return charRace;
    }

    /**
     * Gets char race name by taking index of Race enum from int
     * present as charRace variable.
     *
     * @return the char class name
     */
    public Race getCharRaceName() {
        return Race.values()[this.getCharRace()];
    }

    /**
     * Gets char hp.
     *
     * @return the char hp
     */
    public int getCharHP() {
        return charHP;
    }

    /**
     * Gets char dex.
     *
     * @return the char dex
     */
    public int getCharDex() {
        return charDex;
    }

    /**
     * Gets char hit.
     *
     * @return the char hit
     */
    public int getCharHit() {
        return charHit;
    }

    /**
     * Sets char xp.
     *
     * @param newCharXp the new char xp
     */
    public void setCharXp(final int newCharXp) {
        charXp = newCharXp;
    }
}
