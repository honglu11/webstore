package ca.sait.business;

import javax.ejb.Local;

@Local
public interface StatefulEJBLocal {
    
    public String getMessage();

}
