/**
 * 
 */
package ca.sait.produce.exceptions;

/**
 * 
 * @author Chris Elias
 */
public class InvalidVarietyException extends Exception {

    private static final long serialVersionUID = 7773392173994254187L;

    /**
     * @param message
     */
    public InvalidVarietyException(String message) {
        super(message);
    }
}
