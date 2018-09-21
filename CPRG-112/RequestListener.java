package ca.sait.http.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.trace("ENTER requestDestroyed(sre)");
        logger.trace("EXIT requestDestroyed(sre)");
    }

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.trace("ENTER requestInitialized(sre)");
        logger.trace("EXIT requestInitialized(sre)");
    }

    /**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        logger.trace("ENTER attributeAdded(event)");

        logger.debug("Source: {}", srae.getSource());
        logger.debug("Attribute: {}", srae.getName());
        logger.debug("Value: {}", srae.getValue());

        logger.trace("EXIT attributeAdded(se)");
    }

    /**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        logger.trace("ENTER attributeRemoved(event)");

        logger.debug("Source: {}", srae.getSource());
        logger.debug("Attribute: {}", srae.getName());
        logger.debug("Value: {}", srae.getValue());

        logger.trace("EXIT attributeRemoved(se)");
    }

    /**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        logger.trace("ENTER attributeReplaced(event)");

        logger.debug("Source: {}", srae.getSource());
        logger.debug("Attribute: {}", srae.getName());
        logger.debug("Value: {}", srae.getValue());

        logger.trace("EXIT attributeReplaced(se)");
    }
}