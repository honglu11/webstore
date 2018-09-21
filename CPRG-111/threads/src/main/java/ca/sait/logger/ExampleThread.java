/**
 * 
 */
package ca.sait.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author honglu
 *
 */
public class ExampleThread extends Thread {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void run() {
		logger.trace("ENTER run()");
		
		try {
			for (int i = 0; i < 100; i++) {
				logger.info("i :" + i);
			}
		} finally {
			logger.trace("EXIT run()");
		}
				
	}

}
