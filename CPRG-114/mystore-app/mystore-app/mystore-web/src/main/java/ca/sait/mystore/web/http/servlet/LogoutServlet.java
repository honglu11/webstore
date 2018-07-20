package ca.sait.mystore.web.http.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.util.HasLogger;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet implements HasLogger {

    private static final long serialVersionUID = 6366183996356067022L;

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    logger().trace("ENTER doGet(request, response)");
	    logger().trace("Invalidating Session: {}", request.getSession().getId());
		request.getSession().invalidate(); // when log out, remove cookies's seesion id

		response.sendRedirect(request.getContextPath());
	    logger().trace("EXIT doGet(request, response)");
	}
}
