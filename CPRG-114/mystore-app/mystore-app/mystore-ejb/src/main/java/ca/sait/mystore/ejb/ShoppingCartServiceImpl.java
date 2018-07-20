/**
 * 
 */
package ca.sait.mystore.ejb;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import ca.sait.dto.CartItem;
import ca.sait.dto.CartStatus;
import ca.sait.dto.Person;
import ca.sait.dto.Product;
import ca.sait.dto.ShoppingCart;
import ca.sait.event.SubmitCartEvent;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.ProductDAO;
import ca.sait.mystore.dao.ShoppingCartDAO;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.ProductEntity;
import ca.sait.mystore.entity.ShoppingCartEntity;
import ca.sait.mystore.entity.ShoppingCartItemEntity;
import ca.sait.services.NoEntityFoundException;
import ca.sait.services.NonUniqueException;
import ca.sait.services.PersonService;
import ca.sait.services.ProductService;
import ca.sait.services.ShoppingCartService;
import ca.sait.services.ValidationException;
import ca.sait.util.HasLogger;

/**
 * @author Hong Lu
 *
 */
@Stateless
@Local(ShoppingCartService.class)
public class ShoppingCartServiceImpl implements ShoppingCartService, HasLogger {

    @EJB
    private DAOManagerFactory daoFactory;
    @EJB
    private PersonServiceImpl personService;
    @EJB
    private ProductServiceImpl productService;

    @Inject
    private Event<SubmitCartEvent> submitEvent;
    
    @Override
    public void cancel(UUID oid) {
        final ShoppingCartEntity cart = daoFactory.getShoppingCartDAO().find(oid);
        cart.getItems().forEach(item -> {
            final ProductEntity product = item.getProduct();
            final int newInventory = product.getInventoryQuantity() + item.getQuantity();
            product.setInventoryQuantity(newInventory);
        });
        cart.setStatus(CartStatus.CANCELLED);
    }
    
    @Override
    public void complete(UUID oid) {
        final ShoppingCartEntity cart = daoFactory.getShoppingCartDAO().find(oid);

        cart.setStatus(CartStatus.COMPLETED);
        cart.setShippedDate(new Date());
    }
    
    @Override
    public void changeToOtherStatus(UUID oid, String status) {
        final ShoppingCartEntity cart = daoFactory.getShoppingCartDAO().find(oid);

        cart.setStatus(CartStatus.valueOf(status));
    }

    @Override
    public void checkout(String email, Set<CartItem> cartItems) throws NoEntityFoundException {
        logger().trace("ENTER checkout(String email, Set<CartItem> cartItem)");
        final ShoppingCartEntity cartEntity = new ShoppingCartEntity();
        final PersonEntity customer = personService.findEntityByEmail(email);

        cartEntity.setShoppingDate(new Date());
        cartEntity.setCustomer(customer);

        cartItems.forEach(item -> {
            logger().debug("Item: {}", item);
            final ShoppingCartItemEntity cartItemEntity = new ShoppingCartItemEntity();
            cartItemEntity.setCart(cartEntity);
            cartItemEntity.setPrice(item.getPrice());

            final ProductEntity productEntity = productService.findEntityById(item.getProduct().getOid());
            cartItemEntity.setProduct(productEntity);
            cartItemEntity.setQuantity(item.getQuantity());

        });

        cartEntity.setStatus(CartStatus.SUBMITTED);
        daoFactory.getShoppingCartDAO().persist(cartEntity); // when save the parent cartEntity, child cartItemEntity
                                                             // save as well.

        submitEvent.fire(new SubmitCartEvent(cartEntity.getOid()));

        logger().trace("EXIT checkout(String email, Set<CartItem> cartItem)");

    }

    @Override
    public CartItem findById(UUID id) throws NoEntityFoundException {
        try {
            return daoFactory.getShoppingCartItemDAO().findDTO(id);
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No oid: " + id.toString());
        }
    }

    @Override
    public List<CartItem> findByCart(ShoppingCart cart) throws NoEntityFoundException {
        logger().trace("ENTER findByCart(ShoppingCart cart)");
        try {
            logger().debug(
                    "daoFactory.getShoppingCartItemDAO().findDTOByCart(daoFactory.getShoppingCartDAO().findEntityById(cart.getOid())) {}",
                    daoFactory.getShoppingCartItemDAO()
                            .findDTOByCart(daoFactory.getShoppingCartDAO().findEntityById(cart.getOid())));
            return daoFactory.getShoppingCartItemDAO()
                    .findDTOByCart(daoFactory.getShoppingCartDAO().findEntityById(cart.getOid()));
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No cart: " + cart.toString());
        } finally {
            logger().trace("EXIT findByCart(ShoppingCart cart)");
        }
    }

    public ShoppingCartItemEntity findEntityById(UUID id) throws NoEntityFoundException {
        try {
            return daoFactory.getShoppingCartItemDAO().findEntityById(id);
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No oid: " + id.toString());
        }
    }

    @Override
    public List<CartItem> findAll() {
        return daoFactory.getShoppingCartItemDAO().findAllDTO();
    }

    @Override
    public ShoppingCart findCartById(UUID id) throws NoEntityFoundException {
        try {
            return daoFactory.getShoppingCartDAO().findDTO(id);
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No oid: " + id.toString());
        }
    }

    public ShoppingCartEntity findCartEntityById(UUID id) throws NoEntityFoundException {
        try {
            return daoFactory.getShoppingCartDAO().findEntityById(id);
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No oid: " + id.toString());
        }
    }

    @Override
    public List<ShoppingCart> findAllCart() {
        return daoFactory.getShoppingCartDAO().findAllDTO();
    }

}