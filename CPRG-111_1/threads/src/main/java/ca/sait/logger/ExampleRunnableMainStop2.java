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
public class ExampleRunnableMainStop2 {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public ExampleRunnableMainStop2() {
		logger.trace("START ExampleThread()");
		final ExampleRunnableStop2 r1 = new ExampleRunnableStop2();
		final Thread t1 = new Thread(r1);
		final Thread t2 = new Thread(r1);
		t1.start(); // if use t1.run-> will use main thread only, but t1.start() kick off t1 process
		t2.start();
		logger.info("Goto Sleep");
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		
		logger.info("set time to quit");
		
		t1.interrupt();
		t2.interrupt();
		
			
		logger.trace("EXIT ExampleThread()");
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleRunnableMainStop2();		
	
	}

}