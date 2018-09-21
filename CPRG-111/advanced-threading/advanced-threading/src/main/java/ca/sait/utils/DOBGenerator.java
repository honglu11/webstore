package ca.sait.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author Chris Elias
 */
public class DOBGenerator {

    /**
     * 
     * @param startYear
     * @param endYear
     * @return
     */
    public static String generateDOB(int startYear, int endYear) {
        final GregorianCalendar gc = new GregorianCalendar();
        final int year = randomBetween(startYear, endYear);

        gc.set(Calendar.YEAR, year);
        final int dayOfYear = randomBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        return dateFormat.format(gc.getTime());
    }

    /**
     * 
     * @param start
     * @param end
     * @return
     */
    private static int randomBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
