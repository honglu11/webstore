package ca.sait.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Product")
@Table(name="product")
public class ProductEntity extends AbstractEntity {

    @Column(name="product_name", length=35, nullable=false)
    private String name;
    
    @Column(name="description", length=1024)
    private String description;
    
    @Column(name="price", length=10, precision=2)
    private Double price;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
