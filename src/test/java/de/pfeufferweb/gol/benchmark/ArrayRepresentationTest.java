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
            return false;
        }
    };

    @Test
    public void createsEmptyStringForEmptyArray() {
        assertEquals("", new ArrayRepresentation().print(new GolMock()));
    }
}
