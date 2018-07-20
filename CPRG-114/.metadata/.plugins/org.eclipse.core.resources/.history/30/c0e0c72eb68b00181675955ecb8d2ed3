/**
 * 
 */
package ca.sait.mystore.web.mvc.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.util.HasLogger;

/**
 * 
 */
public abstract class AbstractModel
implements IModel, HasLogger {

    private UUID oid;
    
    private Map<String,String> errors  = new HashMap<>();
    
    private String successMessage;
    private String errorMessage;   

    /*
     * (non-Javadoc)
     * @see ca.sait.mystore.web.mvc.view.IView#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        logger().trace("ENTER handle(request, response)");
        
        try {
            return process(request, response);
        } finally {
            logger().trace("EXIT handle(request, response)");
        }
    }

    /**
     * 
     * @param request
     * @param response
     * @return
     */
    protected abstract String process(HttpServletRequest request, HttpServletResponse response);
    
    public UUID getOid() {
        return oid;
    }
   
    @Override
    public void setOid(UUID oid) {
        this.oid = oid;
    }    
    
    /**
     * @return the errors
     */
    public Map<String, String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    @Override
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    
    @Override
    public String getSuccessMessage() {
        return successMessage;
    }
    
    @Override
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
    
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }    
    
    @Override
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}