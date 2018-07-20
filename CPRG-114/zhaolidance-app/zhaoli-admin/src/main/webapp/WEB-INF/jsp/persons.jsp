<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>

    <jsp:attribute name="title">Zhao Li Dance</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>
        <h1>Person Admin</h1>
        
        <div class="row">
          <div class="col-sm-5">
          
            <div class="card">
              <div class="card-header">People</div>
              <div class="card-body">
                <table id="personlist" class="table table-striped table-bordered" style="width:100%">
                  <thead>
                    <tr>
                      <th>Name</th>
                      <th>Email</th>
                    </tr>
                  </thead>
                   <tbody>
                   <c:forEach var="person" items="${Persons.allPersons}">
                   <tr>
                       <td><a href="<c:url value="/ui/persons/${person.oid}" />" >${person.lastName}</td>
                       <td>${person.email}</td>
                   </tr>                   
                   </c:forEach>                  
                  </tbody>
                </table>
                  
              </div> 
            </div>
          </div>
      
          <div class="col-sm-6">
            <div class="card">
              <div class="card-header">Person</div>
              <div class="card-body">
                <form id="uomform" method="post">
                  <div class="form-group">
                    <label for="oid">oid</label>
                    <input id="oid" type="text" value="${Persons.person.oid}" class="form-control" readonly="readonly">
                  </div>

                  <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input id="firstName" name="firstName" value="${Persons.person.firstName}" type="text" class="form-control">
                  </div>

                  <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input id="lastName" name="lastName" value="${Persons.person.lastName}" type="text" class="form-control">
                  </div>
                  
                  <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" name="email" value="${Persons.person.email}" type="text" class="form-control">
                  </div>
                  
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" value="" type="password" class="form-control">
                  </div>

                  <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input id="confirmPassword" name="confirmPassword" value="" type="password" class="form-control">
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