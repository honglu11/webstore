<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is my first JSP.
<%
String name = "henry";
out.append(name);
%>

<br />
<%= "This is another" %>
<%= name %>
<% 
   out.println("a + b = ");
   out.println(1+2);
%>
<%! int a=10; int b=20;
%>
<% 
   out.println("a + b = ");
   out.println(a+b);
%>
Sum of 10 and 20 
<%=
10 + 20
%>
</body>
</html>