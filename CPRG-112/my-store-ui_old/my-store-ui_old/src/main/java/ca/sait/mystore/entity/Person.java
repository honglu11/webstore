package ca.sait.mystore.entity;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Person
 *
 */

public class Person implements Serializable {
    
  
    //@Id
    //@Column(name = "oid", insertable = true, updatable = false, nullable = false, columnDefinition = "CHAR(16) FOR BIT DATA")
    private UUID oid;
    
    // length = 35; not nullable
    // @Column(name = "first_name", length = 35, nullable = true)
    private String firstName;
    
    // length = 35; not nullable
    // @Column(name = "last_name", length = 35, nullable = true)
    private String lastName;
    
    // length = 128; not nullable, unique
    @Column(name = "last_name", length = 128, nullable = true, unique = true)
    private String email;
    
    // length = 16; not nullable
    // @Column(name = "last_name", length = 16, nullable = true)
    private String password;
    
    // length = 16; not nullable
    // @Column(name = "last_name", length = 16, nullable = true)
    private String role;
   

}
