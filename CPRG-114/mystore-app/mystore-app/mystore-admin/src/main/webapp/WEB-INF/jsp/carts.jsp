<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>

    <jsp:attribute name="title">My Store</jsp:attribute>
    <jsp:attribute name="extraJavascript">
    <script type="text/javascript">
    $(document).ready(function() {
        var table = $('#cartlist').DataTable( {
            lengthChange: false,
            buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
        } );
     
        table.buttons().container()
            .appendTo( '#cartlist_wrapper .col-md-6:eq(0)' );
    } );
    </script>
    </jsp:attribute>
    
    <jsp:body>
        <h1>Carts</h1>

        <div class="row">
          <div class="col-sm-5">
          
            <div class="card">
              <div class="card-header">Carts</div>
              <div class="card-body">
                <table id="cartlist" class="table table-striped table-bordered" style="width:100%">
                  <thead>
                    <tr>
                      <th width="40%">Customer Email</th>
                      <th>Date</th>
                      <th>Status</th>
                    </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="cart" items="${shoppingCartModel.allCarts}">
                   <tr>
                       <td><a href="<c:url value="/ui/carts/${cart.oid}" />" >${cart.customer.email}</td>
                       <td>${cart.shippedDate}</td>
                       <td>${cart.status}</td>
                   </tr>                   
                   </c:forEach>                  
                  </tbody>            
                </table>                  
              </div> 
            </div>
          </div>
          
          <div class="col-sm-6">
            <div class="card">
              <div class="card-header">
                Cart Details              
              </div>
               <div class="card-body">
               
                 <c:if test="${not empty shoppingCartModel.successMessage}">
                 <div class="alert alert-success" role="alert">
                      ${shoppingCartModel.successMessage}
                 </div>
                 </c:if>
                 
                 <c:if test="${not empty shoppingCartModel.errorMessage}">
                 <div class="alert alert-danger" role="alert">
                      ${shoppingCartModel.errorMessage}
                 </div>
                 </c:if> 
              
                <form id="uomform" method="post">
                  <div class="form-group">
                    <label for="oid">oid</label>
                    <input id="oid" type="text" value="${shoppingCartModel.cart.oid}" class="form-control" readonly="readonly">
                  </div>
                  
                  <div class="form-group">
                    <label for="customer">Customer Email</label>
                         <input id="customer" name="customer" value="${shoppingCartModel.cart.customer.email}" type="text" class="form-control" readonly="readonly">
                  </div>
                  
                  <div class="form-group">
                    <label for="shippedDate">Shipped Date</label>                    
                    <input id="shippedDate" name="shippedDate" value="${shoppingCartModel.cart.shippedDate}" type="text" class="form-control" readonly="readonly">
                  </div>             

                  <div class="form-group">                  
                    <label for="status">Status</label>
                    <input id="status" name="status" value="${shoppingCartModel.cart.status}" type="text" class="form-control">
                  </div>

             <div class="form-group_items">                    
                    <input id="oid" name="oid" type="hidden" value="${shoppingCartModel.cart.oid}" class="form-control" readonly="readonly">
                  </div>     

              <div class="card-header">Carts Items</div>
              <div class="card-body">
                <table id="itemlist" class="table table-striped table-bordered" style="width:100%">
                  <thead>
                    <tr>
                      <th width="40%">Oid</th>
                      <th>Product</th>
                      <th>In Stock</th>
                      <th>Price</th>
                      <th>Quantity</th>
                    </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="item" items="${shoppingCartModel.itemsByCart}">
                   <tr>
                       <td>${item.oid}</td>
                       <td>${item.product.name}</td>
                       <td>${item.product.inventoryQuantity}</td>
                       <td>${item.price}</td>
                       <td>${item.quantity}</td>
                   </tr>                   
                   </c:forEach>                  
                  </tbody>            
                </table>                          

          </div>
          <span class="float-right pt-1"> 
                    <button type="submit" name="action" value="statuschange" class="btn btn-primary">Change Cart Status</button>
          </span>
          </form>
          </div>
          </div>
                                     
                  <form id="complete" action="<c:url value="/ui/carts" />" method="post">
                  <div class="form-group_complete">                    
                    <input id="oid" name="oid" type="hidden" value="${shoppingCartModel.cart.oid}" class="form-control" readonly="readonly">
                  </div>
                  <span class="float-right pt-1"> 
                    <button type="submit" name="action" value="complete" class="btn btn-primary">Complete</button>
                  </span>
                  
                </form>
                
                <form id="cancel" action="<c:url value="/ui/carts" />" method="post">   
                  <div class="form-group_cancel">                    
                    <input id="oid" name="oid" type="hidden" value="${shoppingCartModel.cart.oid}" class="form-control" readonly="readonly">
                  </div> 
                   <span class="float-right pt-1">
                      <button type="submit" name="action" value="cancel" class="btn btn-primary">Cancel</button>
                   </span>
                 </form>
              </div> 
          
        
    </jsp:body>
</t:template>
