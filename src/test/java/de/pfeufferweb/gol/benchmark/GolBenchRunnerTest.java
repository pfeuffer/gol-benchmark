package de.pfeufferweb.gol.benchmark;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GolBenchRunnerTest {
    @Test
    public void runsGivenBenchWithGivenGol() {
        Gol gol = mock(Gol.class);
        GolSingleBench bench = mock(GolSingleBench.class);
        GolBenchRunner benchRunner = new GolBenchRunner(bench);
        benchRunner.run();
        verify(bench).start();
    }
}
