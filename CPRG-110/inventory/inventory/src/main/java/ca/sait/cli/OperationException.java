/**
 * 
 */
package ca.sait.cli;

/**
 * This is an exception that gets thrown when there
 * is a problem with some type of operation
 * 
 * @author 
 * @version 1.0
 */
public class OperationException extends Exception {

    private static final long serialVersionUID = 3037386021341528343L;

    /**
     * @param message
     */
    public OperationException(String message) {
        super(message);
    }
}
