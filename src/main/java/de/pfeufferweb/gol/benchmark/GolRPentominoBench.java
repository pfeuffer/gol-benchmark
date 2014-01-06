package de.pfeufferweb.gol.benchmark;

/**
 * Initializes the given GOL with a r-Pentomino and lets it explode.
 */
public class GolRPentominoBench extends MeasuringBench {
    public GolRPentominoBench() {
        super("Pentomino", 10000);
    }

    @Override
    int[][] getStartPattern() {
        return new int[][] { { -1, 0 }, { 0, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 } };
    }
}
