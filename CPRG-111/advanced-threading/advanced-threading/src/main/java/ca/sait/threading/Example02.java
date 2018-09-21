/**
 * 
 */
package ca.sait.threading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chris Elias
 * 
 */
public class Example02 extends BaseThreadExample {

    private static final Logger LOG = LoggerFactory.getLogger(Example02.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Example02().runTest();
    }

    private void runTest() {
        LOG.info("Generate DOBS");
        final List<String> dobs = generateDOBS();
        
        final ExecutorService service = Executors.newFixedThreadPool(5, new ThreadFactory() {
            
        	private int counter = 0;
        	
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "dob-processing-" + counter++);
            }
        });

        LOG.info("Process DOBS");
        for (final String dob : dobs) {
            final ExampleRunnable01 task = new ExampleRunnable01(dob);
            service.submit(task);
        }
        
        service.shutdown();
        LOG.trace("Finished");
    }
}
