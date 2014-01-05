package de.pfeufferweb.gol.benchmark;

abstract class MeasuringBench implements GolSingleBench {
    private final String name;

    MeasuringBench(String name) {
        this.name = name;
    }

    @Override
    public void start(GolBuilder golBuilder) {
        GolBuilderAdapter golBuilderAdapter = new GolBuilderAdapter(golBuilder);
        golBuilderAdapter.add(getStartPattern());

        Gol nextGol = golBuilderAdapter.create();
        long overallTime = 0;
        for (int i = 1; i <= 1000000; ++i) {
            long start = System.nanoTime();
            nextGol = nextGol.next();
            long end = System.nanoTime();
            overallTime += end - start;
            if (i % 10000 == 0)
                System.out.println(name + ": " + i + " in " + overallTime
                        + " (avg: " + (overallTime / i) + ")");
        }
    }

    abstract int[][] getStartPattern();
}
