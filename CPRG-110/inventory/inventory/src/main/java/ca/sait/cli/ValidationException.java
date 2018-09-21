/**
 * 
 */
package ca.sait.cli;

/**
 * This exception happens when there is an issue with data 
 * that as been entered through the console
 * 
 * @author 
 * @version 1.0
 */
public class ValidationException extends Exception {

    private static final long serialVersionUID = -1729151579442776572L;

    /**
     * @param message
     */
    public ValidationException(String message) {
        super(message);
    }

}
