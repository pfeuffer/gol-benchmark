package de.pfeufferweb.gol.benchmark;

public class GolChecker implements GolSingleBench {
    private static final Gol FIRST_ITERATION = new StaticGol(new int[][] {
            { 0, 1 }, { 0, -1 }, { -2, 0 }, { -1, 1 }, { -1, 0 } });
    private static final Gol SECOND_ITERATION = new StaticGol(new int[][] {
            { -1, -1 }, { -2, 0 }, { -2, 1 }, { -1, 1 }, { 0, 1 } });

    @Override
    public void start(GolBuilder golBuilder) {
        GolBuilderAdapter golBuilderAdapter = new GolBuilderAdapter(golBuilder);
        golBuilderAdapter.add(new int[][] { { 1, 0 }, { 0, 1 }, { -1, 1 },
                { -1, 0 }, { -1, -1 } });
        Gol gol = golBuilderAdapter.create();
        Gol firstIteration = gol.next();
        assertFirstIteration(firstIteration);
        Gol secondIteration = firstIteration.next();
        assertSecondIteration(secondIteration);
        System.out.println("passed glider test");
    }

    private void assertFirstIteration(Gol gol) {
        assertEquals("first iteration of glider incorrect", FIRST_ITERATION,
                gol);
    }

    private void assertSecondIteration(Gol gol) {
        assertEquals("first iteration of glider incorrect", SECOND_ITERATION,
                gol);
    }

    private void assertEquals(String errorMessage, Gol expected, Gol gol) {
        if (!new GolComparator().equal(expected, gol, -2, 3, -2, 3)) {
            System.err.println(errorMessage);
            System.err.println("expected:");
            System.err.println(new ArrayRepresentation(expected).print(-2, 3,
                    -2, 3));
            System.err.println("got:");
            System.err
                    .println(new ArrayRepresentation(gol).print(-2, 3, -2, 3));
            throw new RuntimeException(errorMessage);
        }
    }

}
