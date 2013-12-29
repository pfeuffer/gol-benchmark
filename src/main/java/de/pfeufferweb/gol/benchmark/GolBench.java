package de.pfeufferweb.gol.benchmark;

public class GolBench {
    public GolBench(String golClassName) {
        try {
            @SuppressWarnings("unchecked")
            Class<Gol> golClassUnderTest = (Class<Gol>) Class
                    .forName(golClassName);
            Gol golUnderTest = golClassUnderTest.getConstructor().newInstance();
            new GolBenchRunner(new GolGliderBench(golUnderTest)).run();
        } catch (ClassCastException e) {
            throw new IllegalGolInterfaceException();
        } catch (Exception e) {
            throw new IllegalGolException(e);
        }
    }

    public static void main(String[] args) {

    }
}
