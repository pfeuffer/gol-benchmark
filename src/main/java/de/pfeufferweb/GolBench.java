package de.pfeufferweb;


public class GolBench {
    public GolBench(String golClassName) {
        try {
            Class golClassUnderTest = Class.forName(golClassName);
            Object golUnderTest = golClassUnderTest.getConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("could not instantiate game of life", e);
        }
    }

    public static void main(String[] args) {

    }
}
