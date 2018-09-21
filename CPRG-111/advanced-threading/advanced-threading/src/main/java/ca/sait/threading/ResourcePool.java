/**
 * 
 */
package ca.sait.threading;

import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Chris Elias
 *
 */
public class ResourcePool {

    private static final int SIZE = 5;
    
    private BlockingQueue<SimpleDateFormat> dateFormats = new LinkedBlockingQueue<>(SIZE); // thread safe. since waiting
    
    public ResourcePool() {
        for (int i = 0; i < SIZE; i++) 
            dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));
    }
    
    // get from the head
    public SimpleDateFormat aquire() 
    throws InterruptedException {
        return dateFormats.take();
    }
    
    // put at the back
    public void release(SimpleDateFormat format) 
    throws InterruptedException {
        dateFormats.put(format);
    }
    
}
