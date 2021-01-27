<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Delete Task</title>
</head>
<body style="background-color:indianred;">
<jsp:include page="dynamicNavbar.jsp" />
<br/>
	<div class="d-flex justify-content-center align-items-center container ">
	<h2 style="color:white;">Delete: "${genre.name}"</h2>
	<div class="form-control">
		<form method="post">
			<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Start Date</span> 
			<input type="date" value="placeholder" readOnly name="startDate" class="form-control"><br /></div>
			<div class="btn-group">
			<div class="btn"><button type="submit" class="btn btn-danger">Delete</button></div>
			<div class="btn"><a href="/admin/genre/manage"><button type="button" class="btn btn-success">Cancel</button></a></div>
		</div>
		</form>
	</div>
	</div>
</body>
</html>