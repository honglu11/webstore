/**
 * 
 */
package ca.sait.util;

/**
 * 
 */
public class StringUtils {

    /**
     * 
     * @param value
     * @return
     */
    public static boolean isEmptyOrNull(String value) {
        if (value != null && value.trim().length() > 0) 
            return false;
        
        return true;
    }
}
