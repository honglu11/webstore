/**
 * 
 */
package ca.sait.threading;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chris Elias
 * 
 */
public class Example04 extends BaseThreadExample {

    private static final Logger LOG = LoggerFactory.getLogger(Example04.class);
    public static final ResourcePool RESOURCE = new ResourcePool();

    private final ExecutorService cleanupPool = Executors.newSingleThreadExecutor();
    private final ExecutorService processPool = Executors.newFixedThreadPool(5);
    private final CompletionService<Date> pool = new ExecutorCompletionService<Date>(processPool);

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Example04().runTest();
    }

    private void runTest() {
        cleanup();
        
        LOG.info("Generate DOBS");
        final List<String> dobs = generateDOBS();

        LOG.info("Process DOBS");
        for (final String dob : dobs) {
            final ExampleRunnable03 task = new ExampleRunnable03(dob);
            pool.submit(task);
        }

        processPool.shutdown(); // complete task and shut down 
        
        while (!processPool.isTerminated()) {
            // keep running until process pool is completed
        }
        
        
        cleanupPool.shutdownNow(); // since nothing left in processPool, shutdownnow ( shut down now don't care task finish or not )
        LOG.info("Finished");
    }
    
    private void cleanup() {
    	//interface 
        final Runnable cleanup = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        final Future<Date> future = pool.take(); // when the comuming task done, take it out from complete pool put to Future
                        final Date dob = future.get(); 

                        LOG.info("Processed Date: {}", dob);

                    } catch (final InterruptedException ex) {
                        break;
                    } catch (final ExecutionException ex) {
                        LOG.error(ex.getMessage(), ex);
                    }
                }
            }
        };

        cleanupPool.submit(cleanup);
    }

}











