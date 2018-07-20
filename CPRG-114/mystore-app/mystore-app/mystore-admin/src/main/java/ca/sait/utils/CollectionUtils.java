/**
 * 
 */
package ca.sait.utils;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class CollectionUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(CollectionUtils.class.getName());
    /**
     * 
     * @param collection
     * @param o
     * @return
     */
    // must static
    public static boolean contains(Collection<?> collection, Object o) {
        LOG.trace("ENTER contains(collection, object)");
        LOG.trace("Testing {}", o);
       
        try {
        if (collection == null)
            return false;
        
        LOG.debug("Contains: {}", collection.contains(o));
        return collection.contains(o);
        } finally {
            LOG.trace("EXIT contains(collection, object)");
        }
     }
    
    /**
     * 
     * @param collection
     * @param seperator
     * @return
     */
    public static String join(Collection<?> collection, String seperator) {
        if (collection == null)
            return "";
        
        return collection.stream()
            .map(i -> i.toString())
            .collect(Collectors.joining(seperator));
    }
}














