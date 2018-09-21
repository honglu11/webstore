/**
 * 
 */
package ca.sait.hr.model;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author honglu
 *
 */
public class EmployeeFunctions {

	/**
	 * 
	 */
	public EmployeeFunctions() {
		
	}
	
	public static final Function<Employee, UUID> UUID_STYE = employee -> {
		return employee.getOid();
	};
	
	public static final Function<Employee, String> SHORT_STYE = employee -> {
		return employee.getLastName() + ", " + employee.getFirstName();
	};
	
	public static final Function<Employee, String> LONG_STYE = employee -> {
		final String ln = employee.getLastName() != null ? employee.getLastName() : "";
		final String fn = employee.getFirstName() != null ? employee.getFirstName() : "";
		
		final String formattedSalary;
		
		if (employee.getSalary() != null ) {
			final DecimalFormat decimalFormat = new DecimalFormat("$#,###.00 CAN");
			formattedSalary = decimalFormat.format(employee.getSalary());
		} else {
			formattedSalary = "";
		}
		
		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		final String formattedDate = dateFormatter.format(employee.getBirthDate());
		final StringBuilder str = new StringBuilder();
		
		str.append("OID: ").append(employee.getOid().toString()).append("\n");
		str.append("Last Name: ").append(ln).append("\n");
		str.append("First Name: ").append(fn).append("\n");
		str.append("Salary: ").append(formattedSalary).append("\n");
		str.append("Birthday: ").append(formattedDate).append("\n");
		
		return str.toString();
	};


}
