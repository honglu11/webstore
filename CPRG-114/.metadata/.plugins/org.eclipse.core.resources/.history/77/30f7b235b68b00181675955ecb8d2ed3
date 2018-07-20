package ca.sait.mystore.admin.http.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ca.sait.util.HasLogger;
import ca.sait.util.StringUtils;

/**
 * Servlet Filter implementation class FormIdFilter
 */
@WebFilter(filterName = "FormIdFilter",servletNames={"ControllerServlet"})
public class FormIdFilter 
implements Filter, HasLogger {

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        logger().trace("ENTER doFilter(request,response,chain)");
        
        final HttpSession session = ((HttpServletRequest)request).getSession();
        final String formId = request.getParameter("formId");
        if (!StringUtils.isEmptyOrNull(formId)) {
            final Object sessionFormId = session.getAttribute("formId");
            
            if (!formId.equals(sessionFormId)) {
                throw new ServletException("Can't Resubmit Form");
            }
        }
        
        session.removeAttribute("formId");
        
        chain.doFilter(request, response);
        logger().trace("EXIT doFilter(request,response,chain)");
    }


    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
