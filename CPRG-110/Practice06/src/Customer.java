/**
 * 
 */

/**
 * @author honglu
 *
 */
public class Customer {
	private int customerId;
	private char status;
	private double totalPurchases;

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * @return the totalPurchases
	 */
	public double getTotalPurchases() {
		return totalPurchases;
	}

	/**
	 * @param totalPurchases
	 *            the totalPurchases to set
	 */
	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases = totalPurchases;
	}
	
	public void displayCustomerInfo() {
		System.out.println("Customer ID: " + customerId );
		System.out.println("status: " + status );
		System.out.println("Total Purchase: " + totalPurchases );
	}

}
