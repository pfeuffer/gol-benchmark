package de.pfeufferweb.gol.benchmark;

/**
 * Initializes an infinite Gol.
 */
public class GolInfiniteBench extends MeasuringBench {
    public GolInfiniteBench() {
        super("Infinite");
    }

    @Override
    int[][] getStartPattern() {
        return new int[][] { { -3, -3 }, { -1, -3 }, { -1, -2 }, { 1, -1 },
                { 1, 0 }, { 1, 1 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 4, 1 } };
    }
}
