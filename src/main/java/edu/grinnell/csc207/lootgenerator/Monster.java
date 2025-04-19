package edu.grinnell.csc207.lootgenerator;

/**
 * Represents a monster entry from monstats.txt. Represents the properties of a
 * monster, including its name, type, level, and treasure class.
 */
public class Monster {
    private final String name;
    private final String type;
    private final int level;
    private final String treasureClass;

    /**
     * Constructs a Monster.
     *
     * @param name
     * @param type
     * @param level
     * @param treasureClass
     */
    public Monster(String name, String type, int level, String treasureClass) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.treasureClass = treasureClass;
    }

    /**
     * Returns the monster's name.
     *
     * @return the monster's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the monster's type.
     *
     * @return the monster's type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the monster's level.
     *
     * @return the monster's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the monster's treasure class.
     *
     * @return the monster's treasure class
     */
    public String getTreasureClass() {
        return treasureClass;
    }
}
