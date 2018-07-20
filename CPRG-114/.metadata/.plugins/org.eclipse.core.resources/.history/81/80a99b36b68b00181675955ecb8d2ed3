<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${pageContext.request.locale}" />
<fmt:setBundle basename="lang" var="lang" />

<t:template>

    <jsp:attribute name="title">My Store</jsp:attribute>
    <jsp:attribute name="extraJavascript">
    <script type="text/javascript">
    $(document).ready(function() {
        $('#productlist').DataTable();
    });
    </script>
    </jsp:attribute>
    
    <jsp:body>
        <h1><fmt:message key="menu.products" bundle="${lang}" /></h1>         
        
        <div class="row">
          <div class="col-sm-5">
          
            <div class="card">
              <div class="card-header">Products</div>
              <div class="card-body">             
                <table id="productlist" class="table table-striped table-bordered" style="width:100%">
                  <thead>
                    <tr>
                      <th>Name</th>
                      <th width="60%">Description</th>
                      <th>Price</th>
                      <th>Qty</th>
                    </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="product" items="${Products.allProducts}">
                   <tr>
                       <td><a href="<c:url value="/ui/products/${product.oid}" />" >${product.name}</td>
                       <td>${product.description}</td>
                       <td>${product.price}</td>
                       <td>${product.inventoryQuantity}</td>
                   </tr>                   
                   </c:forEach>                  
                  </tbody>
                </table>
                  
              </div> 
            </div>
          </div>         
        
    </jsp:body>
</t:template>
