package edu.grinnell.csc207.lootgenerator;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class for Diablo II-style loot generator.
 */
public class LootGenerator {
    /**
     * Entry point for the loot generator program.
     *
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("This program kills monsters and generates loot!");
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        final String dataSet = "data/small";

        // Parse all data files at the start
        List<Monster> monsters;
        Map<String, TreasureClass> tcMap;
        Map<String, Armor> armorMap;
        List<Affix> prefixes;
        List<Affix> suffixes;
        try {
            monsters = Parsers.parseMonsters(dataSet + "/monstats.txt");
            tcMap = Parsers.parseTreasureClasses(dataSet + "/TreasureClassEx.txt");
            armorMap = Parsers.parseArmors(dataSet + "/armor.txt");
            prefixes = Parsers.parseAffixes(dataSet + "/MagicPrefix.txt");
            suffixes = Parsers.parseAffixes(dataSet + "/MagicSuffix.txt");
        } catch (Exception e) {
            System.err.println("Error parsing data: " + e.getMessage());
            scanner.close();
            return;
        }
        if (monsters.isEmpty()) {
            System.out.println("No monsters found in monstats.txt");
            scanner.close();
            return;
        }
        outer: while (true) {
            Monster monster = LootGeneratorUtil.pickMonster(monsters, rand);
            System.out.println();
            System.out.println("Fighting " + monster.getName() + "...");
            System.out.println("You have slain " + monster.getName() + "!");
            System.out.println(monster.getName() + " dropped:\n");
            String baseItem = LootGeneratorUtil.generateBaseItem(
                    monster.getTreasureClass(), tcMap, rand);
            // Affixes
            Affix prefix = LootGeneratorUtil.maybePickAffix(prefixes, rand);
            Affix suffix = LootGeneratorUtil.maybePickAffix(suffixes, rand);
            // Print full item name
            StringBuilder itemName = new StringBuilder();
            if (prefix != null) {
                itemName.append(prefix.getName()).append(" ");
            }
            itemName.append(baseItem);
            if (suffix != null) {
                itemName.append(" ").append(suffix.getName());
            }
            System.out.println(itemName);
            // Print base stat
            int defense = LootGeneratorUtil.generateBaseStats(baseItem, armorMap, rand);
            if (defense != -1) {
                System.out.println("Defense: " + defense);
            }
            // Print affix stats
            if (prefix != null) {
                int val = prefix.getMin() + rand.nextInt(prefix.getMax() - prefix.getMin() + 1);
                System.out.println(val + " " + prefix.getStat());
            }
            if (suffix != null) {
                int val = suffix.getMin() + rand.nextInt(suffix.getMax() - suffix.getMin() + 1);
                System.out.println(val + " " + suffix.getStat());
            }
            // Prompt for another round
            String input;
            while (true) {
                System.out.print("\nFight again [y/n]? ");
                input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                    break;
                }
            }
            System.out.println(input);
            if (input.equalsIgnoreCase("n")) {
                break outer;
            }
        }
        scanner.close();
    }
}
