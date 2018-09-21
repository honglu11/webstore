package ca.sait.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleRunnable implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void run() {
       logger.trace("ENTER run()");
		
		try {
			for (int i = 0; i < 100; i++) {
				logger.info("i: {}", i); //logger air mode, use {} will output only if it turn on level.
			}
		} finally {
			logger.trace("EXIT run()");
		}
		
	}

}