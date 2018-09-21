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
 * @author celias
 *
 */
public class ProductDAO extends AbstractDAO<ProductEntity> {

    public ProductDAO(final EntityManager entityManager) {
        super(entityManager, ProductEntity.class);
    }
    
    public Product findDTO(UUID id) {
        final TypedQuery<Product> query = getEntityManager().createNamedQuery(ProductEntity.QUERY_DTO_FIND_BY_OID, Product.class);
        query.setParameter("oid", id);
        return query.getSingleResult();
    }
    
    public ProductEntity findByName(String name) {
        final TypedQuery<ProductEntity> query = getEntityManager().createNamedQuery(ProductEntity.QUERY_FIND_BY_NAME, ProductEntity.class);
        query.setParameter("name", name);
        return query.getSingleResult();
  
    }
    
    public Product findByNameDTO(String name) {
        final TypedQuery<Product> query = getEntityManager().createNamedQuery(ProductEntity.QUERY_DTO_FIND_BY_NAME, Product.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    
    public List<Product> findAllProduct() {
        final TypedQuery<Product> query = getEntityManager().createNamedQuery(ProductEntity.QUERY_DTO_FIND_ALL, Product.class);
        return query.getResultList();
    }
    
    public List<ProductEntity> findAllProductEntity() {
        final TypedQuery<ProductEntity> query = getEntityManager().createNamedQuery(ProductEntity.QUERY_FIND_ALL, ProductEntity.class);
        return query.getResultList();
    }
 
}