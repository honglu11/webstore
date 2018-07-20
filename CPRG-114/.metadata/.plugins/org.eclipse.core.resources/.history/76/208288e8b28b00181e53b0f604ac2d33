/**
 * 
 */
package ca.sait.mystore.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import ca.sait.mystore.entity.AbstractEntity;

/**
 *
 */
public abstract class AbstractDAO<TYPE extends AbstractEntity> {

    private final Class<TYPE> entityClass;
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
    
    /**
     * 
     * @param entity
     */
    public void delete(TYPE entity) {
        entityManager.remove(entity);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
}
