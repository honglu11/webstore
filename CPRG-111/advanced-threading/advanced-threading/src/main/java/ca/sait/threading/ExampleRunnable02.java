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
public class ExampleRunnable02 implements Runnable {

    public static final int TEST_COUNT = 10000;
    
    private static final Logger LOG_OUTPUT = LoggerFactory.getLogger("FILE-OUTPUT");
    private static final Logger LOG = LoggerFactory.getLogger(ExampleRunnable02.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
    private final String dob;

    private static final Object LOCK = new Object(); // one instance all thread can see
    //private final Object LOCK = new Object(); // remove static, final Object LOCK is localize?
    
    public ExampleRunnable02(String dob) {
        this.dob = dob;
    }

    @Override
    public void run() {
        // single thread, bottle neck, multiple thread to one thread, performace issue
        synchronized (LOCK) {
            try {
                final Date date = dateFormat.parse(dob);
                final String newDate = dateFormat.format(date);
                LOG_OUTPUT.info("Orig: {}  New Date: {}", dob, newDate);
            } catch(final ParseException ex) {
                LOG.error(ex.getMessage(), ex);
            }
        }
    }

}
