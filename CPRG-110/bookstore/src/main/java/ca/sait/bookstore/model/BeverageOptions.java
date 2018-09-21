package ca.sait.bookstore.model;

public enum BeverageOptions {
	// enum work never change the enum.
	ICE("Ice", "Makes your drink cool!!"),
	GLASS("Glass", "Use glass"),
	SUGAR("Sugar", "Sweetness!!"),
	CREAM("Cream", "Intesting"),
	MILK("Milk", "It's your drink!"),	
	BAILEYS("Baileys", "Now you are talking"),
	EXTRA_ESPESSO("Extra Expresso", "good for you"), 
	PUMKIN_SPICE("Pumplin Spice", "You have to be kidding me!")
	
	;
	
	private final String displayName;
	private final String description;

	private BeverageOptions(String displayName, String description) {
		this.displayName = displayName;
		this.description = description;
	}
	
	@Override
	public String toString() {		
		return displayName;
	}
	
	public String getDescription() {
		return description;
	}
}
