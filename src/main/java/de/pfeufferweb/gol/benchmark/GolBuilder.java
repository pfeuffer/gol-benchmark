package de.pfeufferweb.gol.benchmark;

public interface GolBuilder {
    void addCell(int x, int y);

    Gol create();
}
