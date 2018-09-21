package ca.sait.mystore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Chris Elias
 */
public interface HasLogger {

    default Logger logger() {
        return LoggerFactory.getLogger(getClass());
    }
}
