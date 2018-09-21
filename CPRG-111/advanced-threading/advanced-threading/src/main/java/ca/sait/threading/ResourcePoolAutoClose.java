/**
 * 
 */
package ca.sait.threading;

import java.text.SimpleDateFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Chris Elias
 *
 */
public class ResourcePoolAutoClose {

    private static final int SIZE = 5;

    // singleton put into the other inner class, better than outside, since 
    private static class PoolLoader {
    	private static ResourcePoolAutoClose INSTANCE = new ResourcePoolAutoClose();
    }
    
    private BlockingQueue<DateFormatItem> dateFormats = new ArrayBlockingQueue<>(SIZE);
    
    private ResourcePoolAutoClose() {
        for (int i = 0; i < SIZE; i++) 
            dateFormats.add(new DateFormatItem());
    }
    
    public static DateFormatItem get()
    throws InterruptedException {
    	return PoolLoader.INSTANCE.dateFormats.take();
    }
    

    // create a inner class 
    public class DateFormatItem implements AutoCloseable {
    	
    	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	
    	public SimpleDateFormat getFormatter() {
			return formatter;
		}
    	
    	@Override
    	public void close() {
    		try {
    			dateFormats.put(this);
    		} catch(final Exception ex) {
    			// silent catch
    		}
    	}
    }
    
    
}
