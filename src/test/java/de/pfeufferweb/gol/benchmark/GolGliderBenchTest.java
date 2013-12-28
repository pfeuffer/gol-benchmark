package de.pfeufferweb.gol.benchmark;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class GolGliderBenchTest {

    @Mock
    private Gol golSpy;

    @InjectMocks
    private GolGliderBench underTest;

    @Before
    public void inject() {
        initMocks(this);
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
}
