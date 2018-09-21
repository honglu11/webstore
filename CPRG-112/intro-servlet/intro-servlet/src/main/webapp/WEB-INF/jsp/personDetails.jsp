<%@ page import="ca.sait.mvc.model.PersonDetailsFrom" %>
<%@ page import="ca.sait.entity.Person" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<table border="1" width="400px">
<tr>
    <th>First Name</th><th>Last Name</th>
</tr>

<c:forEach items="${people}" var="per">
<tr>
    <td>${per.firstName}</td><td>${per.lastName}</td>
</tr>
</c:forEach>

</table>

<a href="<c:url value="/person" />">Create a new Person</a>

</body>
</html>