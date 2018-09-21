package ca.sait.mystore.rs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Chris Elias
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage {

    /** 
     * contains the same HTTP Status code returned by the server 
     */
    @XmlElement(name = "status")
    private int status;
    
    /** 
     * application specific error code 
     */
    @XmlElement(name = "code")
    private int code;
    
    /** 
     * message describing the error
     */
    @XmlElement(name = "message")
    private String message;
 
    public ErrorMessage() {
    }
    
    public ErrorMessage(int status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
