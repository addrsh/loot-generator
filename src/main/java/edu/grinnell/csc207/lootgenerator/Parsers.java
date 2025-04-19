package edu.grinnell.csc207.lootgenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Utility class for parsing data files into structured data classes for the
 * loot generator.
 */
public class Parsers {
    /**
     * Parses monsters from the given file.
     *
     * @param filename path to monstats.txt
     * @return list of Monster objects
     * @throws IOException if file cannot be read
     */
    public static List<Monster> parseMonsters(String filename) throws IOException {
        List<Monster> monsters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\t");
                if (parts.length >= 4) {
                    String name = parts[0];
                    String type = parts[1];
                    int level = Integer.parseInt(parts[2]);
                    String tc = parts[3];
                    monsters.add(new Monster(name, type, level, tc));
                }
            }
        }
        return monsters;
    }

    /**
     * Parses treasure classes from the given file.
     *
     * @param filename path to TreasureClassEx.txt
     * @return map of treasure class name to TreasureClass object
     * @throws IOException if file cannot be read
     */
    public static Map<String, TreasureClass> parseTreasureClasses(String filename)
            throws IOException {
        Map<String, TreasureClass> tcMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\t");
                if (parts.length >= 4) {
                    tcMap.put(
                            parts[0],
                            new TreasureClass(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        }
        return tcMap;
    }

    /**
     * Parses armor items from the given file.
     *
     * @param filename path to armor.txt
     * @return map of armor name to Armor object
     * @throws IOException if file cannot be read
     */
    public static Map<String, Armor> parseArmors(String filename) throws IOException {
        Map<String, Armor> armorMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\t");
                if (parts.length >= 3) {
                    String name = parts[0];
                    int minac = Integer.parseInt(parts[1]);
                    int maxac = Integer.parseInt(parts[2]);
                    armorMap.put(
                            name,
                            new Armor(name, minac, maxac));
                }
            }
        }
        return armorMap;
    }

    /**
     * Parses affixes (prefixes or suffixes) from the given file.
     *
     * @param filename path to MagicPrefix.txt or MagicSuffix.txt
     * @return list of Affix objects
     * @throws IOException if file cannot be read
     */
    public static List<Affix> parseAffixes(String filename) throws IOException {
        List<Affix> affixes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\t");
                if (parts.length >= 4) {
                    String name = parts[0];
                    String stat = parts[1];
                    int min = Integer.parseInt(parts[2]);
                    int max = Integer.parseInt(parts[3]);
                    affixes.add(
                            new Affix(name, stat, min, max));
                }
            }
        }
        return affixes;
    }
}
