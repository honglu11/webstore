/**
 * 
 */
package ca.sait.cli;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import ca.sait.produce.FinishedProduct;
import ca.sait.produce.Produce;
import ca.sait.produce.Product;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.db.InventoryItem;

/**
 * This command is used to create a finished product from one or more raw
 * products and add it to the inventory
 * 
 * @author
 * @version 1.0
 */
public class CreateFinishedProductCommand extends AbstractCommand {

	private String productName;
	private List<RawMaterial> rawMaterials = new LinkedList<>();
	private long itemId;

	/**
	 * @param consoleScanner
	 */
	public CreateFinishedProductCommand(Scanner consoleScanner) {
		super(consoleScanner);
	}

	@Override
	protected void performInput(Scanner consoleScanner) throws ValidationException {
		final StringBuilder text = new StringBuilder();
		final List<RawMaterial> rawMaterialsList = new LinkedList<>();
		text.append("Raw Material List\r\n");
		text.append("--------------------\r\n");
		
		Set<InventoryItem> inventory = InventoryDB.getAll();
		
		String raw = inventory.stream().filter(item->item.getItem() instanceof RawMaterial).map(i -> String.format("\titem id:%s - %s Quantity: %d", i.getItem().getItemId(), i.getItem().toString(), i.getQuantity())).collect(Collectors.joining("\n", "", "\n"));
		InventoryDB.getAll().forEach(item -> {
			if (item.getItem() instanceof RawMaterial) {
				text.append("        ");
				text.append("item id: ");
				text.append(item.getItem().getItemId());
				text.append(" - ");
				text.append(item.toString().replace("- Quantity", "Quantity"));
				text.append("\r\n");
				rawMaterialsList.add((RawMaterial) item.getItem());
			}
		});

		if (rawMaterialsList.isEmpty()) {
			text.append("No Raw Materials in inventory");
			text.append("\r\n");
			System.out.println(text.toString());
			return;
		}

		text.append("\r\n");
		System.out.println(text.toString());

		System.out.print("Enter Product Name: ");
		productName = consoleScanner.next();

		if (productName.trim().isEmpty()) {
			return;
		}

		String inputItemId = "";

		do {
			System.out.print("Enter ItemId (-1 to Exit) : ");
			inputItemId = consoleScanner.next();

			if (!inputItemId.equals("-1") && !inputItemId.trim().isEmpty()) {
				try {
					itemId = Long.parseLong(inputItemId);
				} catch (final NumberFormatException ex) {
					throw new ValidationException("Invalid ItemId: " + inputItemId);
				}

				try {
					InventoryItem invItem = InventoryDB.getItem(itemId);

					if (!(invItem.getItem() instanceof RawMaterial)) {
						itemId = 0;
						throw new ValidationException("item id is not a raw material object:" + inputItemId);
					}
				} catch (NullPointerException ex) {
					itemId = 0;
					throw new ValidationException("item id does not exist: " + inputItemId);
				}
			} else {
				break;
			}

		} while (true);

	}

	@Override
	protected void performFunction() throws OperationException {
		if (productName == null || productName.trim().isEmpty()) {
			return;
		}
		
		if (itemId == 0) {
			return;
		}
		
		FinishedProduct finishedProduct = new FinishedProduct(productName, rawMaterials);
		try {
			InventoryDB.addItem(finishedProduct, 1);
		} catch (Exception ex) {
			throw new OperationException("Cannot add finishedProduct " + productName);
		}
	}

	@Override
	protected String buildResponse() {
		final StringBuilder text = new StringBuilder();
		text.append("Aborted operation");
		text.append("\r\n");
		return text.toString();
	}
}