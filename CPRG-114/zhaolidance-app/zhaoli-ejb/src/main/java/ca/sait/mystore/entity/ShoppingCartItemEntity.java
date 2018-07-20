/**
 * 
 */
package ca.sait.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris Elias
 * @author Alberta Utility Billing
 */
@Entity(name="ShoppingCartItem")
@Table(name="shopping_cart_tem")
public class ShoppingCartItemEntity extends AbstractEntity {

    @ManyToOne(optional=false)
    @JoinColumn(name="cart_oid", nullable=false, updatable=false)
    private ShoppingCartEntity cart;

    @ManyToOne(optional=false)
    @JoinColumn(name="product_oid", nullable=false, updatable=false)
    private ProductEntity product;
    
    @Column(name="quantity", nullable=false)
    private int quantity;

    @Column(name="price", nullable=false, length=10, precision=2)
    private double price;

    /**
     * @return the cart
     */
    public ShoppingCartEntity getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(ShoppingCartEntity cart) {
        this.cart = cart;
    }

    /**
     * @return the product
     */
    public ProductEntity getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
