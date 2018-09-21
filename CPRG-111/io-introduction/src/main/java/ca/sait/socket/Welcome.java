/**
 * 
 */
package ca.sait.socket;

/**
 * @author honglu
 *
 */
public class Welcome {	
	
	public String buildPageHead() {
		final StringBuilder html = new StringBuilder();
		
		html.append("<html>");
		html.append("<head>").append("<title>Employee Home</title>").append("</head>");
			
		return html.toString();
	}
	
	public String buildPageBody() {
		final StringBuilder html = new StringBuilder();
		
		html.append("<body>").append("Welcome to Employee Home!");
		html.append("<form method='GET'>");
        html.append("<input type='text' name='firstName' />");
        html.append("<input type='text' name='lastName' />");
        html.append("<input type='submit' name='Submit' />");
        html.append("</form>");
		html.append("/<body>");
		
		return html.toString();
	}
	
	public String buildPageBottom() {
		final StringBuilder html = new StringBuilder();
		
		html.append("/<html>");
		
		return html.toString();
	}
	
	
   

}
