/**
 * 
 */
package ca.sait.threading;

import java.util.ArrayList;
import java.util.List;

import ca.sait.utils.DOBGenerator;

/**
 * 
 * @author Chris Elias
 */
public class BaseThreadExample {

    public static final int TEST_COUNT = 10000;

    /**
     * 
     * @return
     */
    public List<String> generateDOBS() {
        
        final List<String> dobs = new ArrayList<>(TEST_COUNT);
        
        for (int i = 0; i < TEST_COUNT; i++) {
            final String dob = DOBGenerator.generateDOB(1950, 2013);
            dobs.add(dob);
        }

        return dobs;
    }
}
