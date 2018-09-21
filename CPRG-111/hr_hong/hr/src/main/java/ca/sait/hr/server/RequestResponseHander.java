/**
 * 
 */
package ca.sait.hr.server;

import java.net.Socket;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.hr.server.pages.WebPage;

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
		
		try {
			socket.close();
			return Boolean.TRUE;
		} finally {
			logger.trace("EXIT call()");
		}
	}
}