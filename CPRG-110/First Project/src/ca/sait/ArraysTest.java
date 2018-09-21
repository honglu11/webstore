package ca.sait;

public class ArraysTest {

	public static void main(String[] args) {
		int [] a = new int[5]; // the same int a [] = new int[5];
		String []str = new String[5];
		int size = str.length;
		
		String [] newStr = new String[size + 2];
		newStr[0] = str[0];
		newStr[1] = str[1];
		newStr[2] = str[2];
		newStr[3] = str[3];
		newStr[4] = str[4];
		
		newStr[5] = "6";
		newStr[6] = "7";

//		int i = 0; // can use short or byte, but cannot use long since [] always take int, short and byte shorter than the int, so always fit.
//		newStr[i] = str[i++];
//		newStr[i] = str[i++];
//		newStr[i] = str[i++];
//		newStr[i] = str[i++];
//		newStr[i] = str[i++];
//		
//		newStr[i++] = "6";
//		newStr[i] = "7";
		
//		newStr[i] = str[i];
//		newStr[++i] = str[i];
//		newStr[++i] = str[i];
//		newStr[++i] = str[i];
//		newStr[++i] = str[i];
//		
//		newStr[i++] = "6";
//		newStr[i] = "7";
//		int i = 0;
//		for (; i < size; i++) {
//			newStr[i] = str[i];
//		}
		
		// if condition is not satisfy, not run
		int i = 0;
		for (final String s: str) {
			newStr[i++] = s;
		}
		
		// if condition is not satisfied, not run
		while (i<size) {
			newStr[i] = str[i++];
		}
		
		while (true) {
			newStr[i] = str[i++];
			if (i<size)
				continue;
			else
				break;
		}
		
		// always get into loop first, then judge
		do {
			newStr[i] = str[i];
		} while (i<size);
		
		do {
			newStr[i] = str[i++];
			if (i<size)
				continue;
			else
				break;
		} while (true);
		
		
		newStr[i++] = "6";
		newStr[i++] = "7";
		
		str = newStr; // resize the original array, point the array to the new array address;
				
		System.out.println(a[1]);
		System.out.println(str[1]); // not initialize null
		
		str[1] = "Test";
		System.out.println(str[1]);
		
		String []str1 = {"1", "2", "3", "4", "5"}; // shortcut of the initialize, cannot resize it at all.
		//String test = {'a', 'b', 'c'};
		final int []b = {0,2,3,4,7}; // cannot be final
		
		// enhance loop, always run, as long as one element, not null.
		for (final String s: str) {
			System.out.println(s);
		}
		

	}

}
