/**
 * 
 */
package ca.sait.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author honglu
 *
 */
public class TextCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final char [] c = new char[1024]; //1024 default, has to know how much, trucated to 1024, deal with big data
				
		
		try (final FileReader fis = new FileReader("C:/Users/honglu/opt/testfile.txt"); final FileWriter ois = new FileWriter("C:/Users/honglu/opt/testfile_copy.txt")) {
			int count = 0;
			int read = 0;

			while((read = fis.read(c)) != -1) {
				
				ois.write(c, 0, read); // start offset 0, write read to b, first 46 less than 128, ois.write(b, 5, read-10), 0 is the first index of char []
				count += read;
				
			}
			
			System.out.println("Wrote: " + count);
			
		} catch ( final FileNotFoundException ex) {
			ex.printStackTrace();
		} catch ( final IOException ex) {
			ex.printStackTrace();
		} 
		

	}

}
