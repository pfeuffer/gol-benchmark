package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class GolGliderBenchTest {

    private static class OnlyOnceCalledGol implements Gol {
        private boolean nextCalled = false;

        @Override
        public Gol next() {
            if (nextCalled) {
                fail(" next called multiple times");
            }
            nextCalled = true;
            return new OnlyOnceCalledGol();
        }

        @Override
        public boolean isAlive(int x, int y) {
            return true;
        }
    }

    private static class OnlyOnceCalledGolBuilder implements GolBuilder {
        @Override
        public void addCell(int x, int y) {
        }

        @Override
        public Gol create() {
            return new OnlyOnceCalledGol();
        }
    }

    @Mock
    private GolBuilder golBuilderSpy;
    @Mock
    private Gol golSpy;

    private GolGliderBench underTest = new GolGliderBench();

    @Before
    public void inject() {
        initMocks(this);
        when(golSpy.next()).thenReturn(golSpy);
        when(golSpy.isAlive(anyInt(), anyInt())).thenReturn(true);
        when(golBuilderSpy.create()).thenReturn(golSpy);
    }

    @Test
    public void initializesGivenGolWithAGlider() {
        underTest.start(golBuilderSpy);
        verify(golBuilderSpy).addCell(1, 0);
        verify(golBuilderSpy).addCell(0, 1);
        verify(golBuilderSpy).addCell(-1, 1);
        verify(golBuilderSpy).addCell(-1, 0);
        verify(golBuilderSpy).addCell(-1, -1);
        verify(golBuilderSpy).create();
    }

    @Test
    public void callsGivenGolAMillionTimes() {
        underTest.start(golBuilderSpy);
        verify(golSpy, times(1000000)).next();
    }

    @Test
    public void callsNextOnNewGenerations() {
        underTest.start(new OnlyOnceCalledGolBuilder());
    }
}
