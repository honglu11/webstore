/**
 * 
 */
package ca.sait.jms;

import javax.jms.CompletionListener;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author celias
 *
 */
public class AsyncListener 
implements CompletionListener, HasLogger {

    /* (non-Javadoc)
     * @see javax.jms.CompletionListener#onCompletion(javax.jms.Message)
     */
    @Override
    public void onCompletion(Message message) {
        logger().trace("ENTER onCompletion(message)");
        
        try {
            logger().info("Completed Message: {}", message.getBody(String.class));
        } catch (final JMSException ex) {
            logger().error(ex.getMessage(), ex);
        }
        
        logger().trace("EXIT onCompletion(message)");
    }

    /* (non-Javadoc)
     * @see javax.jms.CompletionListener#onException(javax.jms.Message, java.lang.Exception)
     */
    @Override
    public void onException(Message message, Exception exception) {
        logger().trace("ENTER onException(message,exception)");
        
        logger().error(exception.getMessage(), exception);
        
        logger().trace("EXIT onException(message,exception)");

    }
}