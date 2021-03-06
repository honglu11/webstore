<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<t:template>
  <jsp:attribute name="title">${productListModel.title}</jsp:attribute>
  <jsp:attribute name="extraJavascript" />

  <jsp:body>
        <h1>${adminProductModel.pageName}</h1>
        
        <table border="1" style="width: 85%">
            <tr>
                <td style="width: 30%">
                <form id="formProductList" method="post"
            action="<c:url value="/adminproduct" />">
                  <select size="10" name="oid"
              style="height: 250px; width: 100%"
              onchange="document.getElementById('formProductList').submit();">
                  <option></option>  
                  <c:forEach var="product"
                items="${adminProductModel.products}">
                    <c:set var="selected" value="" />
                      <c:if
                  test="${product.oid == adminProductModel.product.oid}">
                        <c:set var="selected"
                    value="selected='selected'" />
                      </c:if>
                    <option value="${product.oid}">${product.productName}</option>
                  </c:forEach>
                  </select>
                </form>
                
                </td>
                
                <td style="width: 70%">
                  <h2>${adminProductModel.actionMessage}</h2>
                  <form id="formProduct" method="post"
            action="<c:url value="/adminproduct" />">
                  <table border="1" style="width: 85%">
                      <tr>
                          <td>OID</td>
                          <td><input type="text" name="oid"
                  value="${adminProductModel.product.oid}"
                  readonly="readonly" /></td>
                      </tr>
                      <tr>
                          <td>Product Name</td>
                          <td>
                          <c:set var="readOnly" value="" />
                          <c:if
                    test="${not empty adminProductModel.product.oid}">
                              <c:set var="readOnly"
                      value="readonly='readonly'" />
                          </c:if>                         
                          <input type="text" name="productName" ${readOnly}
                  value="${adminProductModel.product.productName}" />
                          <strong>${adminProductModel.inputErrors['productName']}</strong>
                          </td>
                      </tr>
                      <tr>
                          <td>Price</td>
                          <td><input type="text" name="price"
                  value="${adminProductModel.price}" />
                  <strong>${adminProductModel.inputErrors['price']}</strong>
                  </td>
                      </tr>
                      <tr>
                          <td>Inv.Quantity</td>
                          <td><input type="text" name="invQuantity"
                  value="${adminProductModel.invQuantity}" />
                  <strong>${adminProductModel.inputErrors['invQuantity']}</strong>
                  </td>
                      </tr>
                      <tr>
                          <td>Description</td>
                          <td><textarea name="description"
                    cols="50" rows="4">${adminProductModel.product.description}</textarea>
                    <strong>${adminProductModel.inputErrors['description']}</strong>
                    </td>
                      </tr>
                      <tr>
                          <td></td>
                          <td>
                              <input type="submit" name="action"
                  value="Update" />
                              <input type="submit" name="action"
                  value="Cancel" />
                              <input type="submit" name="action"
                  value="Delete" />
                          </td>
                      </tr>
                  </table>
                  </form>
                </td>
            </tr>
        
        </table>
        
    </jsp:body>
</t:template>

