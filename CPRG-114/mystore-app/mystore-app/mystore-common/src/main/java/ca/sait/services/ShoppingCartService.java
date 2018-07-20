/**
 * 
 */
package ca.sait.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.NoResultException;

import ca.sait.dto.CartItem;
import ca.sait.dto.Person;
import ca.sait.dto.ShoppingCart;

/**
 * @param <ShoppingCartItemEntity>
 *
 */
public interface ShoppingCartService {
    
   public void cancel(UUID oid);
   
   public void complete(UUID oid);
   
   public void changeToOtherStatus(UUID oid, String status);

   public void checkout(String email, Set<CartItem> cartItem) throws NoEntityFoundException;
   
   public CartItem findById(UUID id) throws NoEntityFoundException;

   public List<CartItem> findByCart(ShoppingCart cart) throws NoEntityFoundException;

   public List<CartItem> findAll();
   
   public ShoppingCart findCartById(UUID id) throws NoEntityFoundException;

   public List<ShoppingCart> findAllCart();
}