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

        @Override
        public int minX() {
            return 0;
        }

        @Override
        public int maxX() {
            return 0;
        }

        @Override
        public int minY() {
            return 0;
        }

        @Override
        public int maxY() {
            return 0;
        }
    };

    @Test
    public void createsEmptyStringForEmptyArray() {
        assertEquals("",
                new ArrayRepresentation(new GolMock()).print(0, 0, 0, 0));
    }

    @Test
    public void createsDotForEmptyGolArrayOf1by1() {
        assertEquals("•",
                new ArrayRepresentation(new GolMock()).print(0, 1, 0, 1));
    }

    @Test
    public void createsThreeDotsForEmptyGolArrayOf3by1() {
        assertEquals("•••",
                new ArrayRepresentation(new GolMock()).print(0, 3, 0, 1));
    }

    @Test
    public void createsMultipleLinesOfDotsForEmptyGolArrayOf3by3() {
        assertEquals("•••\n•••\n•••",
                new ArrayRepresentation(new GolMock()).print(0, 3, 0, 3));
    }

    @Test
    public void createsXForAliveCellsInGol() {
        assertEquals("•••X\n•••X\n•••X",
                new ArrayRepresentation(new GolMock()).print(0, 4, 0, 3));
    }
}
