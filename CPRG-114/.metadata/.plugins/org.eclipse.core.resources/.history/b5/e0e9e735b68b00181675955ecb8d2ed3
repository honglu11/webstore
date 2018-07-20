/**
 * 
 */
package ca.sait.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


/**
 * @author Hong Lu
 * 
 */
public final class CartItem implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7420850447199511738L;

    private UUID oid;   

    private ShoppingCart cart;  

    private final Product product;
    private int quantity;
    private final double price;

    public CartItem(UUID oid, ShoppingCart cart, Product product, int quantity, double price) {
        this.oid = oid;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public CartItem(Product product, double price) {
        this.product = product;
        this.price = price;
    }
    
    public CartItem(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public CartItem addQuantity(final int quantity) {
        this.quantity += quantity;
        return this;
    }
    
    /**
     * @return the oid
     */
    public UUID getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(UUID oid) {
        this.oid = oid;
    }
       
    /**
     * @return the cart
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, price);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) return false;
        if (obj.getClass() != CartItem.class) return false;
        final CartItem other = (CartItem)obj;
        
        return Objects.equals(product, other.product) && Objects.equals(price, other.price);
    }
    
    @Override // a way to duplicate the object
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); // a way to hacker the clone, not allow clone
    }
    
    @Override
    public String toString() {
        
        return getProduct().getName().concat(":".concat(product.getPrice().toString()));
    }

}
