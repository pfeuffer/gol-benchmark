package de.pfeufferweb.gol.benchmark;

public class GolBenchRunner {

    private final GolSingleBench bench;

    public GolBenchRunner(GolSingleBench bench) {
        this.bench = bench;
    }

    public void run() {
        bench.start();
    }
}
