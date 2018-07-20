/**
 * 
 */
package ca.sait.services;

import java.util.List;
import java.util.UUID;

import ca.sait.dto.Person;
import ca.sait.dto.Product;

/**
 *
 */
public interface ProductService {

    /**
     * 
     * @param product
     */
    public UUID create(Product product);
    
    /**
     * 
     * @param findByEmail
     */
    public Product findByName(String findByName) throws NoEntityFoundException;
    
    /**
     * 
     * @param id
     */
    public Product findById(UUID id) throws NoEntityFoundException;
    
    /**
     * 
     * @return
     */
    public List<Product> findAll();
    
    public void removeProduct(UUID id) throws NoEntityFoundException;
}
