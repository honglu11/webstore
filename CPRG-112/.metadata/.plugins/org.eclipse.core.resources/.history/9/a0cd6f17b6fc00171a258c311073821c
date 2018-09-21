<%@ page import="ca.sait.mvc.model.PersonDetailsFrom" %>
<%@ page import="ca.sait.entity.Person" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Person Details: <br />

First Name: ${ personDetailsFrom.person.firstName}  Last Name: ${ personDetailsFrom.person.lastName } <br />
Full Name: ${ personDetailsFrom.person } 

<%
java.util.List<Person> people = (java.util.List<Person>)request.getSession().getAttribute("people");
for (final Person p: people) {
    out.append(p.toString()).append("<br />");
}
%>
</body>
</html>