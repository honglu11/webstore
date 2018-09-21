package ca.sait.current;

import java.util.concurrent.Callable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleCounterCallable implements Callable<Boolean> {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private int counter = 0;

	@Override
	public Boolean call() throws Exception {
		logger.trace("ENTER call()");
		//boolean didSomeWork = false;
		try {
			boolean didSomeWork = false;
			while(true) {				
				final int i ; 
				synchronized (this) {
					i = counter++;
				}
				
				if (i>99)
					break;
				
				didSomeWork = true;

				switch(i) {
				case 50: 
					try {
						logger.info("Going to Sleep: {}", i);
						Thread.sleep(2000);
						logger.info("Wait up: {}", i);
					}catch (final InterruptedException e) {
						logger.error(e.getMessage(), e);						
					}
	
				break;

				default:
					logger.info("i: {}", i);
			 }
			};
			return didSomeWork;
		}finally {
			logger.trace("EXIT run()");
		}
		
		//return didSomeWork;
	}

}