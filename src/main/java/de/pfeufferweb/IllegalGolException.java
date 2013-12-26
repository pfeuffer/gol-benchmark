package de.pfeufferweb;

public class IllegalGolException extends RuntimeException {
    public IllegalGolException(Throwable cause) {
        super("could not instantiate game of life", cause);
    }
}
