/**
 * 
 */
package ca.sait;

/**
 * @author honglu
 *
 */
public class PrimitiveTypes {
	// only down cast, cannot up cast.
	// integral primitive types
	static byte a = 1; //8 if not assign, get value 0; all primitive type has value 0 if not assign. field canbe not assign the value
	static short b = 1; //16
	static int c = 1; //32
	static long d = 1l;  //64
	
	// floating primitive types
	static float e = 1.2f; // 32 bit 1.0 is double cannot work, 1.0f will work. 1.2f lose position then the 1.2f is not 1.2 double!!!
	static double f = 1.2; //64 bit dont assign double to float
	static double fake = 1.2f;
	
	// textual primitive type
	static char g = 'u';
	
	// logical primitive type
	static boolean h = true; 
	
	static String test; // none primitive type if not initial value will get null
	
	// why has different type? memory allocation

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int cl = 5 + c; // in the method, a variable must initialized before use it. int cl; print it out get compile error
		int el = (int)d + c; // if cast interger it is design flaw
		long dl = 5 + d;
		//System.out.println(cl);
		System.out.println(dl);
		System.out.println(el);
		
		int al = ++c;
		System.out.println(al);
		
		System.out.println(c);
		
		int ab = c++;
		System.out.println(ab);
		
		System.out.println(c);
		
		int h1 = c+=10;
		
		System.out.println(h1);
		System.out.println(c);
		
		// compare the value of a and b
		
		boolean compare = e == f;
		
		System.out.println(compare);
		
		// disaster
		boolean compare1 = e == fake;
		
		System.out.println(compare1);
		 
		e+=1.1;
		fake+=1.1;
		
		System.out.println(e==fake);

	}

}
