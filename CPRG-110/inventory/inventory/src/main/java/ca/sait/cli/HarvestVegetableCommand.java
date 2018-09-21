/**
 * 
 */
package ca.sait.cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import ca.sait.produce.Produce;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.Vegetable;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.db.PLUFruitDB;
import ca.sait.produce.db.PLUVegetableDB;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * This command is used to get harvest information for a vegatable
 * and add it to the inventory
 * 
 * @author 
 * @version 1.0
 */
public class HarvestVegetableCommand extends AbstractCommand {

    private String commodity;
    private String variety;
    private int quantity;
    private Date harvestDate;

    /**
     * @param consoleScanner
     */
    public HarvestVegetableCommand(Scanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    protected void performInput(Scanner consoleScanner)
    throws ValidationException {
    	getVegetableList();
    	
    	System.out.print("Select Commodity: ");
    	commodity = consoleScanner.next();    	
    	
    	final Set<String> vegetableVarieties;
    	try {    			
    		vegetableVarieties = getVegetableVariety(commodity);
    	} catch (InvalidCommodityException e) {
    		throw new ValidationException("InvalidCommodity: " + commodity);    		
    	}
    	
    	 System.out.print("Enter Variety: ");
         variety = consoleScanner.next(); 
         
         if (!vegetableVarieties.contains(variety)) {
         	throw new ValidationException("InvalidVariety: " + variety);
         }
         
         System.out.print("Enter Quantity: ");
         final String tmpQuantity = consoleScanner.next();
         
         try {
        	 quantity = Integer.parseInt(tmpQuantity);
         } catch (final NumberFormatException ex) {
        	 throw new ValidationException("Invalid Quantity: " + "invalid number for quantity " + tmpQuantity);
         }
    	
         System.out.print("harvest Date: ");
         final String date = consoleScanner.next();
         final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
         try {
        	 harvestDate = dateFormatter.parse(date);
         } catch ( final ParseException ex) {
        	 throw new ValidationException("unparseable date: " + date);
         }    
         
    }
    
    private Set<String> getVegetableVariety(String commodity) throws InvalidCommodityException {
    	final StringBuilder text = new StringBuilder();
    	text.append("Variety List\r\n");
		text.append("--------------------\r\n");
		
		final Set<String> vegetableVarieties = PLUVegetableDB.getVarieties(commodity);
    	
		vegetableVarieties.forEach(vegetableVariety->{       	
			text.append("        ");
			text.append(vegetableVariety);	
			text.append("\r\n");
        	});
        text.append("--------------------\r\n");
        
        System.out.println(text.toString());
		return vegetableVarieties;
	}

	private void getVegetableList() {
    	final StringBuilder text = new StringBuilder();
    	text.append("Vegetable List\r\n");
		text.append("--------------------\r\n");
    	
        PLUVegetableDB.getVegetables().forEach(vegetable->{       	
			text.append("        ");
			text.append(vegetable);	
			text.append("\r\n");
        	});
        text.append("--------------------\r\n");
        
        System.out.println(text.toString());
		
	}

	@Override
    protected void performFunction() 
    throws OperationException{      	
      	try {
		Produce produce = Produce.createInstance(false, commodity, variety, harvestDate);
      	InventoryDB.addItem(produce, quantity);
      	} catch (InvalidCommodityException ex) {
			throw new OperationException(ex.getMessage());
		} catch (InvalidVarietyException ex) {
			throw new OperationException(ex.getMessage());
		} catch (ValidationException ex) {
			throw new OperationException(ex.getMessage());
		}
    }
    
    @Override
    protected String buildResponse() {
    	final StringBuilder text = new StringBuilder();
    	text.append("Created ");
        text.append(commodity);
        text.append("-");
        text.append(variety);
        text.append("\r\n");
        return text.toString();
    }
}