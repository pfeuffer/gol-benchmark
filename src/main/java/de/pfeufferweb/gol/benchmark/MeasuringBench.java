package de.pfeufferweb.gol.benchmark;

import java.util.ArrayList;
import java.util.List;

abstract class MeasuringBench implements GolSingleBench {
    private static final int OVERALL_COUNT = 1000000;
    private static final int BLOCK_SIZE = 10000;
    private final String name;
    private final List<Long> timeForBlocks = new ArrayList<>();

    MeasuringBench(String name) {
        this.name = name;
    }

    @Override
    public void start(GolBuilder golBuilder) {
        GolBuilderAdapter golBuilderAdapter = new GolBuilderAdapter(golBuilder);
        golBuilderAdapter.add(getStartPattern());

        Gol nextGol = golBuilderAdapter.create();
        long timeForBlock = 0;
        for (int i = 1; i <= OVERALL_COUNT; ++i) {
            long start = System.nanoTime();
            nextGol = nextGol.next();
            long end = System.nanoTime();
            timeForBlock += end - start;
            if (i % BLOCK_SIZE == 0) {
                System.out.println(name + ": " + (i - BLOCK_SIZE) + "-" + i
                        + " in " + timeForBlock + " (avg: "
                        + (timeForBlock / i) + ")");
                timeForBlocks.add(timeForBlock);
            }
        }
    }

    abstract int[][] getStartPattern();
}
