package Exceptions;

/**
 * Created by Daniel Shchepetov on 12.12.2015.
 */
public class CompanyException extends Exception {
    public CompanyException() {
        super();
    }

    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyException(Throwable cause) {
        super(cause);
    }
}
