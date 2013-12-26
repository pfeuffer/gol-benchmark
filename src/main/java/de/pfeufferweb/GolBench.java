package de.pfeufferweb;

public class GolBench {
    public GolBench(String golClassName) {
        try {
            Class golClassUnderTest = Class.forName(golClassName);
            Object golUnderTest = golClassUnderTest.getConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new IllegalGolException(e);
        }
    }

    public static void main(String[] args) {

    }
}
