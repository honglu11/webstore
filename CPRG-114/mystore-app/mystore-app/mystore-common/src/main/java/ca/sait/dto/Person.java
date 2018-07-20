package ca.sait.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *
 */
@XmlRootElement(name="person")
public class Person {

    @XmlAttribute(name="oid")
    private final UUID oid;
    
    @XmlElement(name="firstName", required=true)
    private final String firstName;
    
    @XmlElement(name="lastName", required=true)
    private final String lastName;
    
    @XmlElement(name="email", required=true)
    private final String email;
    
    @XmlElement(name="birthdate", required=false)
    private final Date birthdate;
    
    @XmlElement(name="password")
    private String password;  
    
    @XmlElement(name="role")
    private final List<String> roles = new ArrayList<>();
 
    public Person() {
        this(null, null, null, null, null, null);
    }
    
    public Person(UUID oid, String firstName, String lastName, 
            String email, String password, Date birthdate ) {
        this.oid = oid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        
    }

    /**
     * @return the oid
     */
    public UUID getOid() {
        return oid;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    public List<String> getRoles() {
        return roles;
    }


}