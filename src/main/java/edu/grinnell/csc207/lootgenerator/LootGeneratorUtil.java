package edu.grinnell.csc207.lootgenerator;

import java.util.*;

/**
 * Utility class for loot generation logic, including monster selection, base
 * item generation,
 * stat calculation, and affix selection.
 */
public class LootGeneratorUtil {
    /**
     * Randomly selects a monster from the list.
     *
     * @param monsters list of monsters
     * @param rand     random number generator
     * @return a randomly selected Monster
     */
    public static Monster pickMonster(List<Monster> monsters, Random rand) {
        return monsters.get(rand.nextInt(monsters.size()));
    }

    /**
     * Recursively resolves treasure classes to generate a base item.
     *
     * @param tcName name of the treasure class
     * @param tcMap  map of treasure class names to TreasureClass objects
     * @param rand   random number generator
     * @return the name of the base item
     */
    public static String generateBaseItem(
            String tcName, Map<String, TreasureClass> tcMap, Random rand) {
        TreasureClass tc = tcMap.get(tcName);
        if (tc == null) {
            return tcName;
        }
        String[] items = tc.getItems();
        String pick = items[rand.nextInt(items.length)];
        if (tcMap.containsKey(pick)) {
            return generateBaseItem(pick, tcMap, rand);
        } else {
            return pick;
        }
    }

    /**
     * Returns a random defense value for an armor item, or -1 if not armor.
     *
     * @param baseItem name of the base item
     * @param armorMap map of armor names to Armor objects
     * @param rand     random number generator
     * @return defense value, or -1 if not an armor
     */
    public static int generateBaseStats(String baseItem, Map<String, Armor> armorMap, Random rand) {
        Armor armor = armorMap.get(baseItem);
        if (armor == null) {
            return -1;
        }
        int min = armor.getMinAc();
        int max = armor.getMaxAc();
        return min + rand.nextInt(max - min + 1);
    }

    /**
     * Randomly selects an affix from the list with a 50% chance, or null.
     *
     * @param affixes list of affixes
     * @param rand    random number generator
     * @return a randomly selected Affix or null
     */
    public static Affix maybePickAffix(List<Affix> affixes, Random rand) {
        if (affixes.isEmpty() || rand.nextBoolean() == false) {
            return null;
        }
        return affixes.get(rand.nextInt(affixes.size()));
    }
}
