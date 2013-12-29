package de.pfeufferweb.gol.benchmark;

public class GolBench {
    private final Gol golUnderTest;

    public GolBench(String golClassName) {
        try {
            @SuppressWarnings("unchecked")
            Class<Gol> golClassUnderTest = (Class<Gol>) Class
                    .forName(golClassName);
            golUnderTest = golClassUnderTest.getConstructor().newInstance();
            run();
        } catch (ClassCastException e) {
            throw new IllegalGolInterfaceException();
        } catch (Exception e) {
            throw new IllegalGolException(e);
        }
    }

    public void run() {
        new GolBenchRunner(new GolGliderBench(golUnderTest)).run();
    }

    public static void main(String[] args) {

    }
}
