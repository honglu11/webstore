package ca.sait.bookstore.model;

// make class as final this class cannot be inherence
public final class BeverageFactory {
	private BeverageFactory() {		
	}
	
	// decide what kind of implmentation we need, if Beverage type change to parent Item, is ok, but parent never know the child, child know parent
	public static Beverage createInstance(String name, double price, boolean isHot) {
		if (isHot) {
			return new BeverageHotImpl(name, price); //return back memory address
		} else {
			return new BeverageColdImpl(name, price);
		}
	}

}
