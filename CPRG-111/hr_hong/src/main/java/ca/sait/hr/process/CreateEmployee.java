/**
 * 
 */
package ca.sait.hr.process;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFatory;
import ca.sait.hr.model.Employee;

/**
 * @author honglu
 *
 */
public class CreateEmployee {

	/**
	 * 
	 */
	public CreateEmployee() {
	  try(final Scanner consoleScanner = new Scanner(System.in)) {
		  String firstName = null;
		  String lastName = null;
		  LocalDate birthdate = null;
		  Double salary = null;
		  
		  
		  System.out.print("Enter First Name: ");
		  lastName = consoleScanner.nextLine();
		  
		  System.out.print("Enter Last Name: ");
		  lastName = consoleScanner.nextLine();
		  
		  while(true) {
			  try {
				  System.out.print("Enter Birthdate (yyyy-mm-dd):");
				  birthdate = LocalDate.parse(consoleScanner.nextLine());
				  break;
			  }catch(final DateTimeParseException ex) {
				  System.out.println("\t" + ex.getMessage());
			  }
		  }
		  
		  while(true) {
			  try {
				  System.out.print("Enter Salary: ");
				  final String tmpSalary = consoleScanner.nextLine();
				  final String cleanSalary = tmpSalary.trim();
				  if (cleanSalary.length() > 10) {
					  throw new NumberFormatException("Number is way to large");
				  }
				  
				  salary = Double.parseDouble(cleanSalary);
				  break;
			  }catch(final NumberFormatException ex) {
				  System.out.println("\t" + ex.getMessage());
		  
			  }
			  
			  final EmployeeDAO employeeDAO = EmployeeDAOFatory.createInstance();
			  final Employee emp = employeeDAO.add(firstName, lastName, birthdate, salary);
			  
			  System.out.println(emp);
		  }
	  }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  final CreateEmployee createEmployee = new CreateEmployee();
	  //createEmployee.createEmployee();

	}

}
