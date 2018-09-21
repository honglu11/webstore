/**
 * 
 */
package ca.sait.mvc.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.HasLogger;
import ca.sait.business.GenerateReport;

/**
 * @author honglu
 *
 */
@RequestScoped // try to use one instance of Sevlet geneate 
public class ReportModel implements HasLogger {  
    
    // create model, and put into Request scoped, then everytime when EJB is invoke, it will invoke postConstruct
    
    @EJB
    private GenerateReport generateReport;
    
    public void handle(HttpServletRequest request, HttpServletResponse response, Integer count) throws IOException {
        logger().trace("ENTER handle(HttpServletRequest request, HttpServletResponse response, Integer count)");
        
        final String reportName = request.getParameterMap().computeIfAbsent("name",  k ->  f("default"))[0] + " - " + count.toString();
        final String msg = generateReport.generateReport(reportName);
        response.getWriter().append("Message: ").append(msg);
            
        logger().trace("Exit handle(HttpServletRequest request, HttpServletResponse response, Integer count)");
    }
    
    private String [] f(String defaultValue) {
        final String[] a = {defaultValue};
        return a;
    }


}