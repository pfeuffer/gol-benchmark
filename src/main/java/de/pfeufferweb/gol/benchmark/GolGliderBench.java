package de.pfeufferweb.gol.benchmark;

/**
 * Initializes the given GOL with a simple glider and lets it fly.
 */
public class GolGliderBench implements GolSingleBench {

    @Override
    public void start(GolBuilder golBuilder) {
        GolBuilderAdapter golBuilderAdapter = new GolBuilderAdapter(golBuilder);
        golBuilderAdapter.add(new int[][] { { 1, 0 }, { 0, 1 }, { -1, 1 },
                { -1, 0 }, { -1, -1 } });

        Gol nextGol = golBuilderAdapter.create();
        long overallTime = 0;
        for (int i = 1; i <= 1000000; ++i) {
            long start = System.nanoTime();
            nextGol = nextGol.next();
            long end = System.nanoTime();
            overallTime += end - start;
            if (i % 10000 == 0)
                System.out.println(i + " in " + overallTime + " (avg: "
                        + (overallTime / i) + ")");
        }
    }
}
