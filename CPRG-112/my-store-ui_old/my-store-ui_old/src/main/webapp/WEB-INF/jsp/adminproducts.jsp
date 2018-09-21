<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template>
    <jsp:attribute name="title">${productListModel.title}</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>
        <h1>${adminProductsModel.pageName}</h1> 
        
        <table style="width:85%" border="1">
        
          <tr>
              <td>
              <form id="formProductlist" method="post"
            action="<c:url value="/adminproducts" />">
   <!--             <input type="hidden" name="action" value="changeProduct" />  don't need this one-->
              <select size="10" name="oid"
              style="height: 250px; width: 100%"
              onchange="document.getElementById('formProductlist').submit();">
              <option></option>
              <c:forEach var="product" items="${adminProductsModel.products}">
              <c:set var="selected" value=""></c:set> 
              <c:if test="${product.oid == adminProductsModel.product.oid}">
              <c:set var="selected" value="selected='selected'" />
              </c:if>             
              <option ${selected} value="${product.oid}">${product.productName} - ${product.price}</option>
              </c:forEach>
              </select>
              </form>
              </td>
              
              <td sytle="width:70%">
              <h2>${adminProductsModel.actionMessage}</h2>
              <form id="formProduct" method="post"
            action="<c:url value="/adminproducts" />">
              <table border=1" sytle="width:85%">
              <tr>
              <td>OID</td>
              <td><input type="text" name="oid" value="${adminProductsModel.product.oid}" readonly="readonly" /></td>
              </tr>
              
              <tr>
              <td>Product Name</td>
              <td><input type="text" name="productName" value="${adminProductsModel.product.productName}" /></td>
              </tr>
              
              <tr>
              <td>Price</td>
              <td><input type="text" name="price" value="${adminProductsModel.product.price}" /></td>
              </tr>
              
              <tr>
              <td>Inv. Quntity</td>
              <td><input type="text" name="invQuantity" value="${adminProductsModel.product.inventoryQty}" /></td>
              </tr>
              
              <tr>
              <td>Description</td>
              <td><textarea name="description" cols="50" rows="4">${adminProductsModel.product.description}</textarea></td>
              </tr>
              
              <tr>
              <td></td>
              <td>
              <input type="submit" name="action" value="Update" />
              <input type="submit" name="action" value="Cancel" />
              <input type="submit" name="action" value="Delete" />
              </td>
              </tr>
              
              </table>
              </form>
              </td>
          </tr>
        
        </table>   
    </jsp:body>
</t:template>
