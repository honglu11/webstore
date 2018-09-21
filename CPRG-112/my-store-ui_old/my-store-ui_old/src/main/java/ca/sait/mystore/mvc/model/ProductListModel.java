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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        title = "Fancy Product List";
    }
}
