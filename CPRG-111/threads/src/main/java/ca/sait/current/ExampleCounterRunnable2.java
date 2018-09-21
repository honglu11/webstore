package ca.sait.current;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleCounterRunnable2 implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private int counter = 0;
	private final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
	private final WriteLock WRITE = LOCK.writeLock();
	private final ReadLock READ = LOCK.readLock();
	
	
	// no swap
		
	@Override
	public void run() {
       logger.trace("ENTER run()");
	
       //if put synchronized outside of for loop get two thread run seperate i not looks like share
		try {
			boolean keepRunning = true;
			//int i;
			//while (true) {
			while(keepRunning) {
				//WRITE.lock() need more overhead, here synchroized is best here, if we share the read, don't use syncronized
				final int i ; 
				synchronized (this) {
					i = counter++;
				}
				//WRITE.unlock()
				if (i>99)
					return;

				switch(i) {
				case 50: 
					try {
						logger.info("Going to Sleep: {}", i);
						Thread.sleep(2000);
						logger.info("Wait up: {}", i);
					}catch (final InterruptedException e) {
						logger.error(e.getMessage(), e);						
					}
	
				break;

				default:
					logger.info("i: {}", i);
			 }
			} 
		}finally {
			logger.trace("EXIT run()");
		}
		
	}

}
