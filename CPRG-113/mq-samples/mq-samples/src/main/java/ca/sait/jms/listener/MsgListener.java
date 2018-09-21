/**
 * 
 */
package ca.sait.jms.listener;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author hongl
 *
 */
public class MsgListener 
implements MessageListener, HasLogger {
    
    private final int instanceId;
    
    public MsgListener(int instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public void onMessage(Message message) {
       logger().trace("ENTER onMessage");
       
       try {
           final Enumeration<String> names = message.getPropertyNames();
           while (names.hasMoreElements()) {
               final String name = names.nextElement();
               final Object value = message.getObjectProperty(name);
               logger().info("Property: {} Value: {}", name, value);
           }
           logger().info("Received Message - ({}): {}", instanceId, message.getBody(String.class));
       } catch (JMSException ex) {
           logger().error(ex.getMessage(), ex);
       }
       
        logger().trace("EXIT onMessage");
        
    }
}
