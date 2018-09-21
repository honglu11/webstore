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
public class DropTable extends AbstractDatabase {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String [] args) {
		new DropTable().run();
	}
	
	protected void run() {
		final String sql = "DROP TABLE person";
		try (final Connection connection = getConnection();
		     final PreparedStatement pStmt = connection.prepareStatement(sql)) {
			
			pStmt.execute();
			
			logger.info("Table Created");
		} catch (final SQLException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			shutdown();
		}
	}
}
