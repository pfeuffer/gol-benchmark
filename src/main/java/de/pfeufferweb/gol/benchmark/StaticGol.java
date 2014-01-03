package de.pfeufferweb.gol.benchmark;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StaticGol implements Gol {
    private final int[][] cells;

    public StaticGol(int[][] cells) {
        this.cells = cells;
    }

    public boolean isAlive(int x, int y) {
        for (int[] cell : cells) {
            if (x == cell[0] && y == cell[1]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Gol next() {
        throw new NotImplementedException();
    }

}
