/**
 * 
 */
package ca.sait.mystore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Chris Elias
 *
 */
public abstract class AbstractDAO<TYPE, ID> {

    private final Class<TYPE> entityClass;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * 
     * @param entityClass
     */
    protected AbstractDAO(final Class<TYPE> entityClass) {
        this.entityClass = entityClass;
    }
    
    /**
     * 
     * @return
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public TYPE find(ID id) {
        return entityManager.find(entityClass, id);
    }
    
    /**
     * 
     * @param entity
     */
    public void persist(TYPE entity) {
        entityManager.persist(entity);
    }
    
    /**
     * 
     * @param entity
     */
    public void delete(TYPE entity) {
        entityManager.remove(entity);
    }
    
}
