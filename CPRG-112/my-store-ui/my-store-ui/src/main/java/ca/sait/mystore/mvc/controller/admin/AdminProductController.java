package ca.sait.mystore.mvc.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.mystore.mvc.model.admin.AdminProductModel;

/**
 * Servlet implementation class HomePageController
 */
@WebServlet("/adminproduct")
public class AdminProductController extends HttpServlet {

    private static final long serialVersionUID = 5002243764322610814L;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject private AdminProductModel model;
    
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        logger.trace("ENTER service(request,response)");
        
        model.setActive("active");
        model.setPageName("Create/Edit/Delete Products");
        
        try {
            model.handle(request, response);
        } catch (final Exception ex) {
           throw new ServletException(ex); // will caught by filter, can be throw as run time exeption as well, but won't be able to check.
        }
        
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/product.jsp");
        requestDispatcher.forward(request, response);
        
        logger.trace("EXIT service(request,response)");
    }
}