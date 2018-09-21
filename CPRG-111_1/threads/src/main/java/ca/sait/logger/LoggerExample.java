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
public class LoggerExample {
	
	//private final Logger logger = LoggerFactory.getLogger(LoggerExample.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new LoggerExample().run();

	}
	
	public void run() {
		this.logger.trace("This is trace");
		logger.debug("This is debug"); // in production never turn trace on
		logger.info("This is info");
		logger.warn("This is warn");
		logger.error("This is error");
	}
	

}
