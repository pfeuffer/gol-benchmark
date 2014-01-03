package de.pfeufferweb.gol.benchmark;

public class FakeGolBuilderSpy implements GolBuilder {

    private static class FakeGol implements Gol {
        @Override
        public Gol next() {
            return this;
        }

        @Override
        public boolean isAlive(int x, int y) {
            return true;
        }

        @Override
        public int minX() {
            return 0;
        }

        @Override
        public int maxX() {
            return 0;
        }

        @Override
        public int minY() {
            return 0;
        }

        @Override
        public int maxY() {
            return 0;
        }
    }

    static boolean instantiated = false;
    static boolean createCalled = false;

    public FakeGolBuilderSpy() {
        instantiated = true;
    }

    @Override
    public void addCell(int x, int y) {
    }

    @Override
    public Gol create() {
        createCalled = true;
        return new FakeGol();
    }
}
