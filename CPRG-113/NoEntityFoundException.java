package ca.sait.services;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class NoEntityFoundException extends Exception {

    private static final long serialVersionUID = 4237238855174078458L;

    public NoEntityFoundException(String message) {
        super(message);
    }
}
