/**
 * 
 */
package ca.sait.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chris
 *
 */
public class SimpleWebServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (final ServerSocket server = new ServerSocket(16000);) {
			
			while (true) {
				System.out.println("Waiting...");
				
				try (final Socket socket = server.accept();
					 final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				     final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
					
					final String tmpFirstLine = in.readLine();
					if (tmpFirstLine == null) {
						continue;
					}
					
					final String [] resource = tmpFirstLine.split("\\ "); // seperate by space
					final String method = resource[0];
					final String [] uri = resource[1].split("\\?");					
					

					// what did the browser send, read browser send
			        String s;
			        while ((s = in.readLine()) != null) {
			            System.out.println(s);
			            if (s.isEmpty()) {
			                break;
			            }
			        }
		             
			        // start up browser http://localhost:16000 in any browser, use http://localhost:16000/http://www.cnn.com/2017/11/28/politics/lindsey-graham-north-korea/index.html ok since redundant will ingore
			        // header view-source:http://localhost:16000/
			        
			        final StringBuilder html = new StringBuilder();
			        html.append("<html>");
			        html.append("<head>");
			        html.append("<title>This is a test</title>");
			        html.append("</head>");
			        
			        html.append("<body>");
			        html.append("Have a nice day");
			        
			        if (uri.length == 2) {
			        	final String [] parameters = uri[1].split("\\&");
			        	for (final String parameter : parameters) {
			        		final String [] value = parameter.split("\\=");
			        		html.append("<br />").append("Key = ").append(value[0]).append("&nbsp;&nbsp;");
			        		html.append("Value = ").append(value[1]).append("<br />");
			        	}
			        	
			        } else {			        
			        html.append("<form method='GET'>");
			        html.append("<input type='text' name='firstName' />");
			        html.append("<input type='text' name='lastName' />");
			        html.append("<input type='submit' name='Submit' />");
			        html.append("</form>");
			        }
			        
			        html.append("</body></html>");

			        final int size = html.length();
			        
			        out.write("HTTP/1.1 200 OK\r\n");
			        out.write("Date: Tue, 28 Nov 2017 18:00:00 GMT\r\n");
			        out.write("Server: Special/1.0.0\r\n");
			        out.write("Content-Type: text/html\r\n");
			        out.write("Content-Length: " + size + "\r\n");
			        out.write("Expires: Thu, 30 Nov 2017 00:59:59 GMT\r\n");
			        out.write("Last-modified: Tue, 28 Nov 2017 18:00:00 GMT\r\n");
			        out.write("\r\n");
			        out.write(html.toString());
			     }
			}
			
		} catch(final IOException ex) {
			ex.printStackTrace();
		}

		
	}

}
