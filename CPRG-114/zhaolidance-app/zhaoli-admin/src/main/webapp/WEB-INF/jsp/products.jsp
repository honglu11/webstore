<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>

    <jsp:attribute name="title">My Store</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>
        <h1>Products</h1>
        
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
      
          <div class="col-sm-6">
            <div class="card">
              <div class="card-header">Product Details</div>
              <div class="card-body">
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
                    <button type="submit" class="btn btn-success">Submit</button>
                  </span>
                </form>
              </div> 
            </div>
          </div>
        </div>          
        
    </jsp:body>
</t:template>
