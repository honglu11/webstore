package ca.sait.dto;

public enum CartStatus {

    OPEN("Customer has creating and is still shopping."),     
    SUBMITTED("Customer has submitted the order."), 
    CANCELLED("The order has been cancelled"),
    BUILD("The order is being put together so it can be shipped."), 
    COMPLETED("All the items have been packaged and ready to ship."), 
    SHIPPED("The order has been shipped."),
    RECIEVED("The order has been recieved by the customer")
    
    ;
    
    private final String description;
    
    private CartStatus(String description) {
        this.description = description;
    }
    
    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }
    
}
