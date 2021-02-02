<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int counter = 0;
%>
<!DOCTYPE html>
<html>
<style>
#cardImage img {
max-width: 100%;
max-height: 100%;

}
</style>
<head>
<meta charset="ISO-8859-1">
<%@ include file="../views/css/bootstrap.html"%>
<title>Display Products</title>
</head>
<body>
	<jsp:include page="dynamicNavbar.jsp" />
	<br />
	<div class="justify-content-center container">	
	<div class="card mb-3" style="max-width: auto;">
  <div class="row g-0">
    <div class="col-md-4" id="cardImage">
      <img src="data:image/jpg;base64,${product.base64Image}" alt="...">
    </div>
    <div class="col-md-8">
    <form method="post">
      <div class="card-body">
        <h3 class="card-title"><em><c:out value="${product.name}"></c:out></em></h3>
        <h5>$<c:out value="${product.price}"></c:out></h5>
        <p class="card-text"><c:out value="${product.description}"></c:out></p>
        <p class="card-text"><small class="text-muted">Category: <c:out value="${product.category.name}"></c:out></small></p>
      <a href="${product.id}"><button class="btn btn-success" type="submit">Add to Cart</button></a>
      </div>
      </form>
    </div>
  </div>
</div>
		
				
		</div>
</body>
</html>