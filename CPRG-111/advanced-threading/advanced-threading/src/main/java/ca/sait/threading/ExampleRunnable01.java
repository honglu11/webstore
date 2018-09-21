/**
 * 
 */
package ca.sait.threading;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Chris Elias
 */
public class ExampleRunnable01 implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleRunnable01.class);

   // private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // one copy only, so make that not equal fix take off static, clean up the memory by gabage collection
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // one copy only, so make that not equal fix take off static, clean up the memory by gabage collection
    private final String dob;

    public ExampleRunnable01(String dob) {
        this.dob = dob;
    }

    @Override
    public void run() {
        try {
            final Date date = dateFormat.parse(dob);
            final String newDate = dateFormat.format(date);
            LOG.info("Orig: {}  New Date: {}", dob, newDate);
            
            if (!dob.equals(newDate)) {
                LOG.error("Invalid dates: {}-{}",dob, newDate);
            }
        } catch(final ParseException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

}
