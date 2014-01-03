package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StaticGolTest {
    @Test
    public void golWithoutCellsHasDeadCellAt00() {
        assertFalse(new StaticGol(new int[][] {}).isAlive(0, 0));
    }

    @Test
    public void golWithAliveCellHasAliveCell() {
        assertTrue(new StaticGol(new int[][] { { 0, 0 } }).isAlive(0, 0));
    }

    @Test
    public void staticGolHasCorrectLayout() {
        assertTrue(new StaticGol(new int[][] { { -2, 5 } }).isAlive(-2, 5));
    }

    @Test
    public void staticGolHasCorrectSize() {
        StaticGol underTest = new StaticGol(new int[][] { { -2, 5 }, { 7, 4 } });
        assertEquals(-2, underTest.minX());
        assertEquals(7, underTest.maxX());
        assertEquals(4, underTest.minY());
        assertEquals(5, underTest.maxY());
    }

    @Test
    public void EmptyGolHasMaxAndMinDimensionsOfZero() {
        assertEquals(0, new StaticGol(new int[][] {}).minX());
        assertEquals(0, new StaticGol(new int[][] {}).maxX());
        assertEquals(0, new StaticGol(new int[][] {}).minY());
        assertEquals(0, new StaticGol(new int[][] {}).maxY());
    }

    @Test(expected = NotImplementedException.class)
    public void nextNotImplemented() {
        new StaticGol(new int[][] {}).next();
    }
}
