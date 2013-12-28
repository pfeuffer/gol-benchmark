package de.pfeufferweb.gol.benchmark;

/**
 * Initializes the given GOL with a simple glider and lets it fly.
 */
public class GolGliderBench {
    private final Gol gol;

    public GolGliderBench(Gol gol) {
        this.gol = gol;
    }

    public void start() {
        gol.addCell(1, 0);
        gol.addCell(0, 1);
        gol.addCell(-1, 1);
        gol.addCell(-1, 0);
        gol.addCell(-1, -1);
    }
}
