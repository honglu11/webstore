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
public class ExampleRunnableMainStop {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public ExampleRunnableMainStop() {
		logger.trace("START ExampleThread()");
		final ExampleRunnableStop r1 = new ExampleRunnableStop();
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
		
		r1.timeToQuit.set(true);  //try to stop the thread, but cannot, by normal boolean
		
			
		logger.trace("EXIT ExampleThread()");
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleRunnableMainStop();		
	
	}

}
