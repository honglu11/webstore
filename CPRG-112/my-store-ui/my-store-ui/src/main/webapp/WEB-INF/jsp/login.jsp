<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
  <jsp:attribute name="title">My Store</jsp:attribute>
  <jsp:attribute name="extraJavascript">
    <script type="text/javascript">
        document.getElementById("j_username").focus();
    </script>
  </jsp:attribute>
  <jsp:body>

<c:if test="${not empty pageContext.request.userPrincipal}">
You are already register. Log out if you want to register as someone else
</c:if>

<c:if test="${empty pageContext.request.userPrincipal}">

<div class="row">
  <div class="col-sm-5">
    <div class="panel panel-info">
      <div class="panel-heading">
        <h3 class="panel-title">Login</h3>
      </div>
      <div class="panel-body">
        <c:if test="${not empty param.error }">
        <div class="alert alert-danger">
          <strong>Invalid UserName/Password</strong>
        </div>
        </c:if>
        
        <form id="login-form" class="form-horizontal" method="POST" action="j_security_check">
          <div class="form-group">
            <label class="control-label col-sm-4" for="j_username">User Name:</label>
            <div class="col-sm-8">
              <input type="text" class="form-control" name="j_username" id="j_username" placeholder="Email" />
            </div>
          </div>
      
          <div class="form-group">
            <label class="control-label col-sm-4" for="password">Password:</label>
            <div class="col-sm-8">
              <input type="password" class="form-control" name="j_password" id="j_password" placeholder="Password" />
            </div>
          </div>
          <input class="btn btn-primary" type="submit" value="Login">
        </form>
      </div>
    </div>
  </div>
  
  <div class="col-sm-1">
    <br />
  </div>
  
  <div class="col-sm-6">
    <div class="panel panel-success">
      <div class="panel-heading">
        <h3 class="panel-title">Register</h3>
      </div>
    
      <div class="panel-body">
      
        <c:if test="${not empty registerModel.registerError}">
        <div class="alert alert-danger">
          <strong>${registerModel.registerError}</strong>
        </div>
        </c:if>
      
        <form id="register-form" class="form-horizontal" method="POST" action="<c:url value="/register" />" >
          <div class="form-group">
            <label class="control-label col-sm-4" for="firstName">First Name:</label>
            <div class="col-sm-8">
              <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First Name" value="${registerModel.person.firstName}"  />
              <strong>${registerModel.inputErrors['firstName']}</strong>
            </div>
          </div>
      
          <div class="form-group">
            <label class="control-label col-sm-4" for="lastName">Last Name:</label>
            <div class="col-sm-8">
              <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last Name" value="${registerModel.person.lastName}"  />
              <strong>${registerModel.inputErrors['lastName']}</strong>
            </div>
          </div>
      
          <div class="form-group">
            <label class="control-label col-sm-4" for="email">Email:</label>
            <div class="col-sm-8">
              <input type="text" class="form-control" name="email" id="email" placeholder="Email" value="${registerModel.person.email}"  />
              <strong>${registerModel.inputErrors['email']}</strong>
            </div>
          </div>
      
          <div class="form-group">
            <label class="control-label col-sm-4" for="password">Password:</label>
            <div class="col-sm-8">
              <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="${registerModel.person.password}"  />
              <strong>${registerModel.inputErrors['password']}</strong>
            </div>
          </div>
      
          <div class="form-group">
            <label class="control-label col-sm-4" for="confirmPassword">Confirm Password:</label>
            <div class="col-sm-8">
              <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" id="confirmPassword" />
              <strong>${registerModel.inputErrors['confirmPassword']}</strong>
            </div>
          </div>
          <input type="hidden" name="action" value="register" />
          <input class="btn btn-primary" type="submit" value="Register">
        </form>
      </div>
    </div>
  </div>
</div>
</c:if>

  </jsp:body>
</t:template>
