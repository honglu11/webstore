/**
 * 
 */
package ca.sait.mystore.dao;

import java.util.UUID;

import ca.sait.dto.Person;
import ca.sait.mystore.entity.PersonEntity;

/**
 * @author celias
 *
 */
public class PersonDAO extends AbstractDAO<PersonEntity, UUID> {

    public PersonDAO() {
        super(PersonEntity.class);
    }
    
    public Person findDTO(UUID id) {
        return null;
    } 

    public PersonEntity findByEmail(String email) {
        return null;
    }

    public Person findByEmailDTO(String email) {
        return null;
    }

}
