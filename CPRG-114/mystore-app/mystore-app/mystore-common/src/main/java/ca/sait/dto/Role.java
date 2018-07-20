package ca.sait.dto;

import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */
@XmlRootElement(name="role")
public class Role {

    @XmlAttribute(name="oid")
    private final UUID oid;
    
    @XmlElement(name="name", required=true)
    private final String name;
    
    @XmlElement(name="description", required=false)
    private final String description;
    
    
    public Role() {
        this(null, null, null);
    }
    
    public Role(UUID oid, String name, String description) {
        this.oid = oid;
        this.name = name;
        this.description = description;
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Role other = (Role) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
