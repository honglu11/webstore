package ca.sait.logger;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleRunnable3 implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private AtomicInteger counter = new AtomicInteger(); // do memory in the same place, no swap, so guarrentee, grace syncronized way, very faster
	
	// no swap
		
	@Override
	public void run() {
       logger.trace("ENTER run()");
	
       //if put synchronized outside of for loop get two thread run seperate i not looks like share
		try {
			while (true) {
				final int i = counter.getAndIncrement();
				
				if ( i < 100) {
					
					if ( i == 50) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					logger.info("i: {}", i); // see 50 print out later, don't block other thread carry on.
				}
				 else {
					break;
				 }
				
			}
			
		} finally {
			logger.trace("EXIT run()");
		}
		
	}

}