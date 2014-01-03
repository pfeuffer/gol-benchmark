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
    public int minX() {
        if (cells.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int[] cell : cells) {
            if (cell[0] < min) {
                min = cell[0];
            }
        }
        return min;
    }

    @Override
    public int maxX() {
        if (cells.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int[] cell : cells) {
            if (cell[0] > max) {
                max = cell[0];
            }
        }
        return max;
    }

    @Override
    public int minY() {
        if (cells.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int[] cell : cells) {
            if (cell[1] < min) {
                min = cell[1];
            }
        }
        return min;
    }

    @Override
    public int maxY() {
        if (cells.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int[] cell : cells) {
            if (cell[1] > max) {
                max = cell[1];
            }
        }
        return max;
    }

    @Override
    public Gol next() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return new ArrayRepresentation(this).print(minX(), maxX() + 1, minY(),
                maxY() + 1);
    }

}
