/**
 * 
 */
package ca.sait.hr.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.hr.server.pages.AddEmployee;
import ca.sait.hr.server.pages.ListEmployees;
import ca.sait.hr.server.pages.WebPage;
import ca.sait.hr.server.pages.Welcome;

/**
 *
 */
public class RequestResponseHander implements Callable<Boolean> {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final Socket socket;
	
	public RequestResponseHander(Socket socket) {
		this.socket = socket;
	}

	@Override
	public Boolean call() throws Exception {
		logger.trace("ENTER call()");
		
		// determine what page is called
		// and call the method to perform
		// what needs to happen
		final WebPage webPage;

		try (final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
				
				final String tmpFirstLine = in.readLine();
	
				final String [] resource = tmpFirstLine.split("\\ "); 
				final String method = resource[0];
				final String [] uri = resource[1].split("\\?");		

		        String s;
		        while ((s = in.readLine()) != null) {
		        	logger.info(s);
		            if (s.isEmpty()) {
		                break;
		            }
		        }
	       
		        StringBuilder html = new StringBuilder();
		    		        
		        if ( resource[1].contains("/add")) {		        	
		        	final String [] parameters = uri[1].split("\\&");		        	
		        	webPage = new AddEmployee(parameters);
		        	html.append(webPage.buildPage());
		        } else if ( resource[1].contains("/list")) {		        	
		        	webPage = new ListEmployees();
		          html.append(webPage.buildPage());		        
		        } else {
		        	webPage = new Welcome();
		        	html.append(webPage.buildPage());	
		        }

		        final int size = html.length();
		        
		        out.write("HTTP/1.1 200 OK\r\n");
		        out.write("Date: Tue, 28 Nov 2017 18:00:00 GMT\r\n");
		        out.write("Server: Special/1.0.0\r\n");
		        out.write("Content-Type: text/html\r\n");
		        out.write("Content-Length: " + size + "\r\n");
		        out.write("Expires: Thu, 19 Dec 2017 00:59:59 GMT\r\n");
		        out.write("Last-modified: Tue, 28 Nov 2017 18:00:00 GMT\r\n");
		        out.write("\r\n");

		        out.write(html.toString());
		
			return Boolean.TRUE;
		} finally {
			socket.close();
			logger.trace("EXIT call()");
		}
	}
}