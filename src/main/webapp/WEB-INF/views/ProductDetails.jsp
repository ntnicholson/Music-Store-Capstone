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
	object-fit: contain;
}
</style>
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Display Products</title>
</head>
<body>
	<jsp:include page="dynamicNavbar.jsp" />
	<br />
	<div class="container">	
		<div class="row row-cols-1 row-cols-md-3 g-4">
		<form class="form" method="post">
		<div class="" id="cardImage">
					<div class="card">
						<a href=# target=_blank><img class="card-img-top"
							src="data:image/jpg;base64,${product.base64Image}"
							alt="No image"></a>
						<div class="card-body">
							<h4 class="card-title">
								<c:out value="${product.name}"></c:out>
							</h4>
							<h6 class="card-subtitle mb-2 text-muted">
								$
								<c:out value="${product.price}"></c:out>
							</h6>
							<c:out value="${product.id}"></c:out>
							<%-- 					<td><c:out value="${productList.available}"></c:out></td> --%>
						</div>
					<button class="btn btn-default" type="submit">Add to Cart</button></a>
					</div>
				</div>
				</form>
				
		</div>
	</div>
</body>
</html>