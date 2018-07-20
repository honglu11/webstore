package ca.sait.mystore.admin.http.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.mystore.admin.mvc.model.IModel;
import ca.sait.util.HasLogger;

/**
 * 
 */
@WebServlet(name = "ControllerServlet", urlPatterns = { "/ui/*" })
public class ControllerServlet extends HttpServlet implements HasLogger {

    private static final long serialVersionUID = 6104432805391432953L;
    private final Map<String, IModel> models = new HashMap<>();

    @Inject
    @Any
    private Instance<Object> modelBeans; // create an instance of one the model, dynamic create instance

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger().trace("ENTER service(request,response)");

        final String resource = request.getRequestURI().substring(request.getContextPath().length()).split("\\;")[0];
        logger().debug("Resource: {}", resource);
        final IModel model;
        final String baseUri;

        if (models.containsKey(resource)) {
            model = models.get(resource); // resource is url
            baseUri = resource;
        } else {
            final Optional<String> key = models.keySet().stream().filter(uri -> resource.startsWith(uri)).findFirst();
            baseUri = key.orElse("NOT_FOUND"); // TODO: Create a model to handle not found
            // model = models.get(key.orElse(""));
            model = models.get(baseUri);

            if (!baseUri.equals("NOT_FOUND")) {

                final String resourceId = resource.substring(baseUri.length() + 1).split("/")[0];
                // http://localhost:8180/mystore-admin/ui/products/73f083d3-816b-4984-b524-b42c55b52ed2/add,
                // substring(baseUri.length() + 1) remove ui/products/, then split by / get oid
                try {
                    model.setOid(UUID.fromString(resourceId));
                } catch (final IllegalArgumentException ex) {
                    model.setErrorMessage("Invalid Object ID");
                }
            }
        }

        if (model != null) {
            logger().debug("Start");
            final String view = model.handle(request, response);
            logger().debug("End");
            final Map<String, String> navigation = new HashMap<>();
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
            models.put("NOT_FOUND", createModel("ca.sait.mystore.admin.mvc.model.PageNotFoundModel"));
            models.put("/ui/persons", createModel("ca.sait.mystore.admin.mvc.model.PersonsModel"));
            models.put("/ui/products", createModel("ca.sait.mystore.admin.mvc.model.ProductsModel"));
            models.put("/ui/carts", createModel("ca.sait.mystore.admin.mvc.model.ShoppingCartModel"));

        } catch (final Exception ex) {
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
    private IModel createModel(String className) throws Exception {
        final Class<?> clazz = Class.forName(className);
        return (IModel) modelBeans.select(clazz).get();
    }
}