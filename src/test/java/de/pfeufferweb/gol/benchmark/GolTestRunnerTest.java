package de.pfeufferweb.gol.benchmark;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GolTestRunnerTest {
    @Test
    public void runsGivenBenchWithGivenGol() {
        Gol gol = mock(Gol.class);
        GolSingleBench bench = mock(GolSingleBench.class);
        GolBenchRunner testRunner = new GolBenchRunner(bench, gol);
        testRunner.run();
        verify(bench).start();
    }
}
