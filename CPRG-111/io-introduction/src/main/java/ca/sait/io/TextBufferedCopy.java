/**
 * 
 */
package ca.sait.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author honglu
 *
 */
public class TextBufferedCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// when reading the text file, use buffered better, deal with all the trunk, default is 1024, 128G file, bufferedReader will 
		try (final FileReader fis = new FileReader("C:/Users/honglu/opt/testfile.txt"); final FileWriter ois = new FileWriter("C:/Users/honglu/opt/testfile_copy.txt"); final BufferedReader reader = new BufferedReader(fis); final BufferedWriter writer = new BufferedWriter(ois)) {
			String line = null;

			// read remove the very last new line char, so has to write a newLine();
			while((line = reader.readLine() ) != null) {
				
				writer.write(line);
				//writer.flush(); //want physical writing, if flush too often back lock, trunking, 
				writer.newLine();
				
			}			
	
			
		} catch ( final FileNotFoundException ex) {
			ex.printStackTrace();
		} catch ( final IOException ex) {
			ex.printStackTrace();
		} 
		

	}


}