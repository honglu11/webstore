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
      $('#chargetypeslist').DataTable();
    });
    </script>
    </jsp:attribute>
    
    <jsp:body>
        <h1><fmt:message key="menu.products" bundle="${lang}" /></h1>    
        
        <table id="chargetypeslist" class="table table-striped table-bordered" style="width:100%">
          <thead>
            <tr>
              <th width="30%">Name</th>
              <th width="60%">Description</th>
              <th width="10%">In Stock</th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
        
    </jsp:body>
</t:template>
