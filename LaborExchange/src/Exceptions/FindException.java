package Exceptions;

/**
 * Created by Daniel Shchepetov on 11.12.2015.
 */
public class FindException extends Exception {


    public FindException() {
        super();
    }

    public FindException(String message) {
        super(message);
    }

    public FindException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindException(Throwable cause) {
        super(cause);
    }
}


