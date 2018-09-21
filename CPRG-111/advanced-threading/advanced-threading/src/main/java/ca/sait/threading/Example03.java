/**
 * 
 */
package ca.sait.threading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chris Elias
 * 
 */
public class Example03 extends BaseThreadExample {

    private static final Logger LOG = LoggerFactory.getLogger(Example03.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Example03().runTest();
    }

    private void runTest() {
        LOG.info("Generate DOBS");
        final List<String> dobs = generateDOBS();
        
        final ExecutorService service = Executors.newCachedThreadPool();

        LOG.info("Process DOBS");
        for (final String dob : dobs) {
            //final ExampleRunnable01 task = new ExampleRunnable01(dob
        	final ExampleRunnable03 task = new ExampleRunnable03(dob);
            service.submit(task);
        }

        service.shutdown();
        LOG.trace("Finished");

        LOG.info("Finished");
    }
}
