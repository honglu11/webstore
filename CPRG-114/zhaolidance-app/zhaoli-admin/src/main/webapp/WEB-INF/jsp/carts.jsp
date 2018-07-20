<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>

    <jsp:attribute name="title">My Store</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
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
                      <th width="60%">Customer</th>
                      <th>Date</th>
                      <th>Status</th>
                    </tr>
                  </thead>
                </table>
                  
              </div> 
            </div>
          </div>
      
          <div class="col-sm-6">
            <div class="card">
              <div class="card-header">Cart Details</div>
              <div class="card-body">
                <form id="uomform" method="post">
                  <div class="form-group">
                    <label for="oid">oid</label>
                    <input id="oid" type="text" value="" class="form-control" readonly="readonly">
                  </div>
                </form>
              </div> 
            </div>
          </div>
        </div>          
    </jsp:body>
</t:template>
