/**
 * 
 */

/**
 * @author honglu
 *
 */
public class Order {
	private long orderValue;
	private int itemQuantity;
	private int itemPrice;
	/**
	 * @return the orderValue
	 */
	public long getOrderValue() {
		return orderValue;
	}
	/**
	 * @param orderValue the orderValue to set
	 */
	public void setOrderValue(long orderValue) {
		this.orderValue = orderValue;
	}
	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * @return the itemPrice
	 */
	public int getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public void calculateTotal() {
		this.orderValue = this.itemPrice * this.itemQuantity;
		System.out.println("Order total: " + orderValue);
	}

}
