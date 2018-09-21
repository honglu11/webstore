/**
 * 
 */
package ca.sait.mystore.ejb;

import java.util.List;
import java.util.UUID;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ca.sait.dto.Person;
import ca.sait.mystore.dao.PersonDAO;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.services.PersonService;

/**
 * @author Chris Elias
 *
 */
@Stateless
@Local(PersonService.class)
public class PersonServiceImpl 
implements PersonService {

    @Inject
    private PersonDAO personDAO;
    
    /* (non-Javadoc)
     * @see ca.sait.services.PersonService#create(ca.sait.dto.Person)
     */
    @Override
    public UUID create(Person person) {
        final PersonEntity entity = new PersonEntity();
        entity.setBirthdate(person.getBirthdate());
        entity.setEmail(person.getEmail());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        
        personDAO.persist(entity);

        return entity.getOid();
    }

    /* (non-Javadoc)
     * @see ca.sait.services.PersonService#findByEmail(java.lang.String)
     */
    @Override
    public Person findByEmail(String findByEmail) {
        return null;
    }

    /* (non-Javadoc)
     * @see ca.sait.services.PersonService#findById(java.util.UUID)
     */
    @Override
    public Person findById(UUID id) {
         return null;
    }

    /* (non-Javadoc)
     * @see ca.sait.services.PersonService#findAll()
     */
    @Override
    public List<Person> findAll() {
        return null;
    }
}