package de.pfeufferweb;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GolBenchTest {
    @Test
    public void instantiatesGivenGolClass() {
        new GolBench("de.pfeufferweb.FakeGolSpy");
        assertTrue("gol instance not instantiated", FakeGolSpy.instantiated);
    }
}
