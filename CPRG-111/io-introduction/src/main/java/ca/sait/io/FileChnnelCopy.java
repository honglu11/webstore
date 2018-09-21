/**
 * 
 */
package ca.sait.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author honglu
 *
 */
public class FileChnnelCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// window deal with 8 synch stream at the same time. linux deal with asynch so that faster.
		final File inputFile = new File("./testfile.txt");
		final File outputFile = new File("./testfile_copy.txt");
		
		
		try (final FileChannel fis = new FileInputStream(inputFile).getChannel(); final FileChannel ois = new FileOutputStream(outputFile).getChannel()) {
			final int size = (int) fis.size();
			
			final ByteBuffer buff = ByteBuffer.allocate(size);
			fis.read(buff); // read input file to buffer
			buff.position(0); // return to 0 index, then can write from begining.
			//buff.flip(); // revert all the file
			ois.write(buff); // write all the content			
			
		} catch ( final FileNotFoundException ex) {
			ex.printStackTrace();
		} catch ( final IOException ex) {
			ex.printStackTrace();
		} 
	
	}

}
