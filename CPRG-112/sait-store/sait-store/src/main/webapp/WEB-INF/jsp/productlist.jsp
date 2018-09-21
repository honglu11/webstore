<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>
    <jsp:attribute name="title">${productListModel.title}</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>
        <h1>${productListModel.pageName}</h1>
        
        <c:if test="${productListModel.hasResults}">
          <table style="width:400px" border="1">
          <thead>
              <tr>
                  <th>Product Name</th>
                  <th>Description</th>
                  <th>Price</th>
                  <th>Qty in Stock</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </c:if>
        
        <c:if test="${!productListModel.hasResults}">
        <strong>No Results</strong>
        </c:if>        
    </jsp:body>
</t:template>
