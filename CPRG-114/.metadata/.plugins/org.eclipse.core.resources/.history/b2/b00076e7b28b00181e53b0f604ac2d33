package ca.sait.mystore.web.http.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import ca.sait.mystore.web.Constants;
import ca.sait.util.HasLogger;

/**
 * Servlet Filter implementation class LanguageFilter
 */
@WebFilter(filterName = "LocaleFilter", servletNames={"ControllerServlet"})
public class LocaleFilter 
implements Filter, HasLogger {

    private Map<String, Locale> supportedLocales;
    private Locale defaultLocale;

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        logger().trace("ENTER destroy()");
        logger().trace("EXIT destroy()");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        logger().trace("ENTER doFilter(request,response)");

        final Locale currentLocale;
        final String selectedLocale = request.getParameter(Constants.PARAM_LOCALE);
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpSession session = req.getSession();

        logger().debug("RequestURI: {}", req.getRequestURI());

        if (selectedLocale != null) {
            logger().debug("New locale value submitted: {}", selectedLocale);
            if (supportedLocales.containsKey(selectedLocale)) {
                logger().debug("locale {} supported", selectedLocale);
                currentLocale = supportedLocales.get(selectedLocale);
            } else {
                logger().debug("locale {} not supported. Selecting default {}", selectedLocale, defaultLocale.toLanguageTag());
                currentLocale = defaultLocale;
            }

            session.setAttribute(Constants.SESSION_LOCALE_KEY, currentLocale);
        } else {
            Locale tmpLocale = (Locale) session.getAttribute(Constants.SESSION_LOCALE_KEY);

            // if the locale is not in the session
            if (tmpLocale == null) {

                // go through browser setting locales to see if one is supported
                if (request.getLocales() != null) {
                    final Enumeration<Locale> clientLocales = request.getLocales();
                    while (clientLocales.hasMoreElements()) {
                        final Locale locale = clientLocales.nextElement();
                        if (supportedLocales.containsKey(locale.toLanguageTag())) {
                            tmpLocale = locale;
                            break;
                        }
                    }
                }

                // if none of the client locales are supported, than use the
                // default
                if (tmpLocale == null) {
                    tmpLocale = defaultLocale;
                    logger().debug("User Locale not defined, setting to default: {}", defaultLocale.toLanguageTag());
                }

                session.setAttribute(Constants.SESSION_LOCALE_KEY, tmpLocale);
            }

            currentLocale = tmpLocale;
        }

        // create a request wrapper that will be passed onto the chain
        final HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req) {
            @Override
            public Locale getLocale() {
                return currentLocale;
            }
        };

        response.setLocale(currentLocale);

        try {
            chain.doFilter(requestWrapper, response);
        } finally {
            logger().trace("EXIT doFilter(request,response)");
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    @SuppressWarnings("unchecked")
    public void init(FilterConfig fConfig) throws ServletException {
        logger().trace("ENTER init(fConfig)");

        supportedLocales = (Map<String, Locale>) fConfig.getServletContext().getAttribute("supportedLocales");
        defaultLocale = supportedLocales.entrySet().iterator().next().getValue();

        logger().trace("EXIT init(fConfig)");
    }
}