/**
 * 
 */
package ca.sait.mystore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Chris Elias
 *
 */
@Entity(name="Person")
@Table(name="person")
@NamedQueries({
    @NamedQuery(name="PersonDTO.findByOid", query="SELECT " + PersonEntity.CONSTRUCT_PARAM + " FROM Person p WHERE p.oid = :oid"),
    @NamedQuery(name="PersonDTO.findByEmail", query="SELECT " + PersonEntity.CONSTRUCT_PARAM + " FROM Person p WHERE p.email = :email"),
    @NamedQuery(name="PersonDTO.findAll", query="SELECT " + PersonEntity.CONSTRUCT_PARAM + " FROM Person p"),
    
    @NamedQuery(name="Person.findByOid", query="SELECT p FROM Person p WHERE p.oid = :oid"),
    @NamedQuery(name="Person.findByEmail", query="SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name="Person.findAll", query="SELECT p FROM Person p"),
})
public class PersonEntity extends AbstractEntity {

    public static final String QUERY_DTO_FIND_BY_OID = "PersonDTO.findByOid";
    public static final String QUERY_DTO_FIND_BY_EMAIL = "PersonDTO.findByEmail";
    public static final String QUERY_DTO_FIND_ALL = "PersonDTO.findAll";

    public static final String QUERY_FIND_BY_OID = "Person.findByOid";
    public static final String QUERY_FIND_BY_EMAIL = "Person.findByEmail";
    public static final String QUERY_FIND_ALL = "Person.findAll";

    protected static final String CONSTRUCT_PARAM =
            "new ca.sait.dto.Person( " +
            "   p.oid," +
            "   p.firstName," +
            "   p.lastName," +
            "   p.email," +
            "   p.birthdate" +
            ")";
    
    
    @Column(name="first_name", length=40)
    private String firstName;
    
    @Column(name="last_name", length=40)
    private String lastName;
    
    @Column(name="email", length=128, unique=true)
    private String email;
    
    @Temporal(TemporalType.DATE)
    @Column(name="birthdate")
    private Date birthdate;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    
    
}
