
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% int counter = 0; %>
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
		<c:forEach items="${productList}" var="productList">
			
				<div class="" id="cardImage">
					<div class="card">
					<a href=# target=_blank><img class="card-img-top"
								src="data:image/jpg;base64,${productList.base64Image}"
								alt="No image"></a>
						<div class="card-body">
							<h4 class="card-title"><c:out value="${productList.name}"></c:out></h4>
							<h6 class="card-subtitle mb-2 text-muted">$<c:out value="${productList.price}"></c:out></h6>
							<c:out value="${productList.id}"></c:out>
							
							
							<%-- 					<td><c:out value="${productList.available}"></c:out></td> --%>
						</div>
					</div>
				</div>
		</c:forEach>		
</div>
	</div>
</body>
</html>