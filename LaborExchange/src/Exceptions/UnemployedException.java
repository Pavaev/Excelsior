package Exceptions;

/**
 * Created by Daniel Shchepetov on 09.12.2015.
 */
public class UnemployedException extends Exception {
    public UnemployedException() {
        super();
    }

    public UnemployedException(String message) {
        super(message);
    }

    public UnemployedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnemployedException(Throwable cause) {
        super(cause);
    }
}
