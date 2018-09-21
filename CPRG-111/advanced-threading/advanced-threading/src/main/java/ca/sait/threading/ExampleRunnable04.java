/**
 * 
 */
package ca.sait.threading;

import java.util.Date;
import java.util.concurrent.Callable;

import ca.sait.threading.ResourcePoolAutoClose.DateFormatItem;

/**
 * 
 * @author Chris Elias
 */
public class ExampleRunnable04 implements Callable<Date> {

    private final String dob;
    
    public ExampleRunnable04(String dob) {
        this.dob = dob;
    }

    @Override
    public Date call() throws Exception {
        try (final DateFormatItem dateFormat = ResourcePoolAutoClose.get()) {
            return dateFormat.getFormatter().parse(dob);
        }
    }
}
