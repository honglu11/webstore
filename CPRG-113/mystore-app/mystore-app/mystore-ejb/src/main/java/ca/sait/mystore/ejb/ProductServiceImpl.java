/**
 * 
 */
package ca.sait.mystore.ejb;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import ca.sait.dto.Product;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.ProductEntity;
import ca.sait.services.NoEntityFoundException;
import ca.sait.services.PersonService;
import ca.sait.services.ProductService;

/**
 * @author honglu
 *
 */
@Stateless
@Local(ProductService.class)
public class ProductServiceImpl implements ProductService {

    @EJB
    private DAOManagerFactory daoFactory;

    // @PersistenceContext
    // private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see ca.sait.services.ProductService#create(ca.sait.dto.Product)
     */
    @Override
    public UUID create(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());

        daoFactory.getProductDAO().getEntityManager().persist(productEntity);

        return productEntity.getOid();

    }

    /*
     * (non-Javadoc)
     * 
     * @see ca.sait.services.ProductService#findByName(java.lang.String)
     */
    @Override
    public Product findByName(String name) throws NoEntityFoundException {
        try {
            return daoFactory.getProductDAO().findByNameDTO(name);
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No name: " + name);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see ca.sait.services.ProductService#findById(java.util.UUID)
     */
    @Override
    public Product findById(UUID id) throws NoEntityFoundException {
        try {
            return daoFactory.getProductDAO().findDTO(id);
        } catch (final NoResultException ex) {
            throw new NoEntityFoundException("No oid: " + id);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see ca.sait.services.ProductService#findAll()
     */
    @Override
    public List<Product> findAll() {
        return daoFactory.getProductDAO().findAllProduct();
    }

    @Override
    public void removeProduct(UUID id) throws NoEntityFoundException {
        ProductEntity productEntity = daoFactory.getProductDAO().find(id);
        if (productEntity == null)
            throw new NoEntityFoundException("No oid: " + id);
        daoFactory.getProductDAO().getEntityManager().remove(productEntity);
    }

}