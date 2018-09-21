package ca.sait.hr.server.pages;

import java.util.List;

import ca.sait.hr.dao.EmployeeDAO;
import ca.sait.hr.dao.EmployeeDAOFactory;
import ca.sait.hr.model.Employee;
import ca.sait.utils.WebPageUtil;

/**
 * URL = http://localhost:16000/list
 * 
 * this will display all the employees that have been
 * added to the database
 */
public class ListEmployees implements WebPage {
	final EmployeeDAO employeeDAO = EmployeeDAOFactory.createInstance();
	
	private String buildPageHead() {
		final StringBuilder html = new StringBuilder();		
		html.append("<html>");
		html.append("<head>");		
		html.append("<style>").append("table, th, td {").append("border: 1px solid black;").append("border-collapse: collapse;}");
		html.append("th, td {").append("padding: 5px;}").append("th {").append("text-align: left; }").append("</style>");		
		html.append("</head>");
			
		return html.toString();
	}
	
	private String buildPageBody() {
		final StringBuilder html = new StringBuilder();
		
		html.append("<body>").append("All Employees List!").append("<br><br>");
				
		final List<Employee> employeeList = getEmployeeList();
		html.append("<table style='width:100%'>").append("<caption>Employee List</caption>");
		html.append("<tr><th>").append("Oid").append("</th>");
		html.append("<th>").append(WebPageUtil.FIRSTNAME).append("</th>");
		html.append("<th>").append(WebPageUtil.LASTNAME).append("</th>");
		html.append("<th>").append(WebPageUtil.BIRTHDAY).append("</th>");
		html.append("<th>").append(WebPageUtil.SALARY).append("</th></tr>");
		
		for( final Employee emp : employeeList) {
			html.append("<tr><td>").append(emp.getOid().toString()).append("</td>");
			html.append("<td>").append(emp.getFirstName()).append("</td>");
			html.append("<td>").append(emp.getLastName()).append("</td>");
			html.append("<td>").append(emp.getBirthdate().toString()).append("</td>");
			html.append("<td>").append(emp.getSalary().toString()).append("</td></tr>");			
		}

		html.append("</table>").append("<br>");
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
	
	public List<Employee> getEmployeeList() {		
		final List<Employee> all = employeeDAO.findAll();
		return all;
	}

}
