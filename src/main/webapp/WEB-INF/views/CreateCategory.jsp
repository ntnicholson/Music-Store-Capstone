<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Create Category</title>
<%@ include file="bootstrap.html"%>
</head>
<body style="background-color: forestgreen;">
	<br />
	<div
		class="d-flex justify-content-center align-items-center container ">
		<h2 style="color: white;">Create Category</h2>
		<div class="form-control">
			<form method="post">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Category</span> <input
						type="text" name="name" class="form-control" required><br />
				</div>

				<select class="form-select" name="genre" aria-label="Default select example">
					<c:forEach items="${genreList}" var="genreList">
						<option value="${genreList.id}"><c:out value="${genreList.name}"></c:out></option>
					</c:forEach>
				</select>

				<div class="btn btn-group">
					<div class="btn">
						<button type="reset" class="btn btn-danger form-control">Clear</button>
					</div>
					<br />
					<div class="btn">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
					<br />
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>