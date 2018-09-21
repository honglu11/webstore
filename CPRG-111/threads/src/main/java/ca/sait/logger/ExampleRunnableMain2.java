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
public class ExampleRunnableMain2 {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public ExampleRunnableMain2() {
		logger.trace("START ExampleThread()");
		final ExampleRunnable2 r2 = new ExampleRunnable2(); // since i is private then two thread share the same i, the counter print out is screw up. two thread manipulate the same fields, i is put into temp memaory when thread swap, thread is confused by the values.
		final Thread t1 = new Thread(r2);
		final Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		logger.trace("EXIT ExampleThread()");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleRunnableMain2();

	}

}
