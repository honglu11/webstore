package ca.sait.ejb;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.business.SingletonEJBLocal;

/**
 * Session Bean implementation class SingletonEJB
 */
@Singleton
@LocalBean
@Local(SingletonEJBLocal.class)
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SingletonEJB implements SingletonEJBLocal {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    //private final AtomicLong COUNTER = new AtomicLong();
    private long counter = 0;
    
    // cannot gurrantee thread safe when increase since singleton
//    @Override
//    public long getCount() {
//        return COUNTER.incrementAndGet();        
//    }
    
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
    
    @Lock(LockType.WRITE)
    @AccessTimeout(value=1000)
    public void incCounter() {
        counter++;
    }
    
    @Lock(LockType.READ)
    public long getCount() {
        return counter;
    }

}
