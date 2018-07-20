/**
 * 
 */
package ca.sait.mystore.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ca.sait.dto.Person;
import ca.sait.dto.Product;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.ProductEntity;

/**
 *
 */
public final class ProductDAO extends AbstractDAO<ProductEntity> {

    protected ProductDAO(final EntityManager entityManager) {
        super(entityManager, ProductEntity.class);
    }

    /**
     * 
     * @param id
     * @return
     */
    public Product findDTO(UUID id) {
        final TypedQuery<Product> query = 
                getEntityManager().createNamedQuery(ProductEntity.QUERY_DTO_FIND_BY_OID, Product.class);
        query.setParameter("oid", id);
        
        return query.getSingleResult();
    } 
    
    /**
     * 
     * @param email
     * @return
     */
    public ProductEntity findByName(String name) {
        final TypedQuery<ProductEntity> query = 
                getEntityManager().createNamedQuery(ProductEntity.QUERY_FIND_BY_NAME, ProductEntity.class);
        query.setParameter("name", name);
        
        return query.getSingleResult();
    }

    /**
     * 
     * @param email
     * @return
     */
    public Product findByNameDTO(String name) {
        final TypedQuery<Product> query = 
                getEntityManager().createNamedQuery(ProductEntity.QUERY_DTO_FIND_BY_NAME, Product.class);
        query.setParameter("name", name);
        
        return query.getSingleResult();
    }
    
    /**
     * 
     * @return
     */
    public List<Product> findAllDTO() {
        final TypedQuery<Product> query =  
                getEntityManager().createNamedQuery(ProductEntity.QUERY_DTO_FIND_ALL, Product.class);

        return query.getResultList();
    }
}