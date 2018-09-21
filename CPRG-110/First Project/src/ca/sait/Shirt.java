package ca.sait;

public class Shirt {
	
	// Field Declaration: attributes of the class
	public String description = "This is a description.";
	public char colourCode = 'U';
	public double price = 0.0;
	int quantityInStock = 0;
	
	// Methods
	
	/**
	 * Displays information about our shirt
	 */
	
	public void displayInformation() {
		System.out.println("Description: " + description);
		System.out.println("Colour Code: " + colourCode);
		System.out.println("Shirt Price: " + price);
		System.out.println("Quantity In Stock: " + quantityInStock);
	}

}
