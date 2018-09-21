/**
 * 
 */
package ca.sait.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.db.InventoryItem;

/**
 * This command removes an item from inventory
 * 
 * @author
 * @version 1.0
 */
public class RemoveCommand extends AbstractCommand {

	private long itemId;

	/**
	 * @param consoleScanner
	 */
	public RemoveCommand(Scanner consoleScanner) {
		super(consoleScanner);
	}

	@Override
	protected void performInput(Scanner consoleScanner) throws ValidationException {
		System.out.print("Item Id: ");
		final String inputItemId = consoleScanner.next();
		try {
			itemId = Long.parseLong(inputItemId);
		} catch (final NumberFormatException ex) {
			throw new ValidationException("Invalid itemId: " + inputItemId);
		}
	}

	@Override
	protected void performFunction() throws OperationException {
		if (!InventoryDB.removeItem(itemId)) {
			throw new OperationException("Unable to remove item: " + itemId);
		}
	}

	@Override
	protected String buildResponse() {
		final StringBuilder text = new StringBuilder();
		text.append("Removed ");
		text.append(itemId);
		text.append(" ItemId");
		text.append("\r\n");
		return text.toString();
	}
}