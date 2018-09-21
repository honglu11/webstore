/**
 * 
 */
package ca.sait.cli;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import ca.sait.produce.Fruit;
import ca.sait.produce.Produce;
import ca.sait.produce.Product;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.db.InventoryItem;
import ca.sait.produce.db.PLUFruitDB;
import ca.sait.produce.db.PLUVegetableDB;
import ca.sait.produce.exceptions.InvalidCommodityException;

/**
 * This command is used to create a raw product from harvested produce and add
 * it to the inventory
 * 
 * @version 1.0
 */
public class CreateRawMaterialCommand extends AbstractCommand {

	private long itemId;
	private RawMaterial rawMaterial;

	/**
	 * @param consoleScanner
	 */
	public CreateRawMaterialCommand(Scanner consoleScanner) {
		super(consoleScanner);
	}

	@Override
	protected void performInput(Scanner consoleScanner) throws ValidationException {
        
		final StringBuilder text = new StringBuilder();
		final List<Produce> produceList = new LinkedList<>();
		text.append("Produce List\r\n");
		text.append("--------------------\r\n");
		
		InventoryDB.getAll().forEach(item -> {
			if (item.getItem() instanceof Produce) {
				text.append(" ");
				text.append("item id: ");
				text.append(item.getItem().getItemId());
				text.append(" - ");
				text.append(item.toString().replace("- Quantity", "Quantity"));
				text.append("\r\n");
				produceList.add((Produce) item.getItem());
			}
		});

		if (produceList.isEmpty()) {
			text.append("No Produce in inventory");	
			text.append("\r\n");
			System.out.println(text.toString());
			return;
		}

		text.append("\r\n");
		System.out.println(text.toString());
		
		System.out.print("Item Id: ");
		
		final String inputItemId = consoleScanner.next();
		
		if (inputItemId.trim().isEmpty()) {
			return;
		}
		
		try {
			itemId = Long.parseLong(inputItemId);
		} catch (final NumberFormatException ex) {
			throw new ValidationException("Invalid ItemId: " + inputItemId);
		}
		
		try {
			InventoryItem invItem = InventoryDB.getItem(itemId);
			
			if (!(invItem.getItem() instanceof Produce)) {
                throw new ValidationException("item id is not a produce object:" + inputItemId);
            }
			
			rawMaterial = new RawMaterial((Produce) invItem.getItem());
			int quantity = invItem.getQuantity();

			if (quantity > 1) {
				invItem.removeQuantity(1);
			}

			if (quantity == 1) {
				invItem.removeQuantity(1);
				InventoryDB.removeItem(itemId);
			}

			if (quantity < 1) {
				throw new ValidationException("Cannot remove quantity for the item " + itemId);
			}

		} catch (NullPointerException ex) {
			throw new ValidationException("item id does not exist: " + itemId);
		}

	}

	@Override
	protected void performFunction() throws OperationException {
		if (rawMaterial == null) {
            return;
        }
		try {
			InventoryDB.addItem(rawMaterial, 1);
		} catch (Exception ex) {
			throw new OperationException("Cannot add rawMaterial " + itemId);
		}
	}

	@Override
	protected String buildResponse() {
		final StringBuilder text = new StringBuilder();
		if (rawMaterial == null) {
			text.append("Aborted operation").append("\r\n");
		} else {
			text.append("Created ");
			text.append(rawMaterial.toString());
			text.append("\r\n");
		}
		return text.toString();
	}

}
