package ca.sait.http.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.business.MyFirst;
import ca.sait.business.MyFirstLocal;
import ca.sait.business.SingletonEJBLocal;
import ca.sait.business.StatefulEJBLocal;
import ca.sait.mvc.model.BasicModel;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet(urlPatterns= {"/stateful"}, asyncSupported=true)
public class StatefulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private final Logger logger = LoggerFactory.getLogger(getClass());
//        private InitialContext initial;
//        
//        @Override
//        public void init() throws ServletException {
//            try {
//                initial = new InitialContext();
//                
//            } catch (NamingException e) {
//                throw new ServletException(e);
//            }
//        }
//        
//        @Inject
//        private BasicModel model;

	// indicate dependency
	@EJB
	private StatefulEJBLocal stateful;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        logger.trace("ENTER doGet");

	        BasicModel model = new BasicModel();
	        final AsyncContext async = request.startAsync();
	        model.handle(async);
	        async.start(model);
	        
	       // if don't put here use BasicModel 
//	        try {
//	            // manually create session, only statful can save thing in session
//	            final HttpSession session = request.getSession(true); // if getSession(), return Session if created, return null if not created. getSession(true), always create session.
//	            StatefulEJBLocal stateful = (StatefulEJBLocal) session.getAttribute("state");
//	            if (stateful == null) {
//	            final InitialContext initial = new InitialContext(); //java name service allow to look up java class name. or java resoure, cannot use @Inject, so need to everything manually
//	            stateful = (StatefulEJBLocal) initial.lookup("java:global/ear/ejb-1.0.0/StatefulEJB!ca.sait.business.StatefulEJBLocal"); // create a new instance of EJB
//	        
//	            session.setAttribute("state", stateful);
//	            }
//	            
//	            response.getWriter().append("Message: ").append(stateful.getMessage());
//	        } catch (final IOException | NamingException ex) {
//	            logger.error(ex.getMessage(), ex);
//	        }
//	        
//	        async.start(new Runnable() {
//	        
//	        @Override
//	        public void run() {
//	            try {
//	                //BasicModel model = new BasicModel();
//	                model.handle(request, response);
//	            } catch (final IOException ex) {
//	                logger.error(ex.getMessage(), ex);
//	            } finally {
//	                async.complete();
//	            }		
//	        }
//	        });
		
	        logger.trace("EXIT doGet");

	}


}
