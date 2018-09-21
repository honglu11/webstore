/**
 * 
 */
package ca.sait.mvc.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.business.StatefulEJBLocal;

/**
 * @author honglu
 *
 */
@SessionScoped
@Named // means model session object must implement Serializable
public class SessionModel implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4986669508468721040L;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @EJB
    private StatefulEJBLocal stateful;
    
    public String getMessage() {
        return stateful.getMessage();        
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

}