/**
 * 
 */
package ca.sait.jms.server;

import java.io.IOException;
import java.io.InputStreamReader;

import org.hornetq.core.config.impl.FileConfiguration;
import org.hornetq.core.server.HornetQServer;
import org.hornetq.core.server.HornetQServers;
import org.hornetq.jms.server.JMSServerManager;
import org.hornetq.jms.server.impl.JMSServerManagerImpl;

/**
 * 
 * @author Chris Elias
 */
public class Standalone {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Starting, Please wait....");
        try {
            // Load the file configuration first of all
            final FileConfiguration configuration = new FileConfiguration();
            configuration.setConfigurationUrl("hornetq-configuration.xml");
            configuration.start();
            // Create a new instance of hornetq server
            final HornetQServer server = HornetQServers.newHornetQServer(configuration);
            
            // Wrap inside a JMS server
            final JMSServerManager jmsServerManager = new JMSServerManagerImpl(server, "hornetq-jms.xml");

            // if you want to use JNDI, simple inject a context here or don't
            // call this method and make sure the JNDI parameters are set.
            jmsServerManager.setContext(null);
            // Start the server
            jmsServerManager.start();
            
            System.out.println("HornetQ server started successfully !!");
            System.out.println("Press Q to shutdown:");
            
            try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
                char answer = '\0';
                
                while (!((answer == 'q') || (answer == 'Q'))) {
                    try {
                        answer = (char) inputStreamReader.read();
                    } catch (final IOException e) {
                        System.err.println("I/O exception: " + e.toString());
                    }
                }
            }
            
            System.out.println("Shutting down...");
            jmsServerManager.stop();
            server.stop();
            configuration.stop();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
