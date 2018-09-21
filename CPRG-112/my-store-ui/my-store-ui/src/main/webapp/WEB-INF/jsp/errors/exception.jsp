<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"
    import="java.io.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<c:set var="error"><%=exception.getMessage() %></c:set>
<%
String stacktrace = null;

    try (final StringWriter stringWriter = new StringWriter();
         final PrintWriter printWriter = new PrintWriter(stringWriter)) {
        
        exception.printStackTrace(printWriter);
%>
<c:set var="stacktrace"><%= stringWriter.toString()%></c:set>
<% } %>
<t:template>
    <jsp:attribute name="title">My Store</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>Message: ${error} <br /><br />
    ${stacktrace}

    </jsp:body>
     
</t:template>