/**
 * 
 */
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author celias
 *
 */
public class CreateTable extends AbstractDatabase {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String [] args) {
		new CreateTable().run();
	}
	
	// use child thread
	protected void run() {
		final String sql = "CREATE TABLE person (oid int primary key, name varchar(30), age int)"; // age int not nullable
		// auto close connection, go to pool connection, preparedStatement guarrentee that there is no
		try (final Connection connection = getConnection();
		     final PreparedStatement pStmt = connection.prepareStatement(sql)) {
			
			pStmt.execute(); // use database connection
			
			logger.info("Table Created");
		} catch (final SQLException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			shutdown(); // shutdown
		}
	}
}
