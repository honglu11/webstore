package ca.sait.threading.cp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class SharedResource<T> {

    public static final int TOTAL_PROCESS = 10_000_000;
    public static final int THREAD_COUNT = 5;
    public static final int MAX_QUEUE_SIZE = 200;

    private final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    
    private final AtomicInteger counter = new AtomicInteger();

    private final ReadLock readLock = LOCK.readLock();
    private final WriteLock writeLock = LOCK.writeLock();
    
    private final ExecutorService producers = Executors.newFixedThreadPool(THREAD_COUNT);
    private final ExecutorService consumers = Executors.newFixedThreadPool(THREAD_COUNT);
    
    private final Queue<T> queue = new LinkedList<>(); // not thread safe
    private final List<String> producerStats = new ArrayList<>(SharedResource.TOTAL_PROCESS);

    /**
	 * @return the queue
	 */
	public Queue<T> getQueue() {
		return queue;
	}

	/**
	 * @return the producerStats
	 */
	public List<String> getProducerStats() {
		return producerStats;
	}

	/**
     * @return the counter
     */
    public AtomicInteger getCounter() {
		return counter;
	}
    
	/**
	 * @return the readLock
	 */
	public ReadLock getReadLock() {
		return readLock;
	}
	/**
	 * @return the writeLock
	 */
	public WriteLock getWriteLock() {
		return writeLock;
	}
	/**
	 * @return the producers
	 */
	public ExecutorService getProducers() {
		return producers;
	}
	/**
	 * @return the consumers
	 */
	public ExecutorService getConsumers() {
		return consumers;
	}
}
