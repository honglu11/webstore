/**
 * 
 */
package ca.sait.bookstore.model;

/**
 * @author honglu
 *
 */
public class Book extends ItemImpl {

	private String author;
	private String isbn;
	private String format;
	
	public Book(String name, double price) {
		super(name, price);
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	// overload
	public boolean setAuthor(int author) {
		return false;
	}

	// overload
	public void setAuthor(char author) {
		return; // use return to get out of method
	}

}
