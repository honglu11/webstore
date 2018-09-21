/**
 * 
 */
package ca.sait.mystore.mvc.model.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.mystore.entity.Product;
import ca.sait.mystore.mvc.model.ViewModel;

/**
 *
 */
@Model
public class AdminProductModel extends ViewModel {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    private List<Product> products;
    private Product product;
    private String actionMessage;
    
    private Map<String,String> inputErrors = new HashMap<>();
    
    @PersistenceContext
    private EntityManager entityManager;
   
    @Resource
    private UserTransaction transaction;
    
    @Inject
    private Validator validator;
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        logger.trace("ENTER handle(request, response)");
        
        try {
            retrieveAllProducts();
            
            transaction.begin();
            
            final String oid = request.getParameter("oid");
            if (oid != null && !oid.trim().isEmpty()) {
                final UUID uuid = UUID.fromString(oid);
                product = entityManager.find(Product.class, uuid);
            } else {
                product = new Product();
            }

            final String action = request.getParameter("action");
            logger.debug("action: {}", action);

            if (action != null) {
                switch(action.toLowerCase()) {
                case "update":
                    update(request);
                    break;
                case "delete":
                    break;
                case "cancel":
                    break;
                default:
                    logger.warn("Unknown action: {}", action);
                }
            }
        } catch(final Exception ex) {
            logger.error(ex.getMessage(), ex);
            actionMessage = ex.getMessage();
            return;
        } finally {
            try {
                if (transaction.getStatus() == Status.STATUS_ACTIVE && !inputErrors.isEmpty())
                    transaction.setRollbackOnly();
                
                if (transaction.getStatus() == Status.STATUS_ACTIVE )
                    transaction.commit();
                else if (transaction.getStatus() == Status.STATUS_MARKED_ROLLBACK)
                    transaction.rollback();
                
            } catch(final Exception ex) {
                logger.error(ex.getMessage(), ex);
                
                try {
                    transaction.rollback();
                } catch(final Exception exRollback) {
                    logger.error(exRollback.getMessage(), exRollback);
                }
            }
            
            logger.trace("EXIT handle(request, response)");
        }
    }
    
    private void retrieveAllProducts() {
        logger.trace("ENTER retrieveAllProducts()");
        
        final TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_ALL, Product.class);
        products = query.getResultList();
        
        logger.trace("EXIT retrieveAllProducts()");
    }
    
    private void update(HttpServletRequest request) 
    throws IllegalStateException, SystemException {
        logger.trace("ENTER update(request)");
        
        final String productName = request.getParameter("productName");
        final String price = request.getParameter("price");
        final String invQuantity = request.getParameter("invQuantity");
        final String description = request.getParameter("description");
        
        product.setDescription(description);
        product.setProductName(productName);
        
        try {
            product.setInventoryQty(Integer.parseInt(invQuantity));
        } catch(final Exception ex) {
            inputErrors.put("invQuantity", invQuantity.concat(" invalid number"));
        }
        
        try {
            product.setPrice(Double.parseDouble(price));
        } catch(final Exception ex) {
            inputErrors.put("price", price.concat(" invalid price"));
        }
        
        final Set<ConstraintViolation<Product>> issues = validator.validate(product);
        
        if (issues.isEmpty()) {
            if (product.getOid() == null ) {
                final TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_BY_NAME, Product.class);
                query.setParameter("name", product.getProductName());
                try {
                    query.getSingleResult();
                    inputErrors.put("productName", "Already Exists");
                    actionMessage = "Unable to created new product";
                } catch(final NoResultException ex) {
                    entityManager.persist(product);
                    actionMessage = "Created New Product";
                }
            } else { 
                logger.debug("Updated OID: {}", product.getOid().toString());
                actionMessage = "Updated Product";
            }
        } else {
            issues.forEach(issue -> {
                final String attributeName = issue.getPropertyPath().toString();
                final String errorMsg = issue.getMessage();
                
                logger.debug("Attribute Name: {}", attributeName);
                logger.debug("Error Msg: {}", errorMsg);
                
                inputErrors.put(attributeName, errorMsg);
            });
        }
        
        logger.trace("EXIT update(request)");
    }

    public Map<String, String> getInputErrors() {
        return inputErrors;
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



