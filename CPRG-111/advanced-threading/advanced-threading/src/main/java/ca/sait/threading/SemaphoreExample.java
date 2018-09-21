/**
 * 
 */
package ca.sait.threading;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author Chris Elias
 */
public class SemaphoreExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Semaphore available = new Semaphore(3);

        try {
            available.acquire();
            System.out.println("Acquire : " +available.availablePermits());
    
            available.release();
            System.out.println("Released : " +available.availablePermits());
    
            available.release();
            System.out.println("Released : " +available.availablePermits());
    
            available.release();
            System.out.println("Released : " +available.availablePermits());
    
            available.release();
            System.out.println("Released : " +available.availablePermits());
    
            available.acquire();
            System.out.println("Acquire : " +available.availablePermits());
    
            available.acquire();
            System.out.println("Acquire : " +available.availablePermits());
    
            available.acquire();
            System.out.println("Acquire : " +available.availablePermits());
    
            available.acquire();
            System.out.println("Acquire : " +available.availablePermits());
    
            available.acquire();
            System.out.println("Acquire : " +available.availablePermits());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
