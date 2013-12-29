package de.pfeufferweb.gol.benchmark;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class GolGliderBenchTest {

    private static class OnlyOnceCalledGol implements Gol {
        private boolean nextCalled = false;

        @Override
        public void addCell(int x, int y) {
        }

        @Override
        public Gol next() {
            if (nextCalled) {
                fail(" next called multiple times");
            }
            nextCalled = true;
            return new OnlyOnceCalledGol();
        }
    }

    @Mock
    private Gol golSpy;

    @InjectMocks
    private GolGliderBench underTest;

    @Before
    public void inject() {
        initMocks(this);
        when(golSpy.next()).thenReturn(golSpy);
    }

    @Test
    public void initializesGivenGolWithAGlider() {
        underTest.start();
        verify(golSpy).addCell(1, 0);
        verify(golSpy).addCell(0, 1);
        verify(golSpy).addCell(-1, 1);
        verify(golSpy).addCell(-1, 0);
        verify(golSpy).addCell(-1, -1);
    }

    @Test
    public void callsGivenGolAMillionTimes() {
        underTest.start();
        verify(golSpy, times(1000000)).next();
    }

    @Test
    public void callsNextOnNewGenerations() {
        // overwrite test object with different test object to use another gol
        underTest = new GolGliderBench(new OnlyOnceCalledGol());
        underTest.start();
    }
}
