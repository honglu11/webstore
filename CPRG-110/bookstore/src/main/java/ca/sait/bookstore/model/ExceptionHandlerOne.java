package ca.sait.bookstore.model;

import org.junit.Test;

public class ExceptionHandlerOne {

	@Test
	public void convertNumber() {
		String one = "1";
		Integer o = new Integer(one);
		System.out.println(o);
		;
	}

	@Test
	public void parseNumberGood() {
		String one = "1";

		try {
			Integer o = Integer.parseInt(one);
			System.out.println(o);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void parseNumberNull() {
		String one = "0";

		try {
			Integer o = Integer.parseInt(one);
			System.out.println(o);
			Integer two = null;
			System.out.println(o * two);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void parseNumberBad() {
		String one = "ONE";

		try {
			Integer o = Integer.parseInt(one);
			System.out.println(o);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(expected=NumberFormatException.class) // if put one as 1, did not get expected exception so that get blue, change input properly "one" then get exeption
	public void parseNumberBlue() {
		String one = "one";

		Integer o = Integer.parseInt(one);
		System.out.println(o);

	}

}
