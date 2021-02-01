<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../views/css/bootstrap.html"%>
<style>
#warning {

  font-size: 192px;  /* icon size */
}
</style>
<meta charset="ISO-8859-1">

<title>Delete Task</title>
</head>
<body style="background-color:indianred;">
<jsp:include page="dynamicNavbar.jsp" />
<br/>
	<div class="d-flex flex-row justify-content-center align-items-center container ">
	<div class="row">
	<h2 style="color:white;"><i class="material-icons" id="warning"> warning_amber </i> Delete:"${genre.name}"</h2><br/>
	</div>
	</div>
	<div class="d-flex flex-row justify-content-center align-items-center container">
	<div class="form-control">
		<form method="post">
			<div class="btn-group">
			<div class="btn"><button type="submit" class="btn btn-danger">Delete</button></div>
			<div class="btn"><a href="/admin/genre/manage"><button type="button" class="btn btn-success">Cancel</button></a></div>
		</div>
		</form>
	</div>
	</div>
</body>
</html>