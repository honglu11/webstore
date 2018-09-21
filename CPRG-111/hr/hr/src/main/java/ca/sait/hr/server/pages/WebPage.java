/**
 * 
 */
package ca.sait.hr.server.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public interface WebPage {
	
	public static final Logger logger = LoggerFactory.getLogger(WebPage.class);
	
	public String buildPage();

}
