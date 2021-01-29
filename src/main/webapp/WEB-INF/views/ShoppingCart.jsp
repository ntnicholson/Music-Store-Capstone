
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
#productTable img {
	max-width: 100px;
	max-height: 100px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Shopping Cart</title>
</head>
<body>
	<jsp:include page="dynamicNavbar.jsp" />
	<br />
	<div class="container d-flex justify-content-end">
			<form method="post" action="">
				<div class="col-md-8">
					<table class="table table-borderless" id="productTable">
						<tbody>
							<tr>
								<th>ID</th>
								<th>Image</th>
								<th>Name</th>
								<th>Condition</th>
								<th>Description</th>
								<th>Price</th>
								<th>Inventory</th>
								<!-- 				<th>Hidden</th> -->
								<th>Manage</th>
							</tr>
							<c:forEach items="${productList}" var="productList">
								<tr>
									<td><c:out value="${productList.id}"></c:out></td>
									<td><a href=# target=_blank><img
											src="data:image/jpg;base64,${productList.base64Image}"
											alt="No image"></a></td>
									<td><c:out value="${productList.name}"></c:out></td>
									<td><c:out value="${productList.condition}"></c:out></td>
									<td><c:out value="${productList.description}"></c:out></td>
									<td><c:out value="${productList.price}"></c:out></td>
									<td><c:out value="${productList.inventoryCount}"></c:out></td>
									<%-- 					<td><c:out value="${productList.available}"></c:out></td> --%>
									<td><a href="remove/${productList.id}" type="submit"><i
											class="material-icons">remove_shopping_cart</i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br> <br>
				</div>
				
			</form><div class="btn">
				<a href="create"><button type="submit" name="manage"
						value="Create" class="btn btn-success">Complete Order</button></a>
			</div>
		</div>
</body>
</html>