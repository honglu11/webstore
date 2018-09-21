<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>
    <jsp:attribute name="title">${adminPersonModel.title}</jsp:attribute>
    <jsp:attribute name="extraJavascript" />
    
    <jsp:body>
        <h1>${adminPersonModel.pageName}</h1>
        
        <table border="1" style="width:85%">
            <tr>
                <td style="width:30%">
                <form id="formPersonList" method="post" action="<c:url value="/adminperson" />" >
                  <select size="10" name="oid" style="height:250px;width:100%" onchange="document.getElementById('formPersonList').submit();" >
                  <option></option>  
                  <c:forEach var="person" items="${adminPersonModel.persons}">
                    <c:set var="selected" value="" />
                      <c:if test="${person.oid == adminPersonModel.person.oid}">
                        <c:set var="selected" value="selected='selected'" />
                      </c:if>
                    <option value="${person.oid}">${person.firstName} ${person.lastName}</option>
                  </c:forEach>
                  </select>
                </form>
                
                </td>
                
                <td style="width:70%">
                  <h2>${adminPersonModel.actionMessage}</h2>
                  <form id="formProduct" method="post" action="<c:url value="/adminperson" />" >
                  <table border="1" style="width:85%" >
                      <tr>
                          <td>OID</td>
                          <td><input type="text" name="oid" value="${adminPersonModel.person.oid}" readonly="readonly" /></td>
                      </tr>
                      <tr>
                          <td>First Name</td>
                          <td>
                          <input type="text" name="firstName" value="${adminPersonModel.person.firstName}" />
                          <strong>${adminPersonModel.inputErrors['firstName']}</strong>
                          </td>
                      </tr>
                      <tr>
                          <td>Last Name</td>
                          <td><input type="text" name="lastName" value="${adminPersonModel.person.lastName}" />
                          <strong>${adminPersonModel.inputErrors['lastName']}</strong></td>
                      </tr>
                      <tr>
                          <td>Email</td>
                          <td>
                          <c:set var="readOnly" value="" />
                          <c:if test="${not empty adminPersonModel.person.oid}">
                          <c:set var="readOnly='readOnly'" />
                          </c:if>
                          <input type="text" name="email" ${readOnly} value="${adminPersonModel.person.email}" />
                          <strong>${adminPersonModel.inputErrors['email']}</strong>
                          </td>
                      </tr>
                      <tr>
                          <td>Password</td>
                          <td>                         
                          <input type="text" name="password" value="${adminPersonModel.person.password}" />
                          <strong>${adminPersonModel.inputErrors['password']}</strong>
                          </td>
                      </tr>
                      <tr>
                          <td>Role</td>
                          <td>
                          <input type="text" name="role" value="${adminPersonModel.person.role}" />
                          <strong>${adminPersonModel.inputErrors['role']}</strong>
                          </td>
                      </tr>                      
                      <tr>
                          <td></td>
                          <td>
                              <input type="submit" name="action" value="Update"/>
                              <input type="submit" name="action" value="Cancel"/>
                              <input type="submit" name="action" value="Delete"/>
                          </td>
                      </tr>
                  </table>
                  </form>
                </td>
            </tr>
        
        </table>
        
    </jsp:body>
</t:template>

