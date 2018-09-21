import java.util.UUID;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setStatus('N');
        customer.setTotalPurchases(10.99);
        
        customer.displayCustomerInfo();
	}

}
