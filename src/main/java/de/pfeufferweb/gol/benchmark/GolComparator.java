package de.pfeufferweb.gol.benchmark;

public class GolComparator {

    public boolean equal(Gol gol1, Gol gol2) {
        int xMin = Math.min(gol1.minX(), gol2.minX());
        int xMax = Math.max(gol1.maxX(), gol2.maxX());
        int yMin = Math.min(gol1.minY(), gol2.minY());
        int yMax = Math.max(gol1.maxY(), gol2.maxY());
        for (int x = xMin; x <= xMax; ++x) {
            for (int y = yMin; y <= yMax; ++y) {
                if (!gol1.isAlive(x, y) == gol2.isAlive(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
