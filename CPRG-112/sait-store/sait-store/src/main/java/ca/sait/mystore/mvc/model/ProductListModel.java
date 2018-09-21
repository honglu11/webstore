/**
 * 
 */
package ca.sait.mystore.mvc.model;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Model
public class ProductListModel extends ViewModel {

    private String title;
    private Boolean hasResults;
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        title = "Fancy Product List";
        
        if (request.getParameter("r") != null)
            hasResults = true;
        else
            hasResults = false;
    }

    public Boolean getHasResults() {
        return hasResults;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}