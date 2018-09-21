package ca.sait.threading.cp;

public abstract class Producer<T> implements Runnable {
    
	private final SharedResource<T> SHARED;
	
	public Producer(SharedResource<T> shared) {
		 SHARED = shared;
	}
	
    @Override
    public void run() {
        
        while (true) {
            final Integer count = SHARED.getCounter().getAndIncrement();
            if (count > SharedResource.TOTAL_PROCESS)
                break;
            
            final long startTime = System.currentTimeMillis();

            boolean offer = false;
            
            do {
            	SHARED.getWriteLock().lock();
                try {
                    offer = SHARED.getQueue().add(produce(count));
                } finally {
                	SHARED.getWriteLock().unlock();
                }
            } while (!offer);
            
            final long endTime = System.currentTimeMillis();
            SHARED.getProducerStats().add(String.format("%d|%d",  startTime, endTime));
        }
    }
    
    /**
     * 
     * @param count
     * @return
     */
    protected abstract T produce(int count);
}