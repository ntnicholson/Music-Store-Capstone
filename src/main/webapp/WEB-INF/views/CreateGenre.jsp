<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
<%@ include file="bootstrap.html"%>
</head>
<body style="background-color:forestgreen;">
<br/>
	<div class="d-flex justify-content-center align-items-center container ">
	<h2 style="color:white;"> Create Genre </h2>
		<div class="form-control">
		<form method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Genre</span> 
				<input type="text" name="name" class="form-control" required><br /></div>

		<div class="btn btn-group">
			<div class="btn"><button type="reset" class="btn btn-danger form-control">Clear</button></div>
			<br />
			<div class="btn"><button type="submit" class="btn btn-primary">Submit</button></div>
			<br />
			</div>
		</form>
	</div>
	</div>
	</div>
</body>
</html>