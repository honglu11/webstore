package ca.sait.http.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter(servletNames = { "PersonController" })//(urlPatterns = {"/person", "/hello", "/one/*"})//servletNames = { "PersonController" })
public class LoggingFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        logger.trace("ENTER destroy()");
        logger.trace("EXIT destroy()");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override// can throw exception 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        // pass the request along the filter chain
        logger.trace("ENTER doFilter(request, resposne, chain)");
        
        // chain pattern, next filter, next filter, if don't call chain.doFilter won't moving forward, redirect to somewhere else,
        // put busniess logic here. database doing the research then come back. dynamic security, dynamic change the application behavior.
        // Aysch, JEE anitation, we can manipulate the response here.
        final HttpServletRequest req = (HttpServletRequest)request;
        
        chain.doFilter(request, response);
        
        logger.trace("EXIT doFilter(request, resposne, chain)");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override// init when first time mapping url hitting
    public void init(FilterConfig fConfig) throws ServletException {
        logger.trace("ENTER init(config)");
        logger.trace("EXIT init(config)");
    }
}
