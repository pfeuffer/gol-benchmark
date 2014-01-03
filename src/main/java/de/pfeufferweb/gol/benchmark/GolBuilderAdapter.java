package de.pfeufferweb.gol.benchmark;

public class GolBuilderAdapter {
    private final GolBuilder golBuilder;

    public GolBuilderAdapter(GolBuilder golBuilder) {
        this.golBuilder = golBuilder;
    }

    public Gol create() {
        return golBuilder.create();
    }

    public void add(int[][] cells) {
        for (int[] cell : cells) {
            golBuilder.addCell(cell[0], cell[1]);
        }
    }
}
