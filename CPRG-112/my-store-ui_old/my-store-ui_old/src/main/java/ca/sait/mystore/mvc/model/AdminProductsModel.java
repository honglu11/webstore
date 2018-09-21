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
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.mystore.entity.Product;

/**
 *
 */
@Model
public class AdminProductsModel extends ViewModel {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String title;

    private List<Product> products;
    private Product product;
    private String actionMessage;

    @PersistenceContext
    private EntityManager entityManager; // entityManager take care all query

    @Resource
    private UserTransaction transaction; // take care boundary

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        title = "Fancy Admin Products";
        logger.trace("ENTER handle(rquest, response)");
        try {
            retrieveAllProducts(); // when you only do the read, you don't need the transaction 
            transaction.begin(); // make sure transaction begin and end, this transaction is only specifica to
                                 // this model only
            
          final String oid = request.getParameter("oid");
          if (oid != null && !oid.trim().isEmpty()) {
              final UUID uuid = UUID.fromString(oid);
              product = entityManager.find(Product.class, uuid);
          } else {
              product = new Product();
          }
            
            final String action = request.getParameter("action");
            logger.debug("action:{}", action);

            if (action != null) {
                switch (action.toLowerCase()) {

                case "update":
                    update(request);
                    break;
                case "delete":
                    remove(request);
                    break;
                case "cancel":
                    //cancel(request);
                    break;
                default:
                    logger.warn("unknown action: {}", action);

                }
            }

        } catch (final Exception ex) {
            logger.error(ex.getMessage(), ex);
            actionMessage = ex.getMessage();
            return;
        } finally {
            try {
                transaction.commit();
            } catch (final Exception ex) {
                logger.error(ex.getMessage(), ex);
                try {
                    transaction.rollback();
                } catch (final Exception exRollback) {
                    logger.error(exRollback.getMessage(), exRollback);
                }
            }
        }

        logger.trace("EXIT handle(rquest, response)");

    }

    private void retrieveAllProducts() {
        logger.trace("ENTER retrieveAllProducts()");
        final TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_ALL, Product.class);
        products = query.getResultList();
        logger.trace("EXIT retrieveAllProducts()");
    }

    private void update(HttpServletRequest request) {
        logger.trace("ENTER update(HttpServletRequest request)");

//        final String oid = request.getParameter("oid");
//        if (oid != null && !oid.trim().isEmpty()) {
//            final UUID uuid = UUID.fromString(oid);
//            product = entityManager.find(Product.class, uuid);
//        } else {
//            product = new Product();
//        }

        final String productName = request.getParameter("productName");
        final String price = request.getParameter("price");
        final String invQuantity = request.getParameter("invQuantity");
        final String description = request.getParameter("description");

        product.setDescription(description);
        product.setInventoryQty(Integer.parseInt(invQuantity));
        product.setPrice(Double.parseDouble(price));
        product.setProductName(productName);

        if (product.getOid() == null) {
            // product.setOid(UUID.randomUUID());
            // logger.debug("Generated new OID: {}", product.getOid().toString());
            actionMessage = "Created New Product";
            entityManager.persist(product);// when persist, entityManager will look at prePersist annotation or any
                                           // annotation
        } else {
            // don't need entityManager to update it since transaction take care it.
            logger.debug("Update OID: {}", product.getOid().toString());
            actionMessage = "Updated Product";

        }

        logger.trace("EXIT update(HttpServletRequest request)");

    }

    private void remove(HttpServletRequest request) {
        logger.trace("ENTER remove(HttpServletRequest request)");

        final String oid = request.getParameter("oid");
        if (oid != null && !oid.trim().isEmpty()) {
            final UUID uuid = UUID.fromString(oid);
            product = entityManager.find(Product.class, uuid);
        }

        if (product.getOid() != null) {
            logger.debug("Remove OID: {}", product.getOid().toString());
            actionMessage = "Remove Product";
            entityManager.remove(product);
        } else {
            // don't need entityManager to update it since transaction take care it.
            logger.debug("product is not exisiting");
            actionMessage = "Cannot Remove None Existing Product";

        }

        logger.trace("EXIT remove(HttpServletRequest request)");

    }

    private void cancel(HttpServletRequest request) {
        logger.trace("ENTER cancel(HttpServletRequest request)");

        final String oid = request.getParameter("oid");
        if (oid != null && !oid.trim().isEmpty()) {
            final UUID uuid = UUID.fromString(oid);
            product = entityManager.find(Product.class, uuid);
        }

        if (product.getOid() != null) {
            logger.debug("Cancel Operation of OID: {}", product.getOid().toString());
            actionMessage = "Cancel Operation";
            entityManager.refresh(product);
        } else {
            // don't need entityManager to update it since transaction take care it.
            logger.debug("product is not exisiting");
            actionMessage = "Cannot Cancel";

        }

        logger.trace("EXIT cancel(HttpServletRequest request)");

    }

    public String getActionMessage() {
        return actionMessage;
    }

    public Product getProduct() {

        return product;

    }

    public List<Product> getProducts() {
        return products;

    }
}
