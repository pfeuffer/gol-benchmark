package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GolComparatorTest {
    @Test
    public void emptyGolsAreEqual() {
        assertTrue(new GolComparator().equal(new StaticGol(new int[][] {}),
                new StaticGol(new int[][] {}), 0, 0, 0, 0));
    }

    @Test
    public void golsWithOneAliveCellAt00AreEqual() {
        assertTrue(new GolComparator().equal(new StaticGol(
                new int[][] { { 0, 0 } }), new StaticGol(
                new int[][] { { 0, 0 } }), 0, 1, 0, 1));
    }

    @Test
    public void golsWithDifferenceAt00AreNotEqual() {
        assertFalse(new GolComparator().equal(new StaticGol(new int[][] { { 0,
                0 } }), new StaticGol(new int[][] {}), 0, 1, 0, 1));
    }

    @Test
    public void golsWithOtherDifferencesAreNotEqual() {
        assertFalse(new GolComparator().equal(new StaticGol(new int[][] {
                { 0, 0 }, { 1, 1 } }), new StaticGol(new int[][] { { 0, 0 } }),
                0, 2, 0, 2));
    }
}
