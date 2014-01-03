package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GolComparatorTest {
    @Test
    public void emptyGolsAreEqual() {
        assertTrue(new GolComparator().equal(new StaticGol(new int[][] {}),
                new StaticGol(new int[][] {})));
    }
}
