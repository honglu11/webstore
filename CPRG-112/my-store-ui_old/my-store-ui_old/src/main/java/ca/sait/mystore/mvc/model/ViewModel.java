/**
 *
 */
package ca.sait.mystore.mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public abstract class ViewModel {

    private String pageName;
    private String active;

    /**
     * 
     * @param request
     * @param response
     */
    public abstract void handle(HttpServletRequest request, HttpServletResponse response);

    /**
     * @return the pageName
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @param pageName
     *            the pageName to set
     */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * @return the active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active
     *            the active to set
     */
    public void setActive(String active) {
        this.active = active;
    }

}
