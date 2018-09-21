/**
 * 
 */
package ca.sait.jms.consumer.topic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

import ca.sait.jms.HasLogger;
import ca.sait.jms.MQConnectionFactory;
import ca.sait.jms.listener.MsgListener;

/**
 * @author Chris Elias
 *
 */
public class TopicConsumerSharedDurable_1
implements HasLogger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new TopicConsumerSharedDurable_1().run();
    }
    
    private void run() {
        logger().trace("ENTER run()");
        
        try (final JMSContext jmsContext = MQConnectionFactory.newContext();) {
            // has to set clientId in very unique way, distiguish the connection, register to the same subscription
            jmsContext.setClientID("client-4");
            
            final Topic destTopic = jmsContext.createTopic("sait.ONE");
            
            // share durable consumer use topic, subscription id consumer-2s
            try (final JMSConsumer consumer1 = jmsContext.createSharedDurableConsumer(destTopic, "consumer-2s");
                 final JMSConsumer consumer2 = jmsContext.createSharedDurableConsumer(destTopic, "consumer-2s")) {
                
                MsgListener msgListener = new MsgListener(new Random().nextInt(10000));
                consumer1.setMessageListener(msgListener);
                MsgListener msgListener1 = new MsgListener(new Random().nextInt(10000));
                consumer2.setMessageListener(msgListener1);

//                consumer1.setMessageListener(new MessageListener() {
//                    
//                    @Override
//                    public void onMessage(Message message) {
//                        try {
//                            logger().info("Topic Shared Durable1 - {}", message.getBody(String.class));
//                        } catch (JMSException ex) {
//                            logger().error(ex.getMessage(), ex);
//                        }
//                    }
//                });
    
                // two consumer won't share listener
//                consumer2.setMessageListener(new MessageListener() {
//                    
//                    @Override
//                    public void onMessage(Message message) {
//                        try {
//                            logger().info("Topic Shared Durable2 - {}", message.getBody(String.class));
//                        } catch (JMSException ex) {
//                            logger().error(ex.getMessage(), ex);
//                        }
//                    }
//                });
                
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
            logger().trace("ENTER run()");
        }
    }
}