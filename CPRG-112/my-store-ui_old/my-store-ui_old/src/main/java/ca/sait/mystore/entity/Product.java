package ca.sait.mystore.entity;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity(name="Product")// by default if don't put anything, then class name
@Table(name = "PRODUCT")
@NamedQueries( {@NamedQuery(name=Product.FIND_ALL, query="SELECT p FROM Product p ORDER BY p.productName")}) // Entity.anyName, query is jpql, jpql has alias everything, select p mean load all column of p
public class Product implements Serializable {
    
    public static final String FIND_ALL = "Product.FindAll";

    @Id
    @Column(name = "oid", insertable = true, updatable = false, nullable = false, columnDefinition = "CHAR(16) FOR BIT DATA")
    private UUID oid;

    @Column(name = "price", length = 10, precision = 2, nullable = true)
    private Double price;
    @Column(name = "product_name", nullable = false, length = 35, unique = true)
    private String productName;

    @Column(name = "description", nullable = false, length = 2048)
    private String description;

    @Column(name = "inventory_qty", length = 5, nullable = true)
    private Integer inventoryQty;

//    @Column(name = "image", nullable = true)
//    private Byte[] image;
    
    private static final long serialVersionUID = 1L;

    public Product() {
        super();
    }

    public UUID getOid() {
        return this.oid;
    }

    public void setOid(UUID oid) {
        this.oid = oid;
    }

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

//    public void setImage(Byte[] image) {
//        this.image = image;
//    }
    
    @PrePersist
    private void prePersist() {
        if (oid == null)
            oid = UUID.randomUUID(); // create and save
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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

}
