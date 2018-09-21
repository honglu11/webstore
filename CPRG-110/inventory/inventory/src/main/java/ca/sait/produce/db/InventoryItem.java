/**
 *
 */
package ca.sait.produce.db;

import ca.sait.cli.ValidationException;
import ca.sait.produce.Item;

/**
 * This is the wrapper class that goes around the item to be stored
 * in the database.  This holds the item and the quanitity of items
 * 
 * @author 
 * @version 1.0
 */
public class InventoryItem {

    private final Item item;
    private int quantity;
    
    public InventoryItem(final Item item, int initialQuantity) {
        this.item = item;
        this.quantity = initialQuantity;
    }

    /**
     * 
     * @param quantity
     */
    public void addQuantity(int newQuantity)
    throws ValidationException {
        if (newQuantity < 0) {
            removeQuantity(newQuantity*-1);
        } else {
            this.quantity += newQuantity;
        }
    }

    /**
     * 
     * @param quantity
     */
    public void removeQuantity(int newQuantity)
    throws ValidationException {
        if (0 > quantity - newQuantity) {
            throw new ValidationException("Negative Inventory");
        }
        
        this.quantity -= newQuantity;
    }
    
    public Item getItem() {
        return item;
    }
    
    public int getQuantity() {
        return quantity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.toString().hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        InventoryItem other = (InventoryItem) obj;
        if (item == null) {
            if (other.item != null)
                return false;
            
        } else if (!item.toString().equals(other.item.toString()))
            return false;
        
        return true;
    }
    
    @Override
    public String toString() {
        return item.toString() + " - Quantity: " + quantity;
    }
}
