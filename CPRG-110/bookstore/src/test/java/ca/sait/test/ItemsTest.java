/**
 * 
 */
package ca.sait.test;

import ca.sait.bookstore.model.Beverage;
import ca.sait.bookstore.model.BeverageColdImpl;
import ca.sait.bookstore.model.BeverageFactory;
import ca.sait.bookstore.model.BeverageOptions;
import ca.sait.bookstore.model.BeverageSizeType;
import ca.sait.bookstore.model.HelpCommandType;
import ca.sait.bookstore.model.InvalidOptionException;
import ca.sait.bookstore.model.Item;
import ca.sait.bookstore.model.ItemImpl;
import ca.sait.bookstore.model.Product;

/**
 * @author honglu
 *
 */
public class ItemsTest {

	/**
	 * @param args
	 * @throws InvalidOptionException 
	 */
	// never throw exception in the line of void main(String[] args) throw InvaidOptionException
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BeverageColdImpl coffee = new BeverageColdImpl("Coffee", 2.99, 'M');
		// Beverage coffee = new Beverage();
		// coffee.setName("coffee");
		// coffee.setPrice(2.99);
		// coffee.setSize('M');

		// Item coffee1 = new BeverageColdImpl("Coffee", 2.99, 'M');

		// System.out.println(coffee1.toString());

		// BeverageColdImpl coffeeOther = new BeverageColdImpl("Coffee", 1.99, 'L');
		// System.out.println(coffeeOther.toString());

		// System.out.println(coffee.toString());

		// Product lego = new Product();
		// lego.setName("Batman");
		// lego.setPrice(199.99);

		// Product lego = new Product("Batman", 199.99);

		// Beverage coffeeOther = new Product("Batman", 199.99);

		// Item does not make sense, if Item is protected, cannot get Item instantiated
		// Item test = new ItemImpl("Some Item", 2.0);

		// System.out.println(lego);
		// static method not allow to call super
		// super.toString();

		Beverage coffee = BeverageFactory.createInstance("Ice tea", 2.99, true);

		for (BeverageSizeType bst : BeverageSizeType.values()) {
			// System.out.println(bst);
		}

		Beverage coffee2 = BeverageFactory.createInstance("IceTea", 2.99, false);
		// coffee2.addOption(BeverageOptions.CREAM);
		// coffee2.addOption(BeverageOptions.SUGAR);
//		System.out.println(coffee2.addOption(BeverageOptions.ICE));
//		System.out.println(coffee2.addOption(BeverageOptions.PUMKIN_SPICE));
//		System.out.println(coffee2.addOption(BeverageOptions.ICE));
		// check exception, try block either has catch or finally. or don't use try just throw exception in the method on the top.
		try {
		coffee2.addOption(BeverageOptions.ICE);
		coffee2.addOption(BeverageOptions.PUMKIN_SPICE);
		coffee2.addOption(BeverageOptions.ICE);

		coffee2.getOptions().forEach(System.out::println);

		// linda expression to use option as variable, powerful since inside can implment business rule, can process in to the loop concurrently, cannot do concurrently in enhance loop
		// also very dynamic to implement the business loop.
		coffee2.getOptions().forEach(option -> {
			final StringBuilder text = new StringBuilder();
			text.append(option.toString());
			text.append(" - ");
			text.append(option.getDescription());

			System.out.println(text);

		}); } catch (InvalidOptionException ex) {
			
			ex.printStackTrace();// if did not do anything or printout here, swallow the error, bad
			System.err.println(ex.getMessage());
		} finally {
			System.out.println("Did something happen?"); // finally always run no matter what
		}

		// also work but performance slow than lamda. can not handle concurrent job
		for (final BeverageOptions option : coffee2.getOptions()) {
			final StringBuilder text = new StringBuilder();
			text.append(option.toString());
			text.append(" - ");
			text.append(option.getDescription());

			System.out.println(text);

		}
		
		
		for (final HelpCommandType type : HelpCommandType.values()) {
			final StringBuilder text = new StringBuilder();
			text.append(type.name());
			text.append(" - ");
			text.append(type.getDescription());
			System.out.println(text);			
		}
		
	}

}
