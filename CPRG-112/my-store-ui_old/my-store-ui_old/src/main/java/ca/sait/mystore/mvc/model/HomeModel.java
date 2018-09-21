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
public class HomeModel extends ViewModel {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {
    }
}
