package de.pfeufferweb.gol.benchmark;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GolBenchRunnerTest {
    @Test
    public void runsGivenBenchWithGivenGol() {
        GolSingleBench bench = mock(GolSingleBench.class);
        GolBenchRunner benchRunner = new GolBenchRunner();
        benchRunner.run(bench, null);
        verify(bench).start(null);
    }
}
