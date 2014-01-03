package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GolBenchTest {
    private final class MockBench implements GolSingleBench {
        @Override
        public void start(GolBuilder golBuilder) {
        }
    }

    @Test
    public void instantiatesGivenGolClass() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolBuilderSpy")
                .run(new MockBench());
        assertTrue("gol instance not instantiated",
                FakeGolBuilderSpy.instantiated);
    }

    @Test(expected = IllegalGolException.class)
    public void illegalGolBuilderClassCreatesAppropriateException() {
        new GolBench("no.such.class").run(new MockBench());
    }

    @Test(expected = IllegalGolInterfaceException.class)
    public void givenGolClassMustBeAValidGolBuilder() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolThatIsNoGolBuilder")
                .run(new MockBench());
    }

    @Test
    public void createsABenchRunnerWithoutStartingIt() {
        new GolBench("de.pfeufferweb.gol.benchmark.FakeGolBuilderSpy")
                .run(new MockBench());
        assertFalse("next not called", FakeGolBuilderSpy.createCalled);
    }
}
