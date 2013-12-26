package de.pfeufferweb;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GolBenchTest {
    @Test
    public void instantiatesGivenGolClass() {
        new GolBench("de.pfeufferweb.FakeGolSpy");
        assertTrue("gol instance not instantiated", FakeGolSpy.instantiated);
    }

    @Test(expected = IllegalGolException.class)
    public void illegalGolClassCreatesAppropriateException() {
        new GolBench("no.such.class");
    }
}
