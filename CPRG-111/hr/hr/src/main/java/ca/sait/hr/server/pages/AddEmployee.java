/**
 * 
 */
package ca.sait.hr.server.pages;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFactory;
import ca.sait.hr.dao.ObjectNotFoundException;
import ca.sait.hr.model.Employee;
import ca.sait.utils.WebPageUtil;

/**
 * URL =
 * http://localhost:16000/add?firstname=***&lastname=***&salary=***&dob=****
 *
 * This page accepts the employee information and addes to the database
 */
public class AddEmployee implements WebPage {

	public static String BASEURL = "http://localhost:16000";
	
	final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
	private Map<String, String> employeeData = new HashMap<>();
	private String[] parameters;
	DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

	/**
	 * @return the parameters
	 */
	public String[] getParameters() {
		return parameters;
	}

	public AddEmployee(String[] parameters) {
		this.parameters = parameters;
	}

	private String buildPageHead() {
		final StringBuilder html = new StringBuilder();
		html.append("<html>");
		html.append("<head>").append("<title>Employee Home</title>").append("</head>");

		return html.toString();
	}

	private String buildPageBody() {
		final StringBuilder html = new StringBuilder();
		Boolean isEmpty = false;

		html.append("<body>").append("Add Employee!").append("<br><br>");

		for (final String parameter : this.parameters) {
			final String[] value = parameter.split("\\=");
			String tempValue = "";
			try {
				tempValue = URLDecoder.decode(value[1], "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// do nothing				
			}
			
			Pattern pattern = Pattern.compile("[a-zA-Z0-9.]*");
			
			if (tempValue == "" || tempValue == null || tempValue.trim().isEmpty() || !pattern.matcher(tempValue).matches()) {
				html.append(value[0]).append(" is invalid. Cannot add this employee.").append("<br>");
				logger.error("Invalid input : {} value {} is invalid. Cannot add this employee.", value[0], value[1]);
				isEmpty = true;				
			} else {				
			  html.append(value[0]).append(" : ").append("&nbsp;&nbsp;");
			  html.append(tempValue).append("<br>");
			  employeeData.put(value[0], tempValue.trim());
			}
		}		
		
		if (!isEmpty) {
			Double sal = null;
			LocalDate birth = null;
			boolean isInvalid = false;
			try {			
				birth = LocalDate.parse(employeeData.get(WebPageUtil.BIRTHDAY), formatter);
			} catch (DateTimeParseException ex) {
				html.append(WebPageUtil.BIRTHDAY).append(" has date time parse error.").append("<br>");
				isInvalid = true;
				logger.error(ex.getMessage(), ex);				
			}
			
			try {
				sal = Double.parseDouble(employeeData.get(WebPageUtil.SALARY));
			} catch (NumberFormatException ex) {
				 html.append(WebPageUtil.SALARY).append(" has format error.").append("<br>");
				 isInvalid = true;
				logger.error(ex.getMessage(), ex);					
			} 			
			
			logger.info("Employee data {}, {}, {}, {}", employeeData.get(WebPageUtil.FIRSTNAME),
					employeeData.get(WebPageUtil.LASTNAME), birth,
					sal);
			
			if (!isInvalid) {
			  boolean isAdded = verifyEmployeeAdded(employeeDAO.add(employeeData.get(WebPageUtil.FIRSTNAME),
					employeeData.get(WebPageUtil.LASTNAME), birth,
					sal));
			  
			  if (!isAdded) {
				  html.append("Add employee failed.").append("<br>");
			  }
			}
		}
		
		html.append("<br><br>").append("<a href= 'http://localhost:16000/list'>List Employees</a><br>");
		html.append("<br>").append("<a href= 'http://localhost:16000/'>Welcome Employee</a><br>");
		html.append("</body>");
		return html.toString();
	}

	private String buildPageBottom() {
		final StringBuilder html = new StringBuilder();
		html.append("</html>");

		return html.toString();
	}

	@Override()
	public String buildPage() {
		final StringBuilder html = new StringBuilder();
		return html.append(buildPageHead()).append(buildPageBody()).append(buildPageBottom()).toString();
	}

	public Boolean verifyEmployeeAdded(Employee emp) {
		Boolean add = false;
		try {
			add = employeeDAO.findBy(emp.getOid()).isPresent();
		} catch (ObjectNotFoundException ex) {
			logger.error(ex.getMessage(), ex);
		}

		return add;
	}

}
