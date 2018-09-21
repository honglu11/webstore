/**
 * 
 */
package ca.sait.jms.consumer.queue;

import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;

import ca.sait.jms.HasLogger;
import ca.sait.jms.MQConnectionFactory;

/**
 * @author Chris Elias
 *
 */
public class QueueConsumerBlocker 
implements HasLogger {

    
    /**
     * @param args
     */
    public static void main(String[] args) {
        new QueueConsumerBlocker().run();
    }
    
    private void run() {
        logger().trace("ENTER run()");
        
        try (final JMSContext jmsContext = MQConnectionFactory.newContext();) {
            final Destination destQueue = jmsContext.createQueue("sait.THREE");
            // connection reuse
            try (final JMSConsumer consumer = jmsContext.createConsumer(destQueue)) {
    
                while (true) {
                    final Message message = consumer.receive();
                    logger().info("Blocker-{}", message.getBody(String.class));
                }
            }
        } catch (final Exception ex) {
            logger().error(ex.getMessage(), ex);
        } finally {
            logger().trace("EXIT run()");
        }
    }

}






