package ca.sait.bookstore.model;

import java.util.List;

public interface Beverage extends Item {
	
	// cannot create field; cannot get from default method for size
	//private char size;

	/**
	 * @return the size
	 */
	BeverageSizeType getSize();

	/**
	 * @param size the size to set
	 */
	void setSize(BeverageSizeType size);
	
	boolean isHot();
	
	/**
	 * Method to add an option to the beverage
	 * @param option
	 * Can throws this type of InvalidOptionException. may not throws
	 */
	void addOption(BeverageOptions option) throws InvalidOptionException;
	
	/**
	 * 
	 * @return all options added to the beverage
	 */
	List<BeverageOptions> getOptions();

}