package ca.sait.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ShoppingCartItem")
@Table(name = "CART_ITEM")
public class ShoppingCartItem extends AbstractEntity {

    private static final long serialVersionUID = 6283844515632820908L;

    @ManyToOne()
    @JoinColumn(name = "cart_oid", nullable=false)
    private ShoppingCart shoppingCart;

    @ManyToOne()
    @JoinColumn(name = "product_oid", nullable=false)
    private Product product;

    @Column(name = "quantity", length = 5)
    private int quantity;

    @Column(name = "price", length = 5, precision = 2)
    private double price;

    /**
     * @return the shoppingCart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @param shoppingCart
     *            the shoppingCart to set
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
        this.price = product.getPrice();
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
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
     * @param price
     *            the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}