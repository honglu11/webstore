/**
 * 
 */
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author celias
 *
 */
public class SelectFromTable extends AbstractDatabase {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String [] args) throws SQLException {
		new SelectFromTable().run();
	}
	
	protected void run() throws SQLException {
		
		for (int i = 0; i <100; i++ ) {
		final String sql = "SELECT oid, name, age FROM person WHERE oid = ?";
		// each has connection in try parameter then close automatically
		try (final Connection connection = getConnection();
		     final PreparedStatement pStmt = connection.prepareStatement(sql);) {
			pStmt.setInt(1, 1); 	// no security issue
			
		try (final ResultSet rs = pStmt.executeQuery()) {
			// next method
			while (rs.next()) {
				final int oid = rs.getInt("oid"); // can use index as well if you know index matched
				final String name = rs.getString("name");
				//final Integer age = rs.getInt("age");
//				final int tmpAge = rs.getInt("age");
//				final Integer age = rs.wasNull()? null : tmpAge;
				
				final Integer age = readInt(rs, "age");
				logger.info("oid: {}  name: {} age: {}", oid, name, age);
			}
		}	
			logger.info("Table Created");
		} catch (final SQLException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			shutdown(); // in bed Derby so we do shutdown
		}
	}
	}
	
	private Integer readInt (ResultSet rs, String columnName) throws SQLException {
		final int tmp = rs.getInt(columnName);
		return rs.wasNull() ? null : tmp;
		
	}
}


