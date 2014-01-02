package de.pfeufferweb.gol.benchmark;

/**
 * Initializes the given GOL with a simple glider and lets it fly.
 */
public class GolGliderBench implements GolSingleBench {
    private final GolBuilder golBuilder;

    public GolGliderBench(GolBuilder golBuilder) {
        this.golBuilder = golBuilder;
    }

    public void start() {
        golBuilder.addCell(1, 0);
        golBuilder.addCell(0, 1);
        golBuilder.addCell(-1, 1);
        golBuilder.addCell(-1, 0);
        golBuilder.addCell(-1, -1);

        Gol nextGol = golBuilder.create();
        for (int i = 0; i < 1000000; ++i) {
            nextGol = nextGol.next();
        }
    }
}
