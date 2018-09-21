/**
 * 
 */
package ca.sait.cli;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ca.sait.produce.FinishedProduct;
import ca.sait.produce.Produce;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.db.InventoryDB;

/**
 * This command is used to list all items in the inventory
 * 
 * @version 1.0
 */
public class ListCommand extends AbstractCommand {
    
    /**
     * @param consoleScanner
     */
    public ListCommand(Scanner consoleScanner) {
        super(consoleScanner);
    }

    @Override
    protected void performInput(Scanner consoleScanner)
    throws ValidationException {
    	
    }
    
    @Override
    protected void performFunction() 
    throws OperationException {
    }
    
    @Override
    protected String buildResponse() {
        final StringBuilder text = new StringBuilder();
        text.append(getProduceList()).append("\r\n").append(getRawMaterialList()).append("\r\n").append(getFinishProductList()).append("\r\n");
        return text.toString();
    }
    
    private String getProduceList() {
		final StringBuilder text = new StringBuilder();
		final List<Produce> produceList = new LinkedList<>();
		text.append("Produce List\r\n");
		text.append("--------------------\r\n");

		InventoryDB.getAll().forEach(item -> {
			if (item.getItem() instanceof Produce) {
				text.append("        ");
				text.append("item id: ");
				text.append(item.getItem().getItemId());
				text.append(" - ");
				text.append(item.toString().replace("- Quantity", "Quantity"));
				text.append("\r\n");
				produceList.add((Produce)item.getItem());
			}
		});
		
		if (produceList.isEmpty()) {
			text.append("No Produce in inventory");
		}
		
		text.append("\r\n");
		return text.toString();
	}
    
    private String getRawMaterialList() {
		final StringBuilder text = new StringBuilder();
		final List<RawMaterial> rawMaterials = new LinkedList<>();
		text.append("Raw Material List\r\n");
		text.append("--------------------\r\n");

		InventoryDB.getAll().forEach(item -> {
			if (item.getItem() instanceof RawMaterial) {
				text.append("        ");
				text.append("item id: ");
				text.append(item.getItem().getItemId());
				text.append(" - ");
				text.append(item.toString().replace("- Quantity", "Quantity"));
				text.append("\r\n");
				rawMaterials.add((RawMaterial)item.getItem());
			}
		});
		
		if (rawMaterials.isEmpty()) {
			text.append("No Raw Materials in inventory");
		}
		
		text.append("\r\n");
		return text.toString();
	}
    
    private String getFinishProductList() {
		final StringBuilder text = new StringBuilder();
		final List<FinishedProduct> finishedProducts = new LinkedList<>();
		text.append("Finished Product List\r\n");
		text.append("--------------------\r\n");

		InventoryDB.getAll().forEach(item -> {
			if (item.getItem() instanceof FinishedProduct) {
				text.append("        ");
				text.append("item id: ");
				text.append(item.getItem().getItemId());
				text.append(" - ");
				text.append(item.toString().replace("- Quantity", "Quantity"));
				text.append("\r\n");
				finishedProducts.add((FinishedProduct)item.getItem());
			}
		});
		
		if (finishedProducts.isEmpty()) {
			text.append("No Finished Products in inventory");
		}
		
		text.append("\r\n");
		return text.toString();
	}
}
