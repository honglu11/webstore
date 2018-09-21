/**
 * 
 */
package ca.sait.threading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 
 * @author Chris Elias
 */
public class ExampleRunnable03 implements Callable<Date> {

    private final String dob;
    
    public ExampleRunnable03(String dob) {
        this.dob = dob;
    }

    @Override
    public Date call() throws Exception {
        SimpleDateFormat dateFormat = Example04.RESOURCE.aquire();
        
        try {
            return dateFormat.parse(dob);
        } finally {
            Example04.RESOURCE.release(dateFormat);
        }
    }
}
