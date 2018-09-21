/**
 * 
 */

/**
 * @author honglu
 *
 */
public class CustomerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Customer cust1 = new Customer();
      Customer cust2 = new Customer();
      
      cust1.setCustomerId(1);
      cust2.setCustomerId(2);
      
      cust1.setStatus('O');
      cust1.setTotalPurchases(88);
      
      cust2.setStatus('N');
      cust2.setTotalPurchases(98);
      
      cust1.displayCustomerInfo();
      cust2.displayCustomerInfo();
      
      cust2 = cust1;
      cust1.displayCustomerInfo();
      cust2.displayCustomerInfo();
	}

}
