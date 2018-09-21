package ca.sait.business;

import java.util.concurrent.Future;

// can use @Local @Remote here as well
public interface MyFirst {

    public Future<String> sayHello();
        
    
}
