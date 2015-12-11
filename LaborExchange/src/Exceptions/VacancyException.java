package Exceptions;

/**
 * Created by Daniel Shchepetov on 12.12.2015.
 */
public class VacancyException extends Exception {
    public VacancyException() {
        super();
    }

    public VacancyException(String message) {
        super(message);
    }

    public VacancyException(String message, Throwable cause) {
        super(message, cause);
    }

    public VacancyException(Throwable cause) {
        super(cause);
    }
}
