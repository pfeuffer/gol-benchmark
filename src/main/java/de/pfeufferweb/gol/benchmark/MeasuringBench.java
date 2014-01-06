package de.pfeufferweb.gol.benchmark;

import java.util.ArrayList;
import java.util.List;

abstract class MeasuringBench implements GolSingleBench {
    private final String name;
    private final List<Long> timeForBlocks = new ArrayList<>();
    private final int iterationCount;

    MeasuringBench(String name, int iterationCount) {
        this.name = name;
        this.iterationCount = iterationCount;
    }

    @Override
    public void start(GolBuilder golBuilder) {
        GolBuilderAdapter golBuilderAdapter = new GolBuilderAdapter(golBuilder);
        golBuilderAdapter.add(getStartPattern());

        Gol nextGol = golBuilderAdapter.create();
        long timeForBlock = 0;
        int blockSize = iterationCount / 10;
        for (int i = 1; i <= iterationCount; ++i) {
            long start = System.nanoTime();
            nextGol = nextGol.next();
            long end = System.nanoTime();
            timeForBlock += end - start;
            if (i % blockSize == 0 || i == iterationCount) {
                System.out.println(name + ": " + (i - blockSize) + "-" + i
                        + " in " + timeForBlock + " (avg: "
                        + (timeForBlock / i) + ")");
                timeForBlocks.add(timeForBlock);
            }
        }
    }

    abstract int[][] getStartPattern();
}
