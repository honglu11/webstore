/**
 * 
 */
package ca.sait.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author honglu
 *
 */
public class FileCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final byte [] b = new byte[128]; //1024 default, 4 byte a character.
		int bLen = b.length;
		
		//FileInputStream fis = null;
		
		// auto close try use JDK 7 C:/Users/honglu/opt/TestFile.txt C:\\Users\\honglu\\opt\\TestFile.txt final InputStream fis = new FileInputStream("C:/Users/honglu/opt/testfile.txt"); OutputStream ois = new FileOutputStream("C:/Users/honglu/opt/testfile_copy.txt")
		// C:\nUsers
		try (final FileInputStream fis = new FileInputStream("C:/Users/honglu/opt/testfile.txt"); final FileOutputStream ois = new FileOutputStream("C:/Users/honglu/opt/testfile_copy.txt")) {
			int count = 0;
			int read = 0;
			//final FileInputStream fis = new FileInputStream(""); if put here, any exception happen on later code, this file won't close
			// fis = new FileInputStream("");
			// read the byte array up to the length, if hit read = -1, hit the last one
			while((read = fis.read(b)) != -1) {
				if (read < bLen) {
					ois.write(b, 0, read); // start offset 0, write read to b, first 46 less than 128, ois.write(b, 5, read-10) 0 is the index of []b
				} else {
					ois.write(b); // always 128
				}
				
				count += read;
				
			}
			
			System.out.println("Wrote: " + count);
			
		} catch ( final FileNotFoundException ex) {
			ex.printStackTrace();
		} catch ( final IOException ex) {
			ex.printStackTrace();
		} 
		/*finally {
		if (fis != null) {
			try {
			fis.close();
			} catch (Exception e) {
				
			}
	}
    */
	}

}