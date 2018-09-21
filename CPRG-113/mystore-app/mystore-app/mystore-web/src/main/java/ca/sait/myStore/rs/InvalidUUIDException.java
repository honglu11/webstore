/**
 * 
 */
package ca.sait.myStore.rs;

/**
 * 
 * @author Chris Elias
 */
public class InvalidUUIDException extends Exception {

    private static final long serialVersionUID = -3377691852270767404L;
    
    public static final int CODE = 6006;

    public InvalidUUIDException() {
    }
    
    public InvalidUUIDException(String message) {
        super(message);
    }
}
