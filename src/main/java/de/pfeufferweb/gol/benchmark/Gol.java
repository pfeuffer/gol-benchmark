package de.pfeufferweb.gol.benchmark;

public interface Gol {
    Gol next();

    boolean isAlive(int x, int y);

    int minX();

    int maxX();

    int minY();

    int maxY();
}
