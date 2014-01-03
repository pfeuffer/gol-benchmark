package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayRepresentationTest {
    private static class GolMock implements Gol {

        @Override
        public Gol next() {
            return null;
        }

        @Override
        public boolean isAlive(int x, int y) {
            return x == 3;
        }
    };

    @Test
    public void createsEmptyStringForEmptyArray() {
        assertEquals("",
                new ArrayRepresentation(new GolMock()).print(0, 0, 0, 0));
    }

    @Test
    public void createsOForEmptyGolArrayOf1by1() {
        assertEquals("O",
                new ArrayRepresentation(new GolMock()).print(0, 1, 0, 1));
    }

    @Test
    public void createsOsForEmptyGolArrayOf3by1() {
        assertEquals("OOO",
                new ArrayRepresentation(new GolMock()).print(0, 3, 0, 1));
    }

    @Test
    public void createsMultipleLinesOfOsForEmptyGolArrayOf3by3() {
        assertEquals("OOO\nOOO\nOOO",
                new ArrayRepresentation(new GolMock()).print(0, 3, 0, 3));
    }

    @Test
    public void createsXForAliveCellsInGol() {
        assertEquals("OOOX\nOOOX\nOOOX",
                new ArrayRepresentation(new GolMock()).print(0, 4, 0, 3));
    }
}
