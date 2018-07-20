/**
 * 
 */
package ca.sait.mystore.web.mvc.model;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public interface IModel {

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public String handle(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException;
    
    /**
     * 
     * @return
     */
    public String getNavigationName();
    
    public void setOid(UUID uuid);
    
    public void setErrors(Map<String, String> errors);
    
    public String getSuccessMessage();

    public void setSuccessMessage(String successMessage);

    public String getErrorMessage();

    public void setErrorMessage(String errorMessage);

}
