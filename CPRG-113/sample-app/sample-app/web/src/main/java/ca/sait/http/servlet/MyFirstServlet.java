package ca.sait.http.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.business.MyFirst;
import ca.sait.business.MyFirstLocal;
import ca.sait.business.SingletonEJBLocal;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private final Logger logger = LoggerFactory.getLogger(getClass());

	// indicate dependency
	@EJB
	private MyFirstLocal myFirst;
	
        @EJB
        //private MyFirst myFirst;
        private  SingletonEJBLocal singleton;

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        logger.trace("ENTER doGet");

            try {
                final String mesg = myFirst.sayHello().get();
                // localhost:8280/web/myfirst?inc
                final String inc = request.getParameter("inc");
                if (inc != null)
                    singleton.incCounter();
                response.getWriter().append("Message: ").append(mesg)                
                .append("\nSingleton Counter: ").append(Long.toString(singleton.getCount()));
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                logger.error("error " + e.getMessage());
            } finally {
                logger.trace("EXIT doGet");
            }

	

	}
	
//	@Override // this cause memory leak for sure not gurrantee to work.
//	protected void finalize() throws Throwable {
//	    super.finalize();
//	}


}
