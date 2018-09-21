package ca.sait.ejb;

import ca.sait.business.GenerateReport;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;

import org.slf4j.Logger;

/**
 * Session Bean implementation class GenerateReportEJB
 */
@Stateless
@Local({GenerateReport.class, HasLogger.class})
@LocalBean
//@Interceptors({MyInterceptor.class}) // class level multiple interceptor
public class GenerateReportEJB implements GenerateReport, HasLogger {

  @Resource
  private TimerService timerService;
  
  @PostConstruct
  private void postConstruct() {
      logger().trace("ENTER postConstruct");
      logger().trace("EXIT postConstruct");
  }
  
  @PreDestroy
  private void preDestroy() {
      logger().trace("ENTER preDestroy");
      logger().trace("EXIT preDestroy");
  }
    
    
	/**
     * @see GenerateReport#generateReport(String)
     */
    @Override
    @Interceptors(MyInterceptor.class) // method level interceptor
    public String generateReport(String reportName) {
        logger().trace("ENTER generateReport");
	try {
	    // when the timer stop the timeout method will be trigger out
	    timerService.createTimer(1000*20,  "Special Report - ".concat(reportName));
	    return "Special Report - ".concat(reportName);
	} finally {
	    logger().trace("EXIT generateReport");
	}
	
    }

    // time out trigger this doReport running
    @Timeout
    public void doReport(Timer timer) {
        logger().trace("ENTER doReport(Timer timer)");
        logger().info("Report Name(): {}", timer.getInfo());
        // the rest of code below would generate the report
        logger().trace("EXIT doReport(Timer timer)");
    }
    

}
