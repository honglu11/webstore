package ca.sait.logger;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleRunnableStop implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	//public volatile boolean timeToQuit = false; // share this value in shared, use volatile to force every thread synch with this value
	public final AtomicBoolean timeToQuit = new AtomicBoolean(false);
	
	@Override
	public void run() {
       logger.trace("ENTER run()");
		
		try {
			logger.info("Thread started");
			while (!timeToQuit.get()) {
				
			}
			logger.info("Thread stop");
		} finally {
			logger.trace("EXIT run()");
		}
		
	}

}
