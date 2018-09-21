/**
 * 
 */
package ca.sait.mystore.mvc.model.shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import ca.sait.mystore.entity.ShoppingCart;
import ca.sait.mystore.entity.ShoppingCartItem;
import ca.sait.mystore.mvc.model.ViewModel;

/**
 *
 */
@Model
public class ShoppingCartItemModel extends ViewModel {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private List<ShoppingCartItem> shoppingCartItems;
    private Product product;
    private String actionMessage;
    
    private String quantity;
    private String price;
    
    private ShoppingCart shoppingCart;
    private ShoppingCartItem shoppingCartItem;
    
    private Map<String, String> inputErrors = new HashMap<>();

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction transaction; // either create or reuse, here since filter create one, then here is reuse.

    @Inject
    private Validator validator;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("ENTER handle(request, response)");

        try {
            
            final String oid = request.getParameter("oid");
            if (oid != null && !oid.trim().isEmpty()) {
                final UUID uuid = UUID.fromString(oid);
                shoppingCartItem = entityManager.find(ShoppingCartItem.class, uuid);
                if (shoppingCartItem.getPrice() != 0)
                    price = Double.toString(shoppingCartItem.getPrice());
                
                if (shoppingCartItem.getQuantity() != 0)
                    quantity = Integer.toString(shoppingCartItem.getQuantity());
                
            } else {
                shoppingCartItem = new ShoppingCartItem();
            }

            final String action = request.getParameter("action");
            logger.debug("action: {}", action);

            if (action != null) {
                switch (action.toLowerCase()) {
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
        } catch (final Exception ex) {
            logger.error(ex.getMessage(), ex);
            actionMessage = ex.getMessage();

        } finally {
           
          if (transaction.getStatus() == Status.STATUS_ACTIVE && !inputErrors.isEmpty())
              transaction.setRollbackOnly();              

            logger.trace("EXIT handle(request, response)");
        }
    }

    private List<Product> retrieveAllProducts() {
        logger.trace("ENTER retrieveAllProducts()");

        final TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_ALL, Product.class);
        logger.trace("EXIT retrieveAllProducts()");
        return query.getResultList();        
    }

    private void update(HttpServletRequest request) {
        logger.trace("ENTER update(request)");

        final String shoppingCartOid = request.getParameter("shoppingCartOid");
        price = request.getParameter("price");
        quantity = request.getParameter("quantity");
        final String productName = request.getParameter("productName");

        shoppingCartItem.setShoppingCart(entityManager.find(ShoppingCart.class, shoppingCartOid));
        
        try {
        shoppingCartItem.setQuantity(Integer.parseInt(quantity));
        } catch ( final Exception ex) {
            inputErrors.put("quantity", quantity.concat(" invalid number"));
        }
        
        try {
            shoppingCartItem.setPrice(Double.parseDouble(price));
        } catch ( final Exception ex) {
            inputErrors.put("price", price.concat(" invalid price"));
        }
        
        shoppingCartItem.setProduct(entityManager.createNamedQuery(Product.FIND_BY_NAME, Product.class).setParameter("name", productName).getSingleResult());

        final Set<ConstraintViolation<ShoppingCartItem>> issues = validator.validate(shoppingCartItem);

        if (issues.isEmpty()) {

            if (shoppingCartItem.getOid() == null) {
                actionMessage = "Created New ShoppingCartItem";
                    entityManager.persist(shoppingCartItem);
                    shoppingCartItems.add(shoppingCartItem);
                    actionMessage = "Create New ShoppingCartItem";    
            } else {
                logger.debug("Updated OID: {}", shoppingCartItem.getOid().toString());
                actionMessage = "Updated ShoppingCartItem";
            }
        } else {
            issues.forEach(issue -> {
                final String attributeName = issue.getPropertyPath().toString();
                final String errorMsg = issue.getMessage();

                logger.debug("Attribute Name: {})", attributeName);
                logger.debug("Error Message: {})", errorMsg);

                inputErrors.put(attributeName, errorMsg);

            });

        }
        logger.trace("EXIT update(request)");
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public ShoppingCartItem getShoppingCartItem() {
        return shoppingCartItem;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    /**
     * @return the inputErros
     */
    public Map<String, String> getInputErrors() {
        return inputErrors;
    }

    public String getQuantity() {
        return quantity;
    }
    
    public String getPrice() {
        return price;
    }
    
    /**
     * @param inputErros
     *            the inputErros to set
     */
    public void setInputErrros(Map<String, String> inputErrors) {
        this.inputErrors = inputErrors;
    }
}
