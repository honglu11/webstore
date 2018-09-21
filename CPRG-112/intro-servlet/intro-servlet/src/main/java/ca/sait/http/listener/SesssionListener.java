package ca.sait.http.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class SesssionListener
 *
 */
@WebListener// don't know the helloWorldSevele
public class SesssionListener implements HttpSessionListener { /*, HttpSessionAttributeListener {*/

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.trace("ENTER sessionCreated(se)");

        logger.debug("Source: {}", se.getSource() != null ? se.getSource().getClass().getName() : "N/A");
        logger.debug("SessionId: {}", se.getSession().getId());

        logger.trace("EXIT sessionCreated(se)");
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override // scope is in session
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.trace("ENTER sessionDestroyed(se)");

        logger.debug("Source: {}", se.getSource() != null ? se.getSource().getClass().getName() : "N/A");
        logger.debug("SessionId: {}", se.getSession().getId()); // nobody get it of algrishm. if get it a way to hijack

        logger.trace("EXIT sessionDestroyed(se)");
    }

//    /**
//     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
//     */
//    @Override
//    public void attributeAdded(HttpSessionBindingEvent event) {
//        logger.trace("ENTER attributeAdded(event)");
//
//        logger.debug("Source: {}", event.getSource());
//        logger.debug("Attribute: {}", event.getName());
//        logger.debug("Value: {}", event.getValue());
//        logger.debug("SessionId: {}", event.getSession().getId());
//
//        logger.trace("EXIT attributeAdded(se)");
//    }
//
//    /**
//     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
//     */
//    @Override
//    public void attributeRemoved(HttpSessionBindingEvent event) {
//        logger.trace("ENTER attributeRemoved(event)");
//
//        logger.debug("Source: {}", event.getSource());
//        logger.debug("Attribute: {}", event.getName());
//        logger.debug("Value: {}", event.getValue());
//        logger.debug("SessionId: {}", event.getSession().getId());
//
//        logger.trace("EXIT attributeRemoved(se)");
//    }
//
//    /**
//     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
//     */
//    @Override
//    public void attributeReplaced(HttpSessionBindingEvent event) {
//        logger.trace("ENTER attributeReplaced(event)");
//
//        logger.debug("Source: {}", event.getSource());
//        logger.debug("Attribute: {}", event.getName());
//        logger.debug("Value: {}", event.getValue());
//
//        logger.debug("SessionId: {}", event.getSession().getId());
//
//        logger.trace("EXIT attributeReplaced(se)");
//    }
}