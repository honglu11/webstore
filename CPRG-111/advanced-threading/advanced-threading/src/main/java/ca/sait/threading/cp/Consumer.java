package ca.sait.threading.cp;

import java.util.concurrent.Callable;

public abstract class Consumer<T> implements Callable<T> {
	
	private final SharedResource<T> SHARED;
	
	public Consumer(SharedResource<T> shared) {
		SHARED = shared;
	}
    
    @Override
    public T call() {
    	T object = null;
        while (true) {
            SHARED.getReadLock().lock();
            try {
                object = SHARED.getQueue().poll(); // get first object from queue
            } finally {
                SHARED.getReadLock().unlock();
            }
            
            if (object == null && SHARED.getProducers().isShutdown()) {
                break;
            } else if (object != null) {
                consume(object);
            } else {
                try {
                    Thread.sleep(500); // go to sleep wait up into loop again, delay 50 millis ~ 500 millis is good
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        
        return object;
    }
    
    /**
     * 
     * @param object
     */
    protected abstract void consume(T object);
}
