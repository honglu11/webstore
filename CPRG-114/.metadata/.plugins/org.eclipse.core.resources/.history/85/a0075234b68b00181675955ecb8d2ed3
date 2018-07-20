/**
 * 
 */
package ca.sait.mystore.web.mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.util.HasLogger;

/**
 * 
 */
public abstract class AbstractModel
implements IModel, HasLogger {

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
    
}