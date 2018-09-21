/**
 * 
 */
package ca.sait.threading;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chris Elias
 * 
 */
public class Example01 extends BaseThreadExample {

    private static final Logger LOG = LoggerFactory.getLogger(Example01.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Example01().runTest();
    }

    private void runTest() {
        LOG.info("Generate DOBS");
        final List<String> dobs = generateDOBS();
        
        LOG.info("Process DOBS");
        //not efficient single loop every dob has one thread, server cannot afford. not efficient
        for (final String dob : dobs) {
            final ExampleRunnable01 example = new ExampleRunnable01(dob);
            final Thread thread = new Thread(example);
            thread.start();
        }

        LOG.info("Finished");
    }
}
