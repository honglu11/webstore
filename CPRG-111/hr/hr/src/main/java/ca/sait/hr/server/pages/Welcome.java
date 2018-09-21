/**
 * 
 */
package ca.sait.hr.server.pages;

import ca.sait.utils.WebPageUtil;

/**
 * URL = http://localhost:16000/welcome
 * 
 * This page will display just a hello message and the form to 
 * enter a firstname, lastname, salary and date of birth
 *
 */
public class Welcome implements WebPage {
	public final String BASEURL = "http://localhost:16000";
	
	private String buildPageHead() {
		final StringBuilder html = new StringBuilder();		
		html.append("<html>");
		html.append("<head>").append("<title>Employee Home</title>").append("</head>");
			
		return html.toString();
	}
	
	private String buildPageBody() {
		final StringBuilder html = new StringBuilder();
		
		html.append("<body>").append("Welcome to Employee Home!").append("<br><br>");
		
		html.append("<script type='text/javascript'> ").append("function validateForm() {");
	    html.append("var a=document.forms[\"Form\"][").append("\"").append(WebPageUtil.FIRSTNAME).append("\"").append("].value;");
	    html.append("var b=document.forms[\"Form\"][").append("\"").append(WebPageUtil.LASTNAME).append("\"").append("].value;");
	    html.append("var c=document.forms[\"Form\"][").append("\"").append(WebPageUtil.BIRTHDAY).append("\"").append("].value;");
	    html.append("var d=document.forms[\"Form\"][").append("\"").append(WebPageUtil.SALARY).append("\"").append("].value;");
	    html.append("if (a==null || a==\"\",b==null || b==\"\",c==null || c==\"\",d==null || d==\"\") {");
	    html.append("alert(\"Please Fill All Required Fields!\");");
	    html.append("return false;} return true;}").append("</script>");
		
		html.append("<form name = 'Form' method='GET' onsubmit='return validateForm()' action='/add'>");
		html.append("First name:<br>").append("<input type='text' name='").append(WebPageUtil.FIRSTNAME).append("' />").append("<br>");
		html.append("Last name:<br>").append("<input type='text' name='").append(WebPageUtil.LASTNAME).append("' />").append("<br>");
		html.append("Birthday: yyyymmdd <br>").append("<input type='text' name='").append(WebPageUtil.BIRTHDAY).append("' />").append("<br>");
		html.append("Salary:<br>").append("<input type='text' name='").append(WebPageUtil.SALARY).append("' />").append("<br><br>");
        html.append("<input type='submit' value='Submit' />");
        html.append("</form>");
		html.append("</body>");
		
		return html.toString();
	}
	
	private String buildPageBottom() {
		final StringBuilder html = new StringBuilder();		
		html.append("</html>");
		
		return html.toString();
	}
	
	@Override
	public String buildPage() {
		final StringBuilder html = new StringBuilder();
		return html.append(buildPageHead()).append(buildPageBody()).append(buildPageBottom()).toString();
	}
	
}
