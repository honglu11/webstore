/**
 * 
 */
package ca.sait.cli;

/**
 * @author honglu
 *
 */
public enum HelpCommandType {
	HF("Harvest Fruit"),
	HV("Harvest Vegetable"),
	CR("Create Raw Material"),
	CP("Create Finished Product"),
	LIST("List all Inventory"),
	REMOVE("Remove Item from Inventory"),
	HELP("List all Commands"),
	EXIT("out of application")
	
	;
	private final String description;
	/**
	 * 
	 * @param description
	 */
	private HelpCommandType(String description) {
		this.description = description;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	

}
