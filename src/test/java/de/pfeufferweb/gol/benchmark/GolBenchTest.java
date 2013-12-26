package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.pfeufferweb.gol.benchmark.GolBench;
import de.pfeufferweb.gol.benchmark.IllegalGolException;

public class GolBenchTest {
    @Test
    public void instantiatesGivenGolClass() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolSpy");
        assertTrue("gol instance not instantiated", FakeGolSpy.instantiated);
    }

    @Test(expected = IllegalGolException.class)
    public void illegalGolClassCreatesAppropriateException() {
        new GolBench("no.such.class");
    }
}
