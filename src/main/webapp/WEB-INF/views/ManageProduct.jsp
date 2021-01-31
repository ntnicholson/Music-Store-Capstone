
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>#productTable img{
    max-width: 100px;
    max-height: 100px;
    
}</style>
<head>
<meta charset="ISO-8859-1">
<%-- <%@ include file="../views/css/bootstrap.html"%> --%>
<title>Display Products</title>
</head>
<body>
<jsp:include page="adminDasboard.jsp" />
<br/>
<div class="container">
<form method="post">
	<table class="table table-striped" id="productTable">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Image</th>
				<th>Name</th>
				<th>Condition</th>
				<th>Description</th>
				<th>Price</th>
				<th>Inventory</th>
				<th>Manage</th>
			</tr>
			<c:forEach items="${productList}" var="productList">
				<tr>
					<td><c:out value="${productList.id}"></c:out></td>
					<td><a href=# target=_blank><img src="data:image/jpg;base64,${productList.base64Image}" alt="No image"></a></td>
					<td><c:out value="${productList.name}"></c:out></td>
					<td><c:out value="${productList.condition}"></c:out></td>
					<td><c:out value="${productList.description}"></c:out></td>
					<td><c:out value="${productList.price}"></c:out></td>
					<td><c:out value="${productList.inventoryCount}"></c:out></td>
<%-- 					<td><c:out value="${productList.available}"></c:out></td> --%>
					<td><a href="update/${productList.id}" type="submit"><i class="material-icons">edit</i></a>
					<a href="delete/${productList.id}" type="submit"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
</form>
<div class="btn">
<a href="create"><button type="submit" name="manage" value="Create" class="btn btn-success">Create Product</button></a>
</div>
</div>
</div>
</body>
</html>