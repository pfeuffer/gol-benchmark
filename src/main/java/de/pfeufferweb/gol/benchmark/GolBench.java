package de.pfeufferweb.gol.benchmark;

public class GolBench {
    private final String golBuilderClassName;

    public GolBench(String golBuilderClassName) {
        this.golBuilderClassName = golBuilderClassName;
    }

    private GolBuilder instantiateBuilder() {
        try {
            @SuppressWarnings("unchecked")
            Class<GolBuilder> golClassUnderTest = (Class<GolBuilder>) Class
                    .forName(golBuilderClassName);
            return golClassUnderTest.getConstructor().newInstance();
        } catch (ClassCastException e) {
            throw new IllegalGolInterfaceException();
        } catch (Exception e) {
            throw new IllegalGolException(e);
        }
    }

    public void run(GolSingleBench golSingleBench) {
        new GolBenchRunner().run(golSingleBench, instantiateBuilder());
    }

    public static void main(String[] args) {
        new GolBench(args[0]).run(new GolChecker());
        new GolBench(args[0]).run(new GolGliderBench());
        new GolBench(args[0]).run(new GolRPentominoBench());
        new GolBench(args[0]).run(new GolInfiniteBench());
    }
}
