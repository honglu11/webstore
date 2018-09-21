package ca.sait.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleRunnable2 implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private int i = 0; // share in the top cause thread confusing, temp memory back to original 0...
	private final Object LOCK = new Object(); // this object is shared by all the thread as long as different thread run this class
	
	@Override
	public void run() {
       logger.trace("ENTER run()");
	
       //if put synchronized outside of for loop get two thread run seperate i not looks like share
		try {
			synchronized (LOCK) {
			for (;i < 100; i++) {
				//synchronized (LOCK) {  // if don't define LOCK, use synchronized (this), synchronized mean only allow one thread work on it at one time.
				logger.info("i: {}", i); //logger air mode, use {} will output only if it turn on level.
				//}
				
				if ( i == 50) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			}
		} finally {
			logger.trace("EXIT run()");
		}
		
	}

}