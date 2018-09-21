/**
 * 
 */
package ca.sait.produce.exceptions;

/**
 * 
 * @author Chris Elias
 */
public class InvalidCommodityException extends Exception {

    private static final long serialVersionUID = -7785433669941251656L;

    /**
     * @param message
     */
    public InvalidCommodityException(String message) {
        super(message);
    }
}
