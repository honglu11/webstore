/**
 * 
 */
package ca.sait.services;

import java.util.Map;

/**
 * @author Hong Lu
 * 
 */
public class ValidationException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 479334842914321753L;
    private final Map<String, String> validationErrors;

    public ValidationException(final Map<String, String> validationErrors ) {
        super("Validation Errors");
        this.validationErrors = validationErrors;
    }
    
    /**
     * @return the validationErrors
     */
    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

}
