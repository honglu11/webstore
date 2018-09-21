/**
 * 
 */
package ca.sait.jms.producer;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;

import ca.sait.jms.AsyncListener;
import ca.sait.jms.HasLogger;
import ca.sait.jms.MQConnectionFactory;

/**
 * @author Chris Elias
 *
 */
public class SendMessageTopic
implements HasLogger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new SendMessageTopic().run();
    }
    
    private void run() {
        logger().trace("ENTER run()");
        
        try (final JMSContext jmsContext = MQConnectionFactory.newContext();) {
            
            final Destination destTopic = jmsContext.createTopic("sait.ONE");
            final JMSProducer producer = jmsContext.createProducer();
            
            producer.setAsync(new AsyncListener());
            
            for (int i = 0; i < 10; i++) {
                final String msg = "hello-topic-" + i;
                logger().info("Sending Message: {}", msg);
                producer.send(destTopic, msg);
                
               final TextMessage tm = jmsContext.createTextMessage("hello-topic-selector-" + i);
                tm.setStringProperty("colour", "red");
                
                jmsContext.createProducer().send(destTopic, tm);
            }
            
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            logger().trace("EXIT run()");
        }
    }

}
