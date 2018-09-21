/**
 * 
 */
package ca.sait.myStore.rs;

/**
 * 
 * @author Chris Elias
 */
public class ResultNotFoundException extends Exception {

    private static final long serialVersionUID = -3377691852270767404L;
    
    public static final int CODE = 6005;

    public ResultNotFoundException() {
    }
    
    public ResultNotFoundException(String message) {
        super(message);
    }
}
