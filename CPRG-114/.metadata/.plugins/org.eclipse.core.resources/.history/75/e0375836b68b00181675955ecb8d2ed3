/**
 * 
 */
package ca.sait.jpa.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import ca.sait.dto.Person;
import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.HasLogger;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.PersonDAO;
import ca.sait.mystore.ejb.PersonServiceImpl;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.RoleEntity;
import ca.sait.services.PersonService;

/**
 * @author Hong Lu
 * 
 */
public class TestPersonService extends AbstractJPATest {
    
   @Inject private PersonServiceImpl personService;
    
    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            PersonEntity.class,
            RoleEntity.class
        };
    }
    
    @Test
    public void testGetAllPerson() {
        
        jpa(entityManager -> {
         
            
            final List<Person> persons = personService.findAll();
            logger().info("persons: {}", persons.get(0).getFirstName());
            logger().info("persons: {}", persons.get(1).getFirstName());
      
        });
        

        
        
    }
    
    
//    @Test
//    public void testGetAllPerson() {
//                
//            
//            final List<Person> persons = personService.findAll();
//            logger().info("persons: {}", persons.get(0).getFirstName());
//            logger().info("persons: {}", persons.get(1).getFirstName());
//
//
//        
//        
//    }
    

}
