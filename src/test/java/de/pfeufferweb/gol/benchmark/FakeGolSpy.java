package de.pfeufferweb.gol.benchmark;

public class FakeGolSpy implements Gol {

    static boolean instantiated = false;
    static boolean nextCalled = false;

    public FakeGolSpy() {
        instantiated = true;
    }

    @Override
    public void addCell(int x, int y) {
    }

    @Override
    public void next() {
        nextCalled = true;
    }
}
