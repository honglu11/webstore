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
public class ExampleThreadMain {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public ExampleThreadMain() {
		logger.trace("START ExampleThread()");
		final ExampleThread t1 = new ExampleThread();
		t1.start(); // if use t1.run-> will use main thread only, but t1.start() kick off t1 process
		
		logger.trace("EXIT ExampleThread()");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleThreadMain();

	}

}
