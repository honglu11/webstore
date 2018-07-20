/**
 * 
 */
package ca.sait.mystore.admin.mvc.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.dto.CartItem;
import ca.sait.dto.CartStatus;
import ca.sait.dto.Product;
import ca.sait.dto.ShoppingCart;

import ca.sait.services.NoEntityFoundException;
import ca.sait.services.NonUniqueException;
import ca.sait.services.ProductService;
import ca.sait.services.ShoppingCartService;
import ca.sait.services.ValidationException;

/**
 *
 */
@Model
public class ShoppingCartModel extends AbstractModel {
    private final Map<CartItem, CartItem> items = new LinkedHashMap<>(); 
    
    @Inject private ShoppingCartService shoppingCartService;  
    @Inject private ProductService productService; 
    private ShoppingCart cart;
    private List<CartItem> itemsByCart;

    /* (non-Javadoc)
     * @see ca.sait.mystore.web.mvc.model.AbstractView#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected String process(HttpServletRequest request, HttpServletResponse response) {
        logger().trace("ENTER process(request,resposne)");
        
        try {
            final Optional<String> optAction = Optional.ofNullable(request.getParameter("action"));
            final String action = optAction.orElse("").toUpperCase();
            final Optional<String> optStatus = Optional.ofNullable(request.getParameter("status"));
            final String status = optStatus.orElse("").toUpperCase();
            
            logger().debug("action {}", action);
            logger().debug("status {}", status);
            
            if ( "COMPLETED".equals(status)) {
                try {
                    complete(request);
                    setSuccessMessage("Your order is Completed.");
                } catch (ServletException e) {
                    setErrorMessage("Your order cannot be Completed."); 
                }
            } else if ("CANCELLED".equals(status)) {
                try {
                    cancel(request);
                    setSuccessMessage("Your order is Cancelled.");
                } catch (ServletException e) {
                    setErrorMessage("Your order cannot be Canceled."); 
                }
            } else {
//                try {
//                   changeToOtherStatus(request);
//                } catch (ServletException e) {
//                    setErrorMessage("Cannot change the status."); 
//                }

            }
            
            switch(action) {
            case "COMPLETE": {
                try {
                    complete(request);
                    setSuccessMessage("Your order is Completed.");
                } catch (ServletException e) {
                    setErrorMessage("Your order cannot be Completed."); 
                }
                break;
            }
            case "CANCEL": {
                try {
                    cancel(request);
                    setSuccessMessage("Your order is Cancelled.");
                } catch (ServletException e) {
                    setErrorMessage("Your order cannot be Canceled."); 
                }
                break;
            }
          }
            
            return "/WEB-INF/jsp/carts.jsp";
        } finally {
            logger().trace("EXIT process(request,resposne)");
        }
    }
    
    public void changeToOtherStatus(HttpServletRequest request) throws ServletException {
        logger().trace("ENTER changeStatus(HttpServletRequest request)");
        final String oid = request.getParameter("oid");
        final Optional<String> optStatus = Optional.ofNullable(request.getParameter("status"));
        final String status = optStatus.orElse("").toUpperCase();

        logger().debug("oid {}", oid);
        if ( oid != null ) {
            shoppingCartService.changeToOtherStatus(UUID.fromString(oid), status);
        }
           
        logger().trace("EXIT changeStatus(HttpServletRequest request)");
      
    }
    
    public void complete(HttpServletRequest request) throws ServletException {
        logger().trace("ENTER complete(HttpServletRequest request)");
        final String oid = request.getParameter("oid");

        logger().debug("oid {}", oid);
        if ( oid != null ) {
            shoppingCartService.complete(UUID.fromString(oid));
        }
           
        logger().trace("EXIT complete(HttpServletRequest request)");
      
    }
    
    public void cancel(HttpServletRequest request) throws ServletException {
        logger().trace("ENTER cancel(HttpServletRequest request)"); 
        final String oid = request.getParameter("oid");
        logger().debug("oid {}", oid);

        if ( oid != null ) {
            shoppingCartService.cancel(UUID.fromString(oid));
        }        

        logger().trace("EXIT cancel(HttpServletRequest request)");    
      }

    @Override
    public String getNavigationName() {
        return "CARTS";
    }
    
    public List<CartItem> getAllItems() {
        return shoppingCartService.findAll();
    }
    
    public List<ShoppingCart> getAllCarts() {
        return shoppingCartService.findAllCart();
    }   
    
    
    public ShoppingCart getCart() {
        if (getOid() != null && cart ==null) {                   
            try {
               cart =  shoppingCartService.findCartById(getOid());
            } catch (NoEntityFoundException ex) {
               setErrorMessage("Entity not found: " + getOid());
            }
        }
        
        return cart;  
        
    }
    
    public List<CartItem> getItemsByCart() {
        logger().trace("ENTER getItemsByCart()");
        logger().debug("getCart()", getCart());
        if (getCart() != null) {                   
            try {
               itemsByCart =  shoppingCartService.findByCart(getCart());
               logger().debug("itemsByCart {}", itemsByCart);
            } catch (NoEntityFoundException ex) {
                logger().warn("Entity not found: " + getCart());
               setErrorMessage("Entity not found: " + getCart());
            }
        } else {
            return null;
        }
        logger().debug("getCart()", getCart().getOid());
        logger().trace("EXIT getItemsByCart()");
        return itemsByCart;

    }

    /**
     * @return the items
     */
    public Set<CartItem> getItems() {
        return items.keySet();
    }
    
}
