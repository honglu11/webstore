/**
 * 
 */
package ca.sait;

/**
 * @author honglu
 *
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String test = "Test" + " Hello"; 
		/* use three different memory 1 for memory location, one for "Test", one for "Hello", memory consuming */
		
		//String test = "Test".concat(" Hello"); 
		
		StringBuilder test = new StringBuilder("Test");
		test.append(" hello"); // then use the same address to append more string
		System.out.print(test);
		
		test = new StringBuilder("good bye"); // test take new memory location
		
		String test1 = "test"; // test1 has one memory location, "test" has one memory location.
		test1 = test1 + " hello"; // test 1 has one new memorylocation, " hello" has one memory location, test 1 value not change, test1 point to new memory location.

	}

}
