package edu.grinnell.csc207.lootgenerator;

/**
 * Represents the properties of an armor, including its name and defense values.
 */
public class Armor {
    private final String name;
    private final int minAc;
    private final int maxAc;

    /**
     * Constructs an Armor.
     * 
     * @param name  name of the armor
     * @param minAc minimum defense value of the armor
     * @param maxAc maximum defense value of the armor
     */
    public Armor(String name, int minAc, int maxAc) {
        this.name = name;
        this.minAc = minAc;
        this.maxAc = maxAc;
    }

    /**
     * Returns the name of the armor.
     * 
     * @return name of the armor
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the minimum defense value of the armor.
     * 
     * @return minimum defense value
     */
    public int getMinAc() {
        return minAc;
    }

    /**
     * Returns the maximum defense value of the armor.
     * 
     * @return maximum defense value
     */
    public int getMaxAc() {
        return maxAc;
    }
}
