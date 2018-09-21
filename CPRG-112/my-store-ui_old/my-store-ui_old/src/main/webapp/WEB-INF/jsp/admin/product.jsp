<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template>
    <jsp:attribute name="title">${adminProductsModel.title}</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>
        <h1>${adminProductsModel.pageName}</h1> 
        <table width="400px" border="1">
        <thead>
          <tr>
              <th>Product Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Qty in Stock</th>
          </tr>
        </thead>
        </table>   
    </jsp:body>
</t:template>
