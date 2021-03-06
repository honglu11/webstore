/**
 * 
 */
package ca.sait.mystore.mvc.model;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.mystore.entity.Product;

/**
 *
 */
@Model
public class ProductListModel extends ViewModel {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String title;
    private Boolean hasResults;
    private List<Product> products;
    private Product product;

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction transaction;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("ENTER handle(request, response)");
        title = "Fancy Product List";

        try {
            retrieveAllProducts();

            if (products.isEmpty()) {
                hasResults = false;
            } else {
                hasResults = true;
            }
        } catch (final Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {

            if (transaction.getStatus() == Status.STATUS_ACTIVE)
                transaction.setRollbackOnly();

            logger.trace("EXIT handle(request, response)");
        }
    }

    public Boolean getHasResults() {
        return hasResults;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public Product getProduct() {
        return product;
    }

    private void retrieveAllProducts() {
        logger.trace("ENTER retrieveAllProducts()");

        final TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_ALL, Product.class);
        products = query.getResultList();

        logger.trace("EXIT retrieveAllProducts()");
    }
}