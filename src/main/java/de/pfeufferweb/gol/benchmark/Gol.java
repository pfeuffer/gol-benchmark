package de.pfeufferweb.gol.benchmark;

public interface Gol {
    Gol next();

    boolean isAlive(int x, int y);
}
