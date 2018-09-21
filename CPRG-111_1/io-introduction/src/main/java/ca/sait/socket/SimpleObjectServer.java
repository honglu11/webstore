/**
 * 
 */
package ca.sait.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import ca.sait.io.Person;

/**
 * @author chris
 *
 */
public class SimpleObjectServer {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) {
		
		try (final ServerSocket server = new ServerSocket(16000);/*final ServerSocket server1 = new ServerSocket(16001);*/) {
			
			while (true) {
				System.out.println("Waiting...");
				final Socket socket = server.accept(); //waiting for someone to connect to a port, a blocking method. a single connection. wait client to connect
				
				try (final OutputStream outStream = socket.getOutputStream();
					 final PrintWriter writer = new PrintWriter(outStream, true); // output information to client
					
					
				     final InputStream inStream = socket.getInputStream();						
						final ObjectInputStream in = new ObjectInputStream(inStream) // read client information
					) {
				 
					// receive
					final Person person = (Person)in.readObject();
					
					System.out.println("Bithday: " + person.getBirthdate());
					System.out.println("Name: " + person.getName());
					System.out.println("Salary: " + person.getSalary());
					
					// then write to client
					writer.write("Ok");
					writer.flush();
				
			     } catch (final ClassNotFoundException ex) {
			    	 ex.printStackTrace();
			     }
			}
			
		} catch(final IOException ex) {
			ex.printStackTrace();
		}
	}

}