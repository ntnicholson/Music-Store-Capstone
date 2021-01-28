<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--     <%@ page import="com.hcl.model.User"%> --%>
    <%@ page session="true" %>
    <% String name = (String)session.getAttribute("currentsess"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Dashboard</title>
</head>
<body>
 <jsp:include page="dynamicNavbar.jsp" />
<br/><br/>
<div class="container d-flex justify-content-center align-items-center">
<div class="row">
<div><h1>Application Manager</h1></div>
<div class="col-md"><em>Select an entity to manage</em></div>	
<div class="btn"><a href="/admin/product/manage"><button type="button" class="btn btn-primary">Products</button></a></div>
<div class="btn"><a href="/admin/genre/manage"><button type="button" class="btn btn-primary">Genres</button></a></div>
</div>
</div>

</body>
</html>