/**
 * 
 */
package ca.sait;

/**
 * @author honglu
 *
 */
public class ShirtTest {

	/**
	 * @param args this are the default parameters for the application
	 */
	public static void main(String[] args) {
		/* get into code block so no modifier. only modifier that we can add to the variable is final means we never change it.*/
		final Shirt shirt = new Shirt(); 
		/* the variable get instance. a java class is a template. an instance of an object. assign an object always use, hold a memory location in stack */
		int i = 10; 
		/* hold the actually physical memory in stack; store the actual value 10; */
		
		final Shirt shirt2 = new Shirt();
		boolean compare = shirt == shirt2;
		System.out.println(compare); 
		/* is false since compare two object's memory address, the address are different */
		
		shirt.displayInformation();

	}

}
