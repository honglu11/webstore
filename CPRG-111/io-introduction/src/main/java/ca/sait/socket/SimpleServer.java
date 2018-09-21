/**
 * 
 */
package ca.sait.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chris
 *
 */
public class SimpleServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try (final ServerSocket server = new ServerSocket(16000);/*final ServerSocket server1 = new ServerSocket(16001);*/) {
			
			while (true) {
				System.out.println("Waiting...");
				final Socket socket = server.accept(); //waiting for someone to connect to a port, a blocking method. a single connection. wait client to connect
				
				try (final OutputStream outStream = socket.getOutputStream();
					 final PrintWriter writer = new PrintWriter(outStream, true); // output information to client
						
				     final InputStream inStream = socket.getInputStream();						
					 final InputStreamReader inStreamReader = new InputStreamReader(inStream); // read client information
					 final BufferedReader reader = new BufferedReader(inStreamReader)) {
				 
					// receive
					final String line = reader.readLine();
					System.out.println("Recieved: " + line);
					if (line.equals("Something - test stop")) {
						writer.write("Shutdown");
						writer.flush();
						break;
					}
					// then write to client
					writer.write("Ok");
					writer.flush();
				
			     }
			}
			
		} catch(final IOException ex) {
			ex.printStackTrace();
		}
	}

}