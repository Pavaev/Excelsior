package ru.excelsior.servlet.exceptions;

/**
 * Created by Daniel Shchepetov on 14.10.2015.
 */
public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String message){
        super(message);
    }
}
