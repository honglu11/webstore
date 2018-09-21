package ca.sait.bookstore.model;

import java.util.UUID;


public class ItemImpl implements Item {

	// uuid is unique key, database use sequence number as primary key cause problem, then use uuid as primary key.
	private final String uuid;
	private final double price;
	private final String name;
//	private String uuid;
//	private double price;
//	private String name;
	/* (non-Javadoc)
	 * @see ca.sait.bookstore.model.Item#getPrice()
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see ca.sait.bookstore.model.Item#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

//	public ItemImpl() {
//		//Object
//		super();
//	}
	
	// no default constructor in this class
	public ItemImpl(String name, double price) {
		this.name = name;
		this.price = price;
		
		// all java provide utility to generate uuid.
		uuid = UUID.randomUUID().toString();
	}

	/* (non-Javadoc)
	 * @see ca.sait.bookstore.model.Item#getUuid()
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
//	public void setUuid(String uuid) {
//		this.uuid = uuid;
//	}
	
	// overload - method signature change modifier, type, parameter type, pareameter
//	public boolean setName(int name) {
//		this.name = name;
//	}
	
	/* (non-Javadoc)
	 * @see ca.sait.bookstore.model.Item#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// if remove super get endless loop since call itself. recursion recursion.
		return getUuid() + " - " + getName() + " - " + getPrice();
	}
	

}