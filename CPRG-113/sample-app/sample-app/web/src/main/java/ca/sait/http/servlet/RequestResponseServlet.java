package ca.sait.http.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.HasLogger;
import ca.sait.mvc.model.RequestResponseModel;

/**
 * Servlet implementation class RequestResponseServlet
 */
@WebServlet("/request")
public class RequestResponseServlet extends HttpServlet implements HasLogger {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private RequestResponseModel model;    

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger().trace("ENTER doGet(HttpServletRequest request, HttpServletResponse response)");
        //RequestResponseModel model = new RequestResponseModel();
        model.handle(request, response);
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        logger().trace("EXIT doGet(HttpServletRequest request, HttpServletResponse response)");
    }

}
