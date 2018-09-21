/**
 * 
 */
package ca.sait.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 * @author honglu
 *
 */
@Singleton
public class SheduledEJB implements HasLogger {
    
    // "*/5" here mean every five seconds
    @Schedule(second="*/59", minute="*", hour="*", persistent=false)// true maintain report information after restart server, dayOfMonth = "1,2,25")
    public void runReport() {
        logger().trace("ENTER runReport()");
        logger().trace("EXIT runReport()");
    }

}
