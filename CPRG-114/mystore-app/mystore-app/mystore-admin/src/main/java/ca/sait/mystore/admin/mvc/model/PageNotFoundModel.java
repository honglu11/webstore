/**
 * 
 */
package ca.sait.mystore.admin.mvc.model;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Model
public class PageNotFoundModel extends AbstractModel {

    /* (non-Javadoc)
     * @see ca.sait.mystore.web.mvc.model.AbstractView#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected String process(HttpServletRequest request, HttpServletResponse response) {
        logger().trace("ENTER process(request,resposne)");
        
        try {
            return "/WEB-INF/jsp/pageNotFound.jsp";
        } finally {
            logger().trace("EXIT process(request,resposne)");
        }
    }

    @Override
    public String getNavigationName() {
        return "";
    }
}
