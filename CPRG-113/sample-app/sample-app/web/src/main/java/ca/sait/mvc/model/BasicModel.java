package ca.sait.mvc.model;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.business.StatefulEJBLocal;
import ca.sait.mvc.session.SessionModel;

//@RequestScoped
@Named
public class BasicModel implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @Inject
//    private SessionModel sessionModel;
    
    @EJB
    private StatefulEJBLocal stateful; 
    
    private AsyncContext async;
    
    public void handle(AsyncContext async) {
        logger.trace("ENTER handle(HttpServletRequest request, HttpServletResponse response)");
        this.async = async;
        logger.trace("EXIT handle(HttpServletRequest request, HttpServletResponse response)");
    }
    
    public void run() {
        logger.trace("ENTer run();");
      //  logger.trace("ENTER handle(HttpServletRequest request, HttpServletResponse response)");
        final ServletResponse response = async.getResponse();
        final HttpServletRequest request = (HttpServletRequest)async.getRequest();    

        
        try {
            // manually create session, only statful can save thing in session
            final HttpSession session = request.getSession(true); // if getSession(), return Session if created, return null if not created. getSession(true), always create session.
            StatefulEJBLocal stateful = (StatefulEJBLocal) session.getAttribute("state");
            if (stateful == null) {
            final InitialContext initial = new InitialContext(); //java name service allow to look up java class name. or java resoure, cannot use @Inject, so need to everything manually
            stateful = (StatefulEJBLocal) initial.lookup("java:global/ear/ejb-1.0.0/StatefulEJB!ca.sait.business.StatefulEJBLocal"); // create a new instance of EJB
        
            session.setAttribute("state", stateful);
            }
            
            response.getWriter().append("Message: ").append(stateful.getMessage());
        } catch (final IOException | NamingException ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
          async.complete();
          logger.trace("EXIT run();");
        }           
//      response.getWriter().append("Message: ").append(sessionModel.getMessage());
//        logger.trace("EXIT handle(HttpServletRequest request, HttpServletResponse response)");
    }
    
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        logger.trace("ENTER handle(HttpServletRequest request, HttpServletResponse response)");
//        response.getWriter().append("Message: ").append(sessionModel.getMessage());
//        logger.trace("EXIT handle(HttpServletRequest request, HttpServletResponse response)");
//    }
//    
    
    @PostConstruct
    private void postConstruct() {
        logger.trace("ENTER postConstruct");
        logger.trace("EXIT postConstruct");
        
    }
    
    @PreDestroy
    private void preDestroy() {
        logger.trace("ENTER preDestroy");
        logger.trace("EXIT preDestroy");

    }

}
