package ca.sait.mystore.http.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ca.sait.util.HasLogger;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener, HasLogger {


	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         logger().trace("ENTER sessionCreated(HttpSessionEvent se)");
         logger().debug("Create Session ID: {}", se.getSession().getId());
         logger().debug("EXIT sessionCreated(HttpSessionEvent se)");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        logger().trace("ENTER sessionDestroyed(HttpSessionEvent se)");
        logger().debug("delete Session ID: {}", se.getSession().getId());
        logger().debug("EXIT sessionDestroyed(HttpSessionEvent se)");
    }
	
}
