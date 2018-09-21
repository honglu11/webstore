package ca.sait.mvc.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSException;
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

import ca.sait.HasLogger;
import ca.sait.business.StatefulEJBLocal;
import ca.sait.ejb.RequestReponseEJB;
import ca.sait.mvc.session.SessionModel;

@RequestScoped
@Named
public class RequestResponseModel implements HasLogger {
    
    @EJB
    private RequestReponseEJB rrEJB; 

    
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger().trace("ENTER handle(HttpServletRequest request, HttpServletResponse response)");
        
        //rrEJB.sendMessage(msg);
        final String msg = request.getParameter("message");
        final PrintWriter writer = response.getWriter();
        
        try {
            final String respMsgMsg = rrEJB.sendMessage(msg);
            writer.append("Response Message: ").append(respMsgMsg);
        } catch (JMSException ex) {
            logger().error(ex.getMessage(), ex);
            writer.append("Unable to Send Message");
        } finally {
        
        logger().trace("EXIT handle(HttpServletRequest request, HttpServletResponse response)");
        }
    }
    
  

}
