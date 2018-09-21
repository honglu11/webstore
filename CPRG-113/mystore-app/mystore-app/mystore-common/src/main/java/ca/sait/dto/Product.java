package ca.sait.dto;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//immutable object since very attribute is final
@XmlRootElement(name="product")
public class Product {
    
    @XmlAttribute(name="oid")
    private final UUID oid;

    @XmlElement(name="name", required=true, nillable = false)
    private final String name;
    @XmlElement
    final String description;
    @XmlElement
    private final Double price;
    
    public Product() {
        this(null, null, null, null);
    }

    public Product(UUID oid, String name, String description, 
            Double price ) {
        this.oid = oid;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * @return the oid
     */
    public UUID getOid() {
        return oid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

}
