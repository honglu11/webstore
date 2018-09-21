package ca.sait.current;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleCounterRunnable implements Runnable {
	
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
				WRITE.lock();
				final int i = counter++; // create local variable to hold the value in writing, i is thread safe.
				// READ.LOCK put READ.lock() still work now, but downgrading the lock
				WRITE.unlock(); // if unlock failed, need to kill the process in Server.
				if (i>99)
					return;
				
//				try {
//				i = counter++;
//				} finally {
//					WRITE.unlock();
//				}
				
				//READ.lock(); // everybody can read, nobody can write, READ lock is not read here since i is thread safe
				//try {
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
//				case 100:
//					break;
				default:
					logger.info("i: {}", i);
			 }
			} //while( i <100);
				
				
//				
//				if ( i < 100) {
//					
//					if ( i == 50) {
//						try {
//							Thread.sleep(2000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//					logger.info("i: {}", i); // see 50 print out later, don't block other thread carry on.
//				}
//				 else {
//					break;
//				 }				
//		
//			} 
//			finally {
//				READ.unlock();
//			}
//			}
			
		}finally {
			logger.trace("EXIT run()");
		}
		
	}

}
