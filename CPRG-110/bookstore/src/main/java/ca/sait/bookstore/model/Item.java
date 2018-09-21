package ca.sait.bookstore.model;

public interface Item {

	/**
	 * @return the price
	 */
	double getPrice();

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @return the uuid
	 */
	String getUuid();

	String toString();
	
	// interface default behavior, if don't implment then this return, if implement, implmented method will override this one.
//	public default String getSize() {
//		return "";
//	}

}