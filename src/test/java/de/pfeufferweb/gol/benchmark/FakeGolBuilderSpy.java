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
