/**
 * 
 */
package ca.sait.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chris Elias
 * @author Alberta Utility Billing
 */
@Entity(name="Role")
@Table(name="role")
@NamedQueries({
    @NamedQuery(name=RoleEntity.QUERY_DTO_FIND_BY_OID, query="SELECT " + RoleEntity.CONSTRUCT_PARAM + " FROM Role r WHERE r.oid = :oid"),
    @NamedQuery(name=RoleEntity.QUERY_DTO_FIND_BY_NAME, query="SELECT " + RoleEntity.CONSTRUCT_PARAM + " FROM Role r WHERE r.roleName = :name"),
    @NamedQuery(name=RoleEntity.QUERY_DTO_FIND_ALL, query="SELECT " + RoleEntity.CONSTRUCT_PARAM + " FROM Role r"),
    
    @NamedQuery(name=RoleEntity.QUERY_FIND_BY_OID, query="SELECT r FROM Role r WHERE r.oid = :oid"),
    @NamedQuery(name=RoleEntity.QUERY_FIND_BY_NAME, query="SELECT r FROM Role r WHERE r.roleName = :name"),
    @NamedQuery(name=RoleEntity.QUERY_FIND_ALL, query="SELECT r FROM Role r"),
})

public class RoleEntity extends AbstractEntity {

    public static final String QUERY_DTO_FIND_BY_OID = "RoleDTO.findByOid";
    public static final String QUERY_DTO_FIND_BY_NAME = "RoleDTO.findByName";
    public static final String QUERY_DTO_FIND_ALL = "RoleDTO.findAll";

    public static final String QUERY_FIND_BY_OID = "RoleEntity.findByOid";
    public static final String QUERY_FIND_BY_NAME = "RoleEntity.findByName";
    public static final String QUERY_FIND_ALL = "RoleEntity.findAll";

    protected static final String CONSTRUCT_PARAM =
            "new ca.sait.dto.Role( " +
            "   r.oid," +
            "   r.roleName," +
            "   r.description" +
            ")";

    
    @Column(name="role_name", length=15, unique=true, nullable=false, updatable=false)
    private String roleName;
    
    @Column(name="description", length=256, nullable=true)
    private String description;

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
}
