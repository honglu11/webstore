/**
 * 
 */
package ca.sait.mystore.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ca.sait.dto.Role;
import ca.sait.mystore.entity.RoleEntity;

/**
 *
 */
public final class RoleDAO extends AbstractDAO<RoleEntity> {

    protected RoleDAO(final EntityManager entityManager) {
        super(entityManager, RoleEntity.class);
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public Role findDTO(UUID id) {
        final TypedQuery<Role> query = 
                getEntityManager().createNamedQuery(RoleEntity.QUERY_DTO_FIND_BY_OID, Role.class);
        
        query.setParameter("oid", id);
        
        return query.getSingleResult();
    } 
    
    /**
     * 
     * @param name
     * @return
     */
    public RoleEntity findByName(String name) {
        final TypedQuery<RoleEntity> query = 
                getEntityManager().createNamedQuery(RoleEntity.QUERY_FIND_BY_NAME, RoleEntity.class);
        
        query.setParameter("name", name);
        
        return query.getSingleResult();
    }

    /**
     * 
     * @param name
     * @return
     */
    public Role findByNameDTO(String name) {
        final TypedQuery<Role> query = 
                getEntityManager().createNamedQuery(RoleEntity.QUERY_DTO_FIND_BY_NAME, Role.class);
        
        query.setParameter("name", name);
        
        return query.getSingleResult();
    }
    
    /**
     * 
     * @return
     */
    public List<Role> findAllDTO() {
        final TypedQuery<Role> query = 
                getEntityManager().createNamedQuery(RoleEntity.QUERY_DTO_FIND_ALL, Role.class);
        
        return query.getResultList();
    }
}