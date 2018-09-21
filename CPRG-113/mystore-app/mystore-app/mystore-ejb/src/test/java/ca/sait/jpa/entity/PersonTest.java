/**
 * 
 */
package ca.sait.jpa.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import ca.sait.dto.Person;
import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.PersonDAO;
import ca.sait.mystore.entity.PersonEntity;
import junit.framework.Assert;

/**
 * @author celias
 *
 */
public class PersonTest extends AbstractJPATest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            PersonEntity.class
        };
    }

    @Test
    public void create() {
        jpa(entityManager -> {
            final PersonEntity entity = new PersonEntity();
            entity.setBirthdate(new Date());
            entity.setFirstName("chris");
            entity.setLastName("Elias");
            
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            // final PersonDAO dao = new PersonDAO(entityManager);     // change to protected, cannot use in test case
            final UUID uuid = dao.persist(entity);
            // final UUID u = entity.getOid();
            final Person p = dao.findDTO(uuid);
            
            logger().info("Person {}",  p.getFirstName());
        });
    }
    
    @Test
    public void findPersonByEmail() {
        jpa(entityManager -> {
            final PersonEntity entity = new PersonEntity();
            entity.setBirthdate(new Date());
            entity.setFirstName("Hong");
            entity.setLastName("Lu");
            final String email = "honglu@hotmail.com";
            entity.setEmail(email);
            
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            final UUID uuid = dao.persist(entity);

            final Person p = dao.findByEmailDTO(email);
            final PersonEntity pEntity = dao.findByEmail(email);
            
            logger().info("Person {}",  p.getEmail());
            logger().info("PersonEnity {}",  pEntity.getEmail());
        });        
    }  
  
    @Test
    public void findAll() {
        cleanupDatabase();
        jpa(entityManager -> {
            final List<Person> originalList = new ArrayList<>();
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
               
            for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int randomInt = random.nextInt();
            final PersonEntity entity = new PersonEntity();
            
            entity.setBirthdate(new Date());
            entity.setFirstName("Hong" + randomInt);
            entity.setLastName("Lu" + randomInt);
            final String email = "honglu@hotmail.com" + randomInt;
            entity.setEmail(email);            
            
            final PersonDAO dao = daoFactory.getPersonDAO();
            final UUID uuid = dao.persist(entity);
            originalList.add(dao.findDTO(uuid));
            }
            
            List<Person> persons = new ArrayList<>();
            persons = daoFactory.getPersonDAO().findAllPerson();
            
            Assert.assertEquals(originalList.size(), persons.size());
   
        });        
    }  
    
    private void cleanupDatabase() {
        jpa(entityManager -> {
         final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
         List<PersonEntity> persons = daoFactory.getPersonDAO().findAllPersonEntity();
         for(PersonEntity p : persons) {
             entityManager.remove(p);
         }
        });
    }
    

}






