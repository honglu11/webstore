/**
 * 
 */
package ca.sait.mystore.dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ca.sait.dto.Person;
import ca.sait.mystore.entity.PersonEntity;

/**
 * @author celias
 *
 */
public class PersonDAO extends AbstractDAO<PersonEntity> {

    protected PersonDAO(final EntityManager entityManager) {
        super(entityManager, PersonEntity.class);
    }
    
    public Person findDTO(UUID id) {
        final TypedQuery<Person> query = getEntityManager().createNamedQuery(PersonEntity.QUERY_DTO_FIND_BY_OID, Person.class);
        query.setParameter("oid", id);
        return query.getSingleResult();
//        final PersonEntity entity = getEntityManager().find(PersonEntity.class, id);
//        final Person person = new Person(entity.getOid(), entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getBirthdate());
//        return person;
    }
    
    public PersonEntity findByOid(UUID id) {
        final TypedQuery<PersonEntity> query = getEntityManager().createNamedQuery(PersonEntity.QUERY_FIND_BY_OID, PersonEntity.class);
        query.setParameter("oid", id);
        return query.getSingleResult();
    }
    
    public PersonEntity findByEmail(String email) {
        final TypedQuery<PersonEntity> query = getEntityManager().createNamedQuery(PersonEntity.QUERY_FIND_BY_EMAIL, PersonEntity.class);
        query.setParameter("email", email);
        return query.getSingleResult();
  
    }
    
    public Person findByEmailDTO(String email) {
        final TypedQuery<Person> query = getEntityManager().createNamedQuery(PersonEntity.QUERY_DTO_FIND_BY_EMAIL, Person.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
    
    public List<Person> findAllPerson() {
        final TypedQuery<Person> query = getEntityManager().createNamedQuery(PersonEntity.QUERY_DTO_FIND_ALL, Person.class);
        return query.getResultList();
    }
    
    public List<PersonEntity> findAllPersonEntity() {
        final TypedQuery<PersonEntity> query = getEntityManager().createNamedQuery(PersonEntity.QUERY_FIND_ALL, PersonEntity.class);
        return query.getResultList();
    }
 
    
    
}
