package ca.sait.bookstore.model;

import java.util.LinkedList;
import java.util.List;

// only allow extends one class if mark as abstract class don't need to implment everything from interface cannot create an instance from abstract class
// abstract class must have constructor
public abstract class BeverageAbstract extends ItemImpl implements Beverage {
	// can create field in abstract class, does not need to implement all interface.
	private BeverageSizeType size;
	// every beverage has its own options, so don't want static to make every beverage has the same option.
	private List<BeverageOptions> options; // don't know how many option, use LinkedList, if we know how many use ArrayList. if create whenever need it, cannot make it final
	
	/* (non-Javadoc)BeverageA
	 * @see ca.sait.bookstore.model.Beverage#getSize()
	 */
	@Override
	public BeverageSizeType getSize() {
		return size;
	}

	/* (non-Javadoc)
	 * @see ca.sait.bookstore.model.Beverage#setSize(char)
	 */
	@Override
	public void setSize(BeverageSizeType size) {
		this.size = size;
	}

	public BeverageAbstract(String name, double price) {
		this(name, price, BeverageSizeType.MEDIUM);
	}
	
	public BeverageAbstract(String name, double price, BeverageSizeType size) {
		super(name, price);
		this.size = size;		
	}
	
	// any class inherence must implment this abstract method
	public abstract String sayHellow();
	
	@Override
	public List<BeverageOptions> getOptions() {
		if(options == null) {
			options = new LinkedList<>();
		}
		return options;
	}
	

	
}
