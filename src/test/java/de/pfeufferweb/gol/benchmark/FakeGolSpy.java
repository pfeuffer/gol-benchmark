package de.pfeufferweb.gol.benchmark;

public class FakeGolSpy implements Gol {

    static boolean instantiated = false;

    public FakeGolSpy() {
        instantiated = true;
    }
}
