package ca.sait.jpa.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;


import ca.sait.dto.Person;
import ca.sait.jpa.AbstractJPATest;
import ca.sait.mystore.dao.DAOManagerFactory;
import ca.sait.mystore.dao.PersonDAO;
import ca.sait.mystore.entity.PersonEntity;
import ca.sait.mystore.entity.RoleEntity;

public class TestPersonDao extends AbstractJPATest {

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
         
            
            final DAOManagerFactory daoFactory = new DAOManagerFactory(entityManager);
            final PersonDAO dao = daoFactory.getPersonDAO();
            final List<Person> persons = daoFactory.getPersonDAO().findAllDTO();
            logger().info("persons: {}", persons.get(0).getFirstName());
            logger().info("persons: {}", persons.get(1).getFirstName());
      
        });
        

        
        
    }
    
  
}

