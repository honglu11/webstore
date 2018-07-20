package ca.sait.mystore.web.http.listener;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ca.sait.util.HasLogger;


/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener 
implements ServletContextListener, HasLogger {

    
    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger().trace("ENTER contextDestroyed(event)");
        logger().trace("EXIT contextDestroyed(event)");
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger().trace("ENTER contextInitialized(event)");

        setupSupportedLocales(sce);
        
        logger().trace("EXIT contextInitialized(event)");
    }

    /**
     * Reads from a configuration and setups supported locales for the web
     * application
     * 
     * @param sce
     */
    private void setupSupportedLocales(ServletContextEvent sce) {
        logger().trace("ENTER setupSupportedLocales(sce)");

        final Map<String, Locale> supportedLocales = new LinkedHashMap<String, Locale>();
        final String[] languageTags = sce.getServletContext().getInitParameter("supported-locales").split("\\|");

        for (final String languageTag : languageTags) {
            final Locale locale = Locale.forLanguageTag(languageTag);
            supportedLocales.put(locale.toString(), locale);
            logger().debug("Added Supported Locale: {}", locale.getDisplayName());
        }

        sce.getServletContext().setAttribute("supportedLocales", supportedLocales);

        logger().trace("EXIT setupSupportedLocales(sce)");
    }
}