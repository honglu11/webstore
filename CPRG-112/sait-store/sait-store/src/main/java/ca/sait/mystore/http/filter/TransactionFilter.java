package ca.sait.mystore.http.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class TransactionFilter
 */
@WebFilter("/*")
public class TransactionFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Resource
//    private UserTransaction transaction;

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
//        logger.trace("ENTER doFilter(request, response, chain)");
        try {
//            transaction.begin();

            chain.doFilter(request, response);
            
//            transaction.commit();
        } catch(final Exception ex) {
            logger.error(ex.getMessage(), ex);
//            try {
//                transaction.rollback();
//            } catch(final Exception exRollback) {
//                logger.error(exRollback.getMessage(), exRollback);
//            }
        } finally {
//            logger.trace("EXIT doFilter(request, response, chain)");
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
    }
}