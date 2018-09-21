package ca.sait.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Product")
@Table(name="product")
@NamedQueries({
    @NamedQuery(name=ProductEntity.QUERY_DTO_FIND_BY_OID, query="SELECT " + ProductEntity.CONSTRUCT_PARAM + " FROM Product p WHERE p.oid = :oid"),
    @NamedQuery(name=ProductEntity.QUERY_DTO_FIND_BY_NAME, query="SELECT " + ProductEntity.CONSTRUCT_PARAM + " FROM Product p WHERE p.name = :name"),
    @NamedQuery(name=ProductEntity.QUERY_DTO_FIND_ALL, query="SELECT " + ProductEntity.CONSTRUCT_PARAM + " FROM Product p"),
    
    @NamedQuery(name=ProductEntity.QUERY_FIND_BY_OID, query="SELECT p FROM Product p WHERE p.oid = :oid"),
    @NamedQuery(name=ProductEntity.QUERY_FIND_BY_NAME, query="SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name=ProductEntity.QUERY_FIND_ALL, query="SELECT p FROM Product p"),
})
public class ProductEntity extends AbstractEntity {
    
    public static final String QUERY_DTO_FIND_BY_OID = "ProductDTO.findByOid";
    public static final String QUERY_DTO_FIND_BY_NAME = "ProductDTO.findByName";
    public static final String QUERY_DTO_FIND_ALL = "ProductDTO.findAll";

    public static final String QUERY_FIND_BY_OID = "ProductEntity.findByOid";
    public static final String QUERY_FIND_BY_NAME = "ProductEntity.findByName";
    public static final String QUERY_FIND_ALL = "ProductEntity.findAll";

    protected static final String CONSTRUCT_PARAM =
            "new ca.sait.dto.Product( " +
            "   p.oid," +
            "   p.name," +
            "   p.description," +
            "   p.price" +
            ")";
    
    @Column(name="product_name", length = 35, nullable=false)
    private String name;
    
    @Column(name="description", length = 1024)
    private String description;
    
    @Column(name="price", length = 10, precision=2)
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    

}
