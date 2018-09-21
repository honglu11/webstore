/**
 * 
 */
package ca.sait.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author honglu
 *
 */
public class ExampleExecutionRunnableMain2 {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public ExampleExecutionRunnableMain2() {
		logger.trace("START ExampleThread()");
		//final ExampleCounterRunnable2 r2 = new ExampleCounterRunnable2(); // since i is private then two thread share the same i, the counter print out is screw up. two thread manipulate the same fields, i is put into temp memaory when thread swap, thread is confused by the values.
		// fatory pattern
		//final ExecutorService service = Executors.newFixedThreadPool(2); // should be under the capacity of CPU - 2
		final ExecutorService service = Executors.newCachedThreadPool(); // java figure out how many thread need base on CPU
		//final ExecutorService service = Executors.newSingleThreadExecutor();
		final ExampleCounterRunnable task = new ExampleCounterRunnable();
		
		// 2 threads, 6 tasks, 2 run first, when first 2 finish, then run next 2.
		service.submit(task);
		service.submit(task);
		service.submit(task);
		service.submit(task);
		service.submit(task);
		service.submit(task);

		logger.debug("Shutdown"); // service in different thread, when 
		service.shutdown(); // when service in different thread done, shut down
		
		//service.submit(task);
		
		logger.trace("EXIT ExampleThread()");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleExecutionRunnableMain2();

	}

}
