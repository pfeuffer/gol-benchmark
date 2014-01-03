package de.pfeufferweb.gol.benchmark;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GolBuilderAdapterTest {
    private GolBuilder builderMock = mock(GolBuilder.class);

    @Test
    public void createsGolWhenDone() {
        GolBuilderAdapter underTest = new GolBuilderAdapter(builderMock);
        underTest.create();
        verify(builderMock).create();
    }

    @Test
    public void addsCells() {
        GolBuilderAdapter underTest = new GolBuilderAdapter(builderMock);
        int[][] cells = { { 0, 0 }, { 1, 1 } };
        underTest.add(cells);
        verify(builderMock).addCell(0, 0);
        verify(builderMock).addCell(1, 1);
    }
}
