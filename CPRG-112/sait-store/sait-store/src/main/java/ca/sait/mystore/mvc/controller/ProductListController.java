package ca.sait.mystore.mvc.controller;

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

import ca.sait.mystore.mvc.model.ProductListModel;

/**
 * Servlet implementation class HomePageController
 */
@WebServlet("/productlist")
public class ProductListController extends HttpServlet {

    private static final long serialVersionUID = -8681911590034019577L;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject private ProductListModel model;
    
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        logger.trace("ENTER service(request,response)");
        
        model.setActive("active");
        model.setPageName("Product List");
        
        model.handle(request, response);
        
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productlist.jsp");
        requestDispatcher.forward(request, response);
        
        logger.trace("EXIT service(request,response)");
    }
}