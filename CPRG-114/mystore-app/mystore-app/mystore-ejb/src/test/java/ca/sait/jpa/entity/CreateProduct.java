/**
 * 
 */
package ca.sait.jpa.entity;

import org.junit.jupiter.api.Test;

import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.ProductDAO;
import ca.sait.mystore.dao.RoleDAO;
import ca.sait.mystore.entity.ProductEntity;

/**
 * @author celias
 *
 */
public class CreateProduct extends AbstractJPATest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            ProductEntity.class
        };
    }

    @Test
    public void create() {
        
        jpa(entityManager -> {

            final ProductEntity productEntity = new ProductEntity();
            
            productEntity.setName("computer");
            productEntity.setPrice(1000.11);
            productEntity.setDescription("work station");
            productEntity.setInventoryQuantity(2);

            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final ProductDAO dao = daoFactory.getProductDAO();
            dao.persist(productEntity);
        });
        
    }
    
    @Test
    public void create1() {
        
        jpa(entityManager -> {

            final ProductEntity productEntity = new ProductEntity();
            
            productEntity.setName("computer2");
            productEntity.setPrice(1288.11);
            productEntity.setDescription("work station 2");
            productEntity.setInventoryQuantity(4);

            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final ProductDAO dao = daoFactory.getProductDAO();
            dao.persist(productEntity);
        });
        
    }
}





