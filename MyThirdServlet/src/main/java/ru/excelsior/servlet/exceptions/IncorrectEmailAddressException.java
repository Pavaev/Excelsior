package ru.excelsior.servlet.exceptions;

/**
 * Created by Daniel Shchepetov on 14.10.2015.
 */
public class IncorrectEmailAddressException extends Exception {
    public IncorrectEmailAddressException(String message){
        super(message);
    }
}
