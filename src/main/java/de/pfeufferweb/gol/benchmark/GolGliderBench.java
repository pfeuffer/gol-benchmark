package de.pfeufferweb.gol.benchmark;

/**
 * Initializes the given GOL with a simple glider and lets it fly.
 */
public class GolGliderBench extends MeasuringBench {
    public GolGliderBench() {
        super("Glider");
    }

    @Override
    int[][] getStartPattern() {
        return new int[][] { { 1, 0 }, { 0, 1 }, { -1, 1 }, { -1, 0 },
                { -1, -1 } };
    }
}
