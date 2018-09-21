package ca.sait.bookstore.model;

// only allow extends one class
public class BeverageColdImpl extends BeverageAbstract {
		
	public BeverageColdImpl(String name, double price) {
		this(name, price, BeverageSizeType.MEDIUM);
	}
	
	public BeverageColdImpl(String name, double price, BeverageSizeType size) {
		super(name, price);
		setSize(size);
		
	}

	@Override
	public boolean isHot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String sayHellow() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void addOption(BeverageOptions option) throws InvalidOptionException {
		
		switch(option) {
		case ICE:
			if (getOptions().contains(BeverageOptions.PUMKIN_SPICE)) {
				getOptions().add(option);
								
			} else {
				throw new InvalidOptionException("Needs Pumpkin spice to add ICE");
			}
			break;
		case PUMKIN_SPICE:	
		case BAILEYS:			
		case SUGAR:
			getOptions().add(option);			
			break;			
		default:
			throw new InvalidOptionException("Can not add " + option.name());		
		}	
		
	}
	
//	@Override
//	public boolean addOption(BeverageOptions option) {
//		final boolean added;
//		switch(option) {
//		case ICE:
//			if (getOptions().contains(BeverageOptions.PUMKIN_SPICE)) {
//				getOptions().add(option);
//				added = true;				
//			} else {
//				added = false;
//			}
//			break;
//		case PUMKIN_SPICE:	
//		case BAILEYS:			
//		case SUGAR:
//			getOptions().add(option);
//			added = true;
//			break;			
//		default:
//			added = false;		
//		}	
//		
//		return added;
//	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() + " - " + getSize();
//	}
}
