<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="../views/css/bootstrap.html"%>
<title>Update Category</title>
</head>
<body style="background-color:skyblue;">
<jsp:include page="dynamicNavbar.jsp" />
<br/>
	<div class="d-flex justify-content-center align-items-center container ">
	<h2 style="color:white;"> Update Category</h2>
		<div class="form-control">
		<form method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Name</span> 
				<input type="text" name="name" class="form-control" required><br /></div>
				
				<div class="input-group mb-3">
					<select class="form-select" name="category" aria-label="Default select example">
					<c:forEach items="${categoryList}" var="categoryList">
						<option value="${categoryList.id}"><c:out value="${categoryList.name}"></c:out></option>
					</c:forEach>
					</select>
				</div>
			
			<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Image</span> 
			<input type="file" placeholder="upload" name="image" id="image" class="form-control"><br /></div>

			<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Condition</span> 
			<input type="text" placeholder="condition" name="condition" class="form-control"><br /></div>

			<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Description</span> 
			<textarea placeholder="Write description here..." name="description" class="form-control"></textarea><br /></div>
			
<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Price</span> 
			<input type="number" placeholder="Price..." name="price" class="form-control"><br /></div>

			<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Inventory Count</span> 
			<input type="number" placeholder="Number of products available for sell..." name="inventoryCount" class="form-control"><br /></div>
			
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