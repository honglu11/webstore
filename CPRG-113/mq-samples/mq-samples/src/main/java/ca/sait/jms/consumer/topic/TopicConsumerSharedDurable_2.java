/**
 * 
 */
package ca.sait.jms.consumer.topic;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

import ca.sait.jms.HasLogger;
import ca.sait.jms.MQConnectionFactory;

/**
 * @author Chris Elias
 *
 */
public class TopicConsumerSharedDurable_2 
implements HasLogger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new TopicConsumerSharedDurable_2().run();
    }
    
    private void run() {
        logger().trace("ENTER run()");
        
        try (final JMSContext jmsContext = MQConnectionFactory.newContext();) {
            jmsContext.setClientID("client-3");
            
            final Topic destTopic = jmsContext.createTopic("sait.ONE");
            
            try(final JMSConsumer consumer = jmsContext.createSharedDurableConsumer(destTopic, "consumer-2s")) {
                consumer.setMessageListener(new MessageListener() {
                    
                    @Override
                    public void onMessage(Message message) {
                        try {
                            logger().info("Topic Durable - {}", message.getBody(String.class));
                        } catch (JMSException ex) {
                            logger().error(ex.getMessage(), ex);
                        }
                    }
                });
    
                
                System.out.println("Topic Client started successfully !!");
                System.out.println("Press A to shutdown:");
                
                try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
                    char answer = '\0';
                    
                    while (!((answer == 'a') || (answer == 'A'))) {
                        try {
                            answer = (char) inputStreamReader.read();
                        } catch (final IOException e) {
                            System.err.println("I/O exception: " + e.toString());
                        }
                    }
                }
            }
        } catch (final Exception ex) {
            logger().error(ex.getMessage(), ex);
        } finally {
            logger().trace("EXIT run()");
        }
    }

}







