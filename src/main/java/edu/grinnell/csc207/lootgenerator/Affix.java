package edu.grinnell.csc207.lootgenerator;

/**
 * Represents a prefix or suffix affix entry from MagicPrefix.txt or
 * MagicSuffix.txt.
 */
public class Affix {
    private final String name;
    private final String stat;
    private final int min;
    private final int max;

    /**
     * Constructs an Affix.
     *
     * @param name Affix name
     * @param stat Statistic text
     * @param min  Minimum stat value
     * @param max  Maximum stat value
     */
    public Affix(String name, String stat, int min, int max) {
        this.name = name;
        this.stat = stat;
        this.min = min;
        this.max = max;
    }

    /** @return affix name */
    public String getName() {
        return name;
    }

    /** @return statistic text */
    public String getStat() {
        return stat;
    }

    /** @return minimum stat value */
    public int getMin() {
        return min;
    }

    /** @return maximum stat value */
    public int getMax() {
        return max;
    }
}
