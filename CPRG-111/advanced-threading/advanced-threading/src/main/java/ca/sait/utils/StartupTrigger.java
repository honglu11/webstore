/**
 * 
 */
package ca.sait.utils;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;
import ch.qos.logback.core.rolling.RolloverFailure;

/**
 * @author Chris Elias
 *
 */
@NoAutoStart
public class StartupTrigger<E> 
        extends DefaultTimeBasedFileNamingAndTriggeringPolicy<E> {

    @Override
    public void start() {
        super.start();
        nextCheck = 0L;
        isTriggeringEvent(null, null);
        try {
            tbrp.rollover();
        } catch (RolloverFailure e) {
            //Do nothing
        }
    }

}