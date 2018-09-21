/**
 * 
 */
package ca.sait.mystore.dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ca.sait.mystore.entity.AbstractEntity;

/**
 * @author Chris Elias
 *
 */
//public abstract class AbstractDAO<TYPE, ID>
public abstract class AbstractDAO<TYPE extends AbstractEntity> {

    private final Class<TYPE> entityClass;
    
    //@PersistenceContext cannot use @Inject not work application server
    private final EntityManager entityManager;

    /**
     * 
     * @param entityClass
     */
    protected AbstractDAO(EntityManager entityManager, final Class<TYPE> entityClass) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }
    
    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
//    /**
//     * 
//     * @param id
//     * @return
//     */
//    public TYPE find(ID id) {
//        return entityManager.find(entityClass, id);
//    }
//    
//    /**
//     * 
//     * @param entity
//     */
//    public void persist(TYPE entity) {
//        entityManager.persist(entity);
//    }
    
    /**
     * 
     * @param id
     * @return
     */
    public TYPE find(UUID id) {
        return entityManager.find(entityClass, id);
    }
    
    /**
     * 
     * @param entity
     */
    public UUID persist(TYPE entity) {
        entity.setCreatedBy("");
        entityManager.persist(entity);
        return entity.getOid();
    }
    
    public void delete(TYPE entity) {
        entityManager.remove(entity);
    }
    
}
