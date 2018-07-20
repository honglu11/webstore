<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${pageContext.request.locale}" />
<fmt:setBundle basename="lang" var="lang" />

<t:template>

    <jsp:attribute name="title">My Store</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
          
          <div class="col-sm-6">
            <div class="card">
              <div class="card-header">
                Product Details  
              </div>
              <div class="card-body">
                 
                 <c:if test="${not empty Products.successMessage}">
                 <div class="alert alert-success" role="alert">
                      ${Products.successMessage}
                 </div>
                 </c:if>
                 
                 <c:if test="${not empty Products.errorMessage}">
                 <div class="alert alert-danger" role="alert">
                      ${Products.errorMessage}
                 </div>
                 </c:if>   
    
              
                <form id="uomform" method="post">
                  <div class="form-group">
                    <label for="oid">oid</label>
                    <input id="oid" type="text" value="${Products.product.oid}" class="form-control" readonly="readonly">
                  </div>
                  
                  <div class="form-group">               
                    <label for="name">Name</label>                    
                    <input id="name" name="name" value="${Products.product.name}" type="text" class="form-control">
                  </div>
                  
                  <div class="form-group">
                    <label for="description">Description</label>                    
                    <input id="description" name="description" value="${Products.product.description}" type="text" class="form-control">
                  </div>             

                  <div class="form-group">                  
                    <label for="price">Price</label>                    
                    <input id="price" name="price" value="${Products.product.price}" type="text" class="form-control">
                  </div>
                  
                  <div class="form-group">
                    <label for="inventoryQuantity">Inventory Quantity</label>                    
                    <input id="inventoryQuantity" name="inventoryQuantity" value="${Products.product.inventoryQuantity}" type="text" class="form-control">
                  </div>
                  
                  <span class="float-right pt-1">
                    <button type="submit" name="action" value="persist" class="btn btn-primary">Submit</button>
                  </span>
                  
                </form>
              </div> 
            </div>
          </div>
        </div>
        
    </jsp:body>
</t:template>
