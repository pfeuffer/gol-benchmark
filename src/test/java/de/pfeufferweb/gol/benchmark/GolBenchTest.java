package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GolBenchTest {
    @Test
    public void instantiatesGivenGolClass() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolBuilderSpy");
        assertTrue("gol instance not instantiated",
                FakeGolBuilderSpy.instantiated);
    }

    @Test(expected = IllegalGolException.class)
    public void illegalGolClassCreatesAppropriateException() {
        new GolBench("no.such.class");
    }

    @Test(expected = IllegalGolInterfaceException.class)
    public void givenGolClassMustBeAValidGol() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolThatIsNoGol");
    }

    @Test
    public void createsABenchRunner() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolBuilderSpy");
        assertTrue("next not called", FakeGolBuilderSpy.createCalled);
    }
}
