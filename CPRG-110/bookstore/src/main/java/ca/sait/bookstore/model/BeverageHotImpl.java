package ca.sait.bookstore.model;

import java.util.List;

// only allow extends one class
public class BeverageHotImpl extends BeverageAbstract {
	public BeverageHotImpl(String name, double price) {
		this(name, price, BeverageSizeType.LARGE);
	}
	
	public BeverageHotImpl(String name, double price, BeverageSizeType size) {
		super(name, price);
		setSize(size);
		
	}

	@Override
	public boolean isHot() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String sayHellow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOption(BeverageOptions option) throws InvalidOptionException {
		getOptions().add(option);		
	}

//	@Override
//	public boolean addOption(BeverageOptions option) {
//		getOptions().add(option);
//		return true;
//	}

	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() + " - " + getSize();
//	}
}
