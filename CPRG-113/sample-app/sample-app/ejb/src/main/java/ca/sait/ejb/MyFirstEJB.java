package ca.sait.ejb;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.business.MyFirst;
import ca.sait.business.MyFirstLocal;
import ca.sait.business.MyFirstRemote;

/**
 * Session Bean implementation class MyFirstEJB
 */
@Stateless
@Local(MyFirstLocal.class)
@Remote(MyFirstRemote.class)
public class MyFirstEJB implements MyFirst {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    // thread safe
    private int counter = 0;

    /**
     * Default constructor. 
     */
    public MyFirstEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    private void postConstruct() {
        logger.trace("ENTER postConstruct");
        logger.trace("EXIT postConstruct");
    }
    
    @PreDestroy
    private void preDestroy() {
        logger.trace("ENTER preDestroy");
        logger.trace("EXIT preDestroy");

    }

    @Override
    @Asynchronous // can use in both stateful or stateless
    public Future<String> sayHello() {
        // TODO Auto-generated method stub
        
        logger.trace("ENTER sayHello");
        
        try {
            counter++;
            final String mesg = "Hello there!!! - "+ counter;
           return new AsyncResult<String>(mesg);
        } finally {
            logger.trace("EXIT sayHello");

        }
        
    }
    

}
