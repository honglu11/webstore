/**
 * 
 */
package ca.sait.hr.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class HRWebServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(HRWebServer.class);
	public static final int PORT = 16000;
	public static final int SHUTDOWN_PORT = 16001;
	private static final int SO_TIMEOUT = 1000;
	
	private static AtomicBoolean DO_SHUTDOWN = new AtomicBoolean(false);
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Server server = new Server();
		final ShutDownServer shutDownServer = new ShutDownServer();
		
		new Thread(server).start();
		new Thread(shutDownServer).start();
	}

	private static class Server implements Runnable {
		public void run() {
			LOGGER.trace("ENTER run()");
			
			ExecutorService service = Executors.newCachedThreadPool();
			try (final ServerSocket server = new ServerSocket(PORT);) {
				server.setSoTimeout(SO_TIMEOUT);
				
				while (!DO_SHUTDOWN.get()) {
					LOGGER.debug("Waiting...");
					try {
						final Socket socket = server.accept();
						service.submit(new RequestResponseHander(socket));
					} catch(final SocketTimeoutException ex) {
						// silent catch
					}
				}
				
				service.shutdown();
			} catch(final IOException ex) {
				LOGGER.error(ex.getMessage(), ex);
			} finally {
				LOGGER.trace("EXIT run()");
			}
		}
	}
	
	private static class ShutDownServer implements Runnable {
		public void run() {
			LOGGER.trace("ENTER run()");
			
			try (final ServerSocket server = new ServerSocket(SHUTDOWN_PORT);) {
				try (Socket socket = server.accept()) {
					DO_SHUTDOWN.set(true);
					LOGGER.info("Do Shutdown");
				}	
			} catch(final IOException ex) {
				LOGGER.error(ex.getMessage(), ex);
			} finally {
				LOGGER.trace("EXIT run()");
			}
		}
	}
}
