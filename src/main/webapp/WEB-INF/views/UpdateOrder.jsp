<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="../views/css/bootstrap.html"%>
<title>Update Order</title>
</head>
<body style="background-color:skyblue;">
<jsp:include page="dynamicNavbar.jsp" />
<br/>
	<div class="d-flex justify-content-center align-items-center container ">
	<h2 style="color:white;"> Update Order</h2>
		<div class="form-control">
		<form method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Status</span> 
				<input type="text" name="status" class="form-control" value="${order.status}" required><br /></div>

		<div class="btn btn-group">
			<div class="btn"><button type="reset" class="btn btn-danger form-control">Reset</button></div>
			<br />
			<div class="btn"><button type="submit" class="btn btn-success">Submit</button></div>
			<br />
			</div>
		</form>
	</div>
	</div>
</body>
</html>