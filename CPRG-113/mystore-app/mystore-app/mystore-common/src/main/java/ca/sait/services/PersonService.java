/**
 * 
 */
package ca.sait.services;

import java.util.List;
import java.util.UUID;

import ca.sait.dto.Person;

/**
 * @author Chris Elias
 *
 */
public interface PersonService {

    /**
     * 
     * @param person
     */
    public UUID create(Person person);
    
    /**
     * 
     * @param findByEmail
     */
    public Person findByEmail(String findByEmail) throws NoEntityFoundException;
    
    /**
     * 
     * @param id
     */
    public Person findById(UUID id) throws NoEntityFoundException;
    
    /**
     * 
     * @return
     */
    public List<Person> findAll();
    
    public void removePerson(UUID id) throws NoEntityFoundException;
}
