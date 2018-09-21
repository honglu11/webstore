/**
 * 
 */
package ca.sait.produce;

import java.util.UUID;

/**
 * 
 * @author Chris Elias
 */
public abstract class Product extends AbstractItem {

    private static long productCounter = 0;

    private final String sku = UUID.randomUUID().toString();
    
    /**
     * 
     */
    public Product(String name) {
        super(name);
    }

    /**
     * 
     * @return
     */
    public String getSKU() {
    	return sku;
    }
    
    @Override
    protected long getNextCounter() {
        return productCounter++;
    }
}
