package ca.sait.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity(name="Product")
@Table(name = "PRODUCT")
@NamedQueries( {
    @NamedQuery(name=Product.FIND_ALL, query="SELECT p FROM Product p ORDER BY p.productName"),
    @NamedQuery(name=Product.FIND_BY_NAME, query="SELECT p FROM Product p WHERE p.productName = :name"),
})
public class Product extends AbstractEntity {

    private static final long serialVersionUID = 9050039555717703219L;
    public static final String FIND_ALL = "Product.FindAll";
    public static final String FIND_BY_NAME = "Product.FindByName";
    
    @Column(name="price", length=10, precision=2, nullable=true)
    private Double price;

    @NotNull
    @Size(min=5, max=35, message="Must be between 5 and 35 chars")
    @Column(name="product_name", nullable=false, length=35, unique=true, updatable=false)
    private String productName;
    
    @Size(min=100, max=2048, message="Must be between 100 and 2048 chars")
    @Column(name="description", nullable=true, length=2048)
    private String description;
    
    @Column(name="inventory_qty", length=5, nullable=true)
    private Integer inventoryQty;
    
//    @Column(name="image", nullable=true)
//    private Byte[] image;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInventoryQty() {
        return this.inventoryQty;
    }

    public void setInventoryQty(Integer inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

//    public Byte[] getImage() {
//        return this.image;
//    }
//
//    public void setImage(Byte[] image) {
//        this.image = image;
//    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
        Product other = (Product) obj;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return productName;
    }
}