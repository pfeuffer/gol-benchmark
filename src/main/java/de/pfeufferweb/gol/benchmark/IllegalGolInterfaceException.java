package de.pfeufferweb.gol.benchmark;

public class IllegalGolInterfaceException extends RuntimeException {
    IllegalGolInterfaceException() {
        super("given class must implement interface "
                + Gol.class.getCanonicalName());
    }
}
