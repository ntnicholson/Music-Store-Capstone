<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Update Task</title>
</head>
<body style="background-color:skyblue;">
<jsp:include page="dynamicNavbar.jsp" />
<br/>
	<div class="d-flex justify-content-center align-items-center container ">
	<h2 style="color:white;"> Update Genre</h2>
		<div class="form-control">
		<form method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Genre</span> 
				<input type="text" name="name" class="form-control" value="${genre.name}" required><br /></div>

		<div class="btn btn-group">
			<div class="btn"><button type="reset" class="btn btn-danger form-control">Reset</button></div>
			<br />
			<div class="btn"><button type="submit" class="btn btn-success">Submit</button></div>
			<br />
			</div>
		</form>
	</div>
	</div>
	</div>
</body>
</html>