package ca.sait.mystore.web.http.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.mystore.web.mvc.model.IModel;
import ca.sait.util.HasLogger;

/**
 * 
 */
@WebServlet(name="ControllerServlet", urlPatterns={ "/ui/*" })
public class ControllerServlet extends HttpServlet implements HasLogger {

    private static final long serialVersionUID = 6104432805391432953L;
    private final Map<String, IModel> models = new HashMap<>();
    
    @Inject @Any
    private Instance<Object> modelBeans;    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        logger().trace("ENTER service(request,response)");
        
        final String resource = request.getRequestURI().substring(request.getContextPath().length()).split("\\;")[0];
        final IModel model = models.get(resource);
        
        if (model != null) {
            final String view = model.handle(request, response);
            final Map<String,String> navigation = new HashMap<>();
            navigation.put(model.getNavigationName(), "active");
        
            request.setAttribute("navigation", navigation);

            request.getRequestDispatcher(view).forward(request, response);
            request.getSession().setAttribute("formId", UUID.randomUUID().toString());
        } else {
            request.setAttribute("ERROR", "Requested Page is invalid: ".concat(resource));
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }

        logger().trace("EXIT service(request,response)");
    }

    @Override
    public void init() throws ServletException {
        logger().trace("ENTER init()");
        
        // This could actually come from a Database
        try {
            models.put("/ui/home", createModel("ca.sait.mystore.web.mvc.model.HomeModel"));
            models.put("/ui/products", createModel("ca.sait.mystore.web.mvc.model.ProductsModel"));
            models.put("/ui/contactus", createModel("ca.sait.mystore.web.mvc.model.ContactUsModel"));
            models.put("/ui/aboutus", createModel("ca.sait.mystore.web.mvc.model.AboutUsModel"));
            models.put("/ui/register", createModel("ca.sait.mystore.web.mvc.model.RegisterModel"));
            models.put("/ui/shoppingcart", createModel("ca.sait.mystore.web.mvc.model.ShoppingCartModel"));
            
        } catch(final Exception ex) {
            throw new ServletException(ex);
        } finally {
            logger().trace("EXIT init()");
        }
    }
    
    /**
     * 
     * @param className
     * @param resource
     * @param displayName
     * @return
     * @throws Exception
     */
    private IModel createModel(String className)
    throws Exception {
        final Class<?> clazz = Class.forName(className);
        return (IModel)modelBeans.select(clazz).get();  
    }
}