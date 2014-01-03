package de.pfeufferweb.gol.benchmark;

public class ArrayRepresentation {
    private static final String DEAD = "•";
    private static final String ALIVE = "X";

    private final Gol gol;

    public ArrayRepresentation(Gol gol) {
        this.gol = gol;
    }

    public String print(int xFrom, int xTo, int yFrom, int yTo) {
        StringBuilder builder = new StringBuilder();
        for (int y = yFrom; y < yTo; ++y) {
            for (int x = xFrom; x < xTo; ++x) {
                builder.append(gol.isAlive(x, y) ? ALIVE : DEAD);
            }
            builder.append("\n");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

}
