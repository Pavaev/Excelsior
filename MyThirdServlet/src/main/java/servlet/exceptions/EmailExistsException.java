package servlet.exceptions;

/**
 * Created by Daniel Shchepetov on 14.10.2015.
 */
public class EmailExistsException extends Throwable {
    public EmailExistsException(String message){
super(message);
    }
}
