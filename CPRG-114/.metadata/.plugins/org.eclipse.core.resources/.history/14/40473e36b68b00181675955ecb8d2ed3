/**
 * 
 */
package ca.sait.mystore.ejb;

import java.util.Date;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSContext;

import ca.sait.dto.CartStatus;
import ca.sait.event.SubmitCartEvent;
import ca.sait.mystore.HasLogger;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.entity.ProductEntity;
import ca.sait.mystore.entity.ShoppingCartEntity;

/**
 * @author Hong Lu
 * 
 */
@Stateless
@LocalBean
public class HandleCartEvents implements HasLogger {
    
    //@Inject private JMSContext context; // old way can use jms to send out Asyn
    @EJB private DAOManagerFactory daoFactory;
    
    @Asynchronous
    public void handleSubmitCart(@Observes SubmitCartEvent event) {
        
        logger().trace("ENTER handleSubmitCart(event)");
        logger().debug("Cart OID: {}", event.getCartOid().toString());
        
        final ShoppingCartEntity cart = daoFactory.getShoppingCartDAO().find(event.getCartOid());
        cart.getItems().forEach(item -> {
            final ProductEntity product = item.getProduct();
            final int newInventory = product.getInventoryQuantity() - item.getQuantity();
            product.setInventoryQuantity(newInventory);
        });
        
        cart.setShippedDate(new Date());
        cart.setStatus(CartStatus.BUILD);
        
        //context.createProducer().send(null, event.getCartOid().toString());
        
        logger().debug("EXIT handleSubmitCart(event)");
    }

}
