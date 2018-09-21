/**
 * 
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */
public class AbstractDatabase {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String dbName="./DerbyDB/DemoDB";
	private final String dbStartupParameters = ";create=true";
	private final String dbShutdownParameters = ";shutdown=true";
	private final String connectionURL = "jdbc:derby:" + dbName + dbStartupParameters; 
	private final String connectionShutdownURL = "jdbc:derby:" + dbName + dbShutdownParameters;
	
	protected AbstractDatabase() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			logger.info("Registered Class");
		} catch (final ClassNotFoundException ex) {
			logger.error(ex.getMessage(), ex);
		}
	}
	
	// check exception
	protected Connection getConnection() 
	throws SQLException {
		try {
			return DriverManager.getConnection(connectionURL); // physically connect to the database
		} finally {
			logger.info("Created Connection: {}", connectionURL);
		}
	}
	
	/**
	 * This shutdown is specific to Apache Derby Only
	 */
	protected void shutdown() {
		try {
			DriverManager.getConnection(connectionShutdownURL); // physically connect to the database
		} catch (final SQLNonTransientConnectionException ex) {
			// this is thrown during shutdown.  This is normal for
			// Apache Derby Only
		} catch (final SQLException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			logger.info("Apache Derby Shutdown completely");
		}
	}
}
