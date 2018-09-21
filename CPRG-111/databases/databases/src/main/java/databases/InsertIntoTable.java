/**
 * 
 */
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author celias
 *
 */
public class InsertIntoTable extends AbstractDatabase {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String [] args) {
		new InsertIntoTable().run();
	}
	// use prepareStatement, don't use statement, for security stuff
	protected void run() {
		final String sql = "INSERT INTO person VALUES (?,?,?)"; // ? can be replace dynamically, can use this again again. no hijack happen in this way, table cached the query
		try (final Connection connection = getConnection();
		     final PreparedStatement pStmt = connection.prepareStatement(sql)) {
			
			connection.setAutoCommit(true); // don't need to commit later. if set to false need to commit later.
			
			for (int i = 1000; i < 2000; i++) {
			int index = 1;
			pStmt.setInt(index++, 1); // dynamic index
			//pStmt.setInt(index++, 2); // dynamic index
			pStmt.setString(index++, "Chris"); // pStmt.setString(index++, null);
			pStmt.setNull(index++,  Types.INTEGER); // nullable
			final int updated = pStmt.executeUpdate(); // update every run then commit later. every row need to do executeUpdate, otherwise it will only know the very last row.
			}
			//pStmt.setObject(parameterIndex, x); not recommend, since make jdbc drive think what do you want to do
			connection.commit();
			final int updated = pStmt.executeUpdate();
			
			logger.info("Updated: {}", updated);
		} catch (final SQLException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			shutdown();
		}
	}
}
