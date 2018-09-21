/**
 * 
 */
package ca.sait.threading.cp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Chris Elias
 */
public class AdvancedConsumerProducer<T> implements Runnable {

	private final SharedResource<String> SHARED = new SharedResource<>();
    private final Logger logger = LoggerFactory.getLogger(AdvancedConsumerProducer.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        new AdvancedConsumerProducer<String>().run();
    }

    public void run() {
    	// create consumers and producers
        for (int i = 0; i < SharedResource.THREAD_COUNT; i++) {
            SHARED.getProducers().submit(new AdvancedConsumer(SHARED));
            SHARED.getConsumers().submit(new AdvancedProducer(SHARED));
        }
        
        SHARED.getConsumers().shutdown();
        SHARED.getProducers().shutdown();
        
        // small monitor if not terminated
        while (!SHARED.getConsumers().isTerminated()) {
        
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // silent catch
            }
            
            SHARED.getReadLock().lock();
             
            try {
                int count = SHARED.getQueue().size();
                logger.warn("Count = {}", count);
            } finally {
            	SHARED.getReadLock().unlock();
            }
        }
    }
}