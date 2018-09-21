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
public class ExampleRunnableMain {
	
	private final static Logger logger = LoggerFactory.getLogger(ExampleRunnableMain.class);

	/**
	 * 
	 */
	public ExampleRunnableMain() {
		logger.trace("START ExampleThread()");
		final ExampleRunnable r1 = new ExampleRunnable();
		final Thread t1 = new Thread(r1);
		final Thread t2 = new Thread(r1);
		t1.start(); // if use t1.run-> will use main thread only, but t1.start() kick off t1 process
		t2.start();
		
		logger.trace("EXIT ExampleThread()");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.trace("ENTER main()");
		new ExampleRunnableMain();
		logger.trace("EXIT main()");

	}

}