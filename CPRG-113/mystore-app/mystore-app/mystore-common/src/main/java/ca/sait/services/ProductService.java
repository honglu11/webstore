/**
 * 
 */
package ca.sait.services;

import java.util.List;
import java.util.UUID;

import ca.sait.dto.Person;
import ca.sait.dto.Product;

/**
 * @author Hong Lu
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
     * @param findByName
     */
    public Product findByName(String name) throws NoEntityFoundException;
    
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
