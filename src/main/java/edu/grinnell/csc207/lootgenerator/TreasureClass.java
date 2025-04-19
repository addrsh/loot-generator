package edu.grinnell.csc207.lootgenerator;

/**
 * Represents a treasure class entry from TreasureClassEx.txt. Represents the
 * properties of a treasure class, including its name and possible drops.
 */
public class TreasureClass {
    private final String name;
    private final String item1;
    private final String item2;
    private final String item3;

    /**
     * Constructs a TreasureClass.
     *
     * @param name  name of the treasure class
     * @param item1 first possible drop
     * @param item2 second possible drop
     * @param item3 third possible drop
     */
    public TreasureClass(String name, String item1, String item2, String item3) {
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    /**
     * Returns the name of the treasure class.
     *
     * @return name of the treasure class
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the first possible drop.
     *
     * @return first item
     */
    public String getItem1() {
        return item1;
    }

    /**
     * Returns the second possible drop.
     *
     * @return second item
     */
    public String getItem2() {
        return item2;
    }

    /**
     * Returns the third possible drop.
     *
     * @return third item
     */
    public String getItem3() {
        return item3;
    }

    /**
     * Returns all possible drops as an array.
     *
     * @return an array of all items
     */
    public String[] getItems() {
        return new String[] {item1, item2, item3};
    }
}
