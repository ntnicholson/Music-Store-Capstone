<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Display Tasks</title>
</head>
<body>
<jsp:include page="dynamicNavbar.jsp" />
<br/>
<div class="container">
<form method="post">
	<table class="table table-striped">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Genre</th>
				<th>Manage</th>
			</tr>
			<c:forEach items="${categoryList}" var="categoryList">
				<tr>
					<td><c:out value="${categoryList.id}"></c:out></td>
					<td><c:out value="${categoryList.name}"></c:out></td>
					<td><c:out value="${categoryList.genre.name}"></c:out></td>
					<td><a href="update/${categoryList.id}" type="submit"><i class="material-icons">edit</i></a>
					<a href="delete/${categoryList.id}" type="submit" id="${categoryList.id}"><i class="material-icons">delete</i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
</form>
<div class="btn">
<a href="create"><button type="submit" name="manage" value="Create" class="btn btn-success">Create Task</button></a>
</div>
</div>
</div>
</body>
</html>