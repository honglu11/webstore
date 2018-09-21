<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Person Details</title>
<script type="text/javascript" src="<c:url value="/js/test.js" />"></script>
</head>
<body>

<Strong>${personDetailsFrom.errorMessage}</Strong>
<form method="post" action=""<c:url value="/person" />">
First Name: <input type="text" name="firstname" value="${personDetailsFrom.person.firstName}"/> <br />
Last Name: <input type="text" name="lastname" value="${personDetailsFrom.person.lastName}"/> <br />

<input type="submit" name="action" value="add"> <br />
</form>

</body>
</html>