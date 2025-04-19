// Unit tests for loot generator classes
package edu.grinnell.csc207.lootgenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    /**
     * Testing the Monster constructor and getter methods.
     */
    @Test
    void testMonsterConstructorAndGetters() {
        Monster m = new Monster("Goblin", "Beast", 5, "TC1");
        assertEquals("Goblin", m.getName());
        assertEquals("Beast", m.getType());
        assertEquals(5, m.getLevel());
        assertEquals("TC1", m.getTreasureClass());
    }

    /**
     * Testing the TreasureClass constructor and getter methods.
     */
    @Test
    void testTreasureClassConstructorAndGetters() {
        TreasureClass tc = new TreasureClass("TC1", "Gold", "Sword", "Armor");
        assertEquals("TC1", tc.getName());
        assertEquals("Gold", tc.getItem1());
        assertEquals("Sword", tc.getItem2());
        assertEquals("Armor", tc.getItem3());
        assertArrayEquals(new String[] { "Gold", "Sword", "Armor" }, tc.getItems());
    }

    /**
     * Testing the Affix constructor and getter methods.
     */
    @Test
    void testAffixConstructorAndGetters() {
        Affix affix = new Affix("Strong", "+Strength", 1, 10);
        assertEquals("Strong", affix.getName());
        assertEquals("+Strength", affix.getStat());
        assertEquals(1, affix.getMin());
        assertEquals(10, affix.getMax());
    }

    /**
     * Testing the Armor constructor and getter methods.
     */
    @Test
    void testArmorConstructorAndGetters() {
        Armor armor = new Armor("Chainmail", 5, 15);
        assertEquals("Chainmail", armor.getName());
        assertEquals(5, armor.getMinAc());
        assertEquals(15, armor.getMaxAc());
    }
}
