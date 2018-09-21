/**
 * 
 */
package ca.sait.mystore.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author honglu
 *
 */
@Stateless
@LocalBean
//using the factory create all the data access, inject data 
public class DAOManagerFactory {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public DAOManagerFactory() {
        
    }
    
    public DAOManagerFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public PersonDAO getPersonDAO() {
        return new PersonDAO(entityManager);
    }
    public ProductDAO getProductDAO() {
        return new ProductDAO(entityManager);
    }
    

}