/**
 * 
 */
package ca.sait.current;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author honglu
 *
 */
public class ExampleExecutionCallableMain {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public ExampleExecutionCallableMain() {
		logger.trace("START ExampleThread()");
		//final ExampleCounterRunnable2 r2 = new ExampleCounterRunnable2(); // since i is private then two thread share the same i, the counter print out is screw up. two thread manipulate the same fields, i is put into temp memaory when thread swap, thread is confused by the values.
		// fatory pattern
		//final ExecutorService service = Executors.newFixedThreadPool(2); // should be under the capacity of CPU - 2, only two threads so 2 boolean are true, use thread to take corresponding response in callable, if no thread, cannot take response.
		final ExecutorService service = Executors.newCachedThreadPool(); // java figure out how many thread need base on CPU
		//final ExecutorService service = Executors.newSingleThreadExecutor();
		final ExampleCounterCallable task = new ExampleCounterCallable();
		
		// 2 threads, 6 tasks, 2 run first, when first 2 finish, then run next 2.
		final Future<Boolean> t1 = service.submit(task);
		final Future<Boolean> t2 = service.submit(task);
		final Future<Boolean> t3 = service.submit(task);
		final Future<Boolean> t4 = service.submit(task);
		final Future<Boolean> t5 = service.submit(task);
		final Future<Boolean> t6 = service.submit(task);			

		logger.debug("Shutdown"); // service in different thread, when 
		service.shutdown(); // when service in different thread done, shut down
		try {
			logger.info("t1 = {}", t1.get());
			logger.info("t2 = {}", t2.get());
			logger.info("t3 = {}", t3.get());
			logger.info("t4 = {}", t4.get());
			logger.info("t5 = {}", t5.get());
			logger.info("t6 = {}", t6.get());		
			} catch (InterruptedException | ExecutionException ex) {
				logger.error(ex.getMessage(), ex);
			}
		
		logger.trace("EXIT ExampleThread()");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExampleExecutionCallableMain();

	}

}
