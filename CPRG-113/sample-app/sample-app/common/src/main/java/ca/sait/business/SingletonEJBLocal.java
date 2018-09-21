package ca.sait.business;

import javax.ejb.Local;

@Local
public interface SingletonEJBLocal {
    
    public long getCount();
    public void incCounter();

}
