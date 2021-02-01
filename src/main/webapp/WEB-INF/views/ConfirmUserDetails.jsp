<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="../views/css/bootstrap.html"%>
<title>Confirm Details</title>
</head>
<body style="background-color: skyblue;">
	<jsp:include page="dynamicNavbar.jsp" />
	<br />
	<div
		class="d-flex justify-content-center align-items-center container ">
		<h2 style="color: white;">Confirm Address</h2>
		<div class="form-control">
			<form method="post">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Name</span> <input
						type="text" name="username" class="form-control" value="${user.username}"
						readonly><br />
				</div>
				<div class="">
				<input type="hidden" name="id" class="form-control" value="${user.id}" required><br />
				<input type="hidden" name="password" class="form-control" value="${user.password}"><br />
				<input type="hidden" name="email" class="form-control" value="${user.email}" required><br />
				</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Phone</span> <input
							type="number" name="phone" class="form-control" value="${user.phone}"
							readonly><br />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Street Name</span> <input
							type="text" name="streetName" class="form-control" value="${user.streetName}"
							readonly><br />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Apartment #</span> <input
							type="number" name="apartmentNumber" class="form-control" value="${user.apartmentNumber}"
							readonly><br />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">City</span> <input
							type="text" name="city" class="form-control" value="${user.city}"
							readonly><br />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">State</span> <input
							type="text" name="state" class="form-control" value="${user.state}"
							readonly><br />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Country</span> <input
							type="text" name="country" class="form-control" value="${user.country}"
							readonly><br />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Zip Code</span> <input
							type="number" name="zipCode" class="form-control" value="${user.zipCode}"
							readonly><br />
					</div>
					
			</form>					
			<div class="btn btn-group">						
			<div class="btn">
							<a href="/submit/order"><button class="btn btn-success form-control">Place Order</button></a>
						</div>
						<div class="btn">
							<a href="/update/details"><button class="btn btn-danger form-control">Update Details</button></a>
						</div>
		</div>
	</div>
</body>
</html>