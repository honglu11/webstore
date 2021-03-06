package ca.sait.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Message-Driven Bean implementation class for: HelloQueueMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/HelloQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/HelloQueue")
public class HelloQueueMDB implements MessageListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

     /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        logger.trace("ENTER onMessage(Message message)");
        try {
            if (message instanceof TextMessage) {
                final TextMessage text = (TextMessage)message;
                    logger.info("Message: {}", text.getBody(String.class));
            } else {
                logger.warn("Wrong message: {}", message.getClass().getName());
            }
            } catch(final JMSException ex) {
                logger.error(ex.getMessage(), ex);
            } finally {
                logger.trace("EXIT onMessage(Message message)");
                // java:/jms/queue/HelloTopic
            }
    }

}
