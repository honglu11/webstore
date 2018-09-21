<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
final String home = request.getContextPath() + "/home";
response.sendRedirect(home);
%>