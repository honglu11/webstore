package ca.sait.http.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.HasLogger;

import ca.sait.mvc.model.ReportModel;


/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet implements HasLogger {
	private static final long serialVersionUID = 1L;
       
	    @Inject
	    private ReportModel model; 
        
        private AtomicInteger counter = new AtomicInteger(1);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    logger().trace("ENTER doGet");
	    final Integer count = counter.incrementAndGet();
	    model.handle(request, response, count);
		
	    logger().trace("Exit doGet");
	}


}
