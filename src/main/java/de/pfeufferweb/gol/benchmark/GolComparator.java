package de.pfeufferweb.gol.benchmark;

public class GolComparator {

    public boolean equal(Gol gol1, Gol gol2, int xMin, int xMax, int yMin,
            int yMax) {
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
