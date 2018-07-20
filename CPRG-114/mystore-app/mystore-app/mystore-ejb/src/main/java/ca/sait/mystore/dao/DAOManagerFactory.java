/**
 * 
 */
package ca.sait.mystore.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
@Stateless
@LocalBean
public class DAOManagerFactory {

    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * 
     */
    public DAOManagerFactory() {
    }

    /**
     * 
     * @param entityManager
     */
    public DAOManagerFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * 
     * @return
     */
    public PersonDAO getPersonDAO() {
        return new PersonDAO(entityManager);
    }
    
    /**
     * 
     * @return
     */
    public ProductDAO getProductDAO() {
        return new ProductDAO(entityManager);
    }
    
    
    /**
     * 
     * @return
     */
    public RoleDAO getRoleDAO() {
        return new RoleDAO(entityManager);
    }
    
    /**
     * 
     * @return
     */
    public ShoppingCartDAO getShoppingCartDAO() {
        return new ShoppingCartDAO(entityManager);
    }
    
    /**
     * 
     * @return
     */
    public ShoppingCartItemDAO getShoppingCartItemDAO() {
        return new ShoppingCartItemDAO(entityManager);
    }
}
