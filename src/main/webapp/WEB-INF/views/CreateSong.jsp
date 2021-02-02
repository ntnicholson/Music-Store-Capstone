<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Create Song</title>
<%@ include file="../views/css/bootstrap.html"%>
</head>
<body style="background-color:forestgreen;">
<jsp:include page="dynamicNavbar.jsp" />
<br/>
	<div class="d-flex justify-content-center align-items-center container ">
	<h2 style="color:white;"> Create Song </h2>
		<div class="form-control">
		<form method="post" enctype="multipart/form-data">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Name</span> 
				<input type="text" name="name" class="form-control" required><br /></div>
				
				<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Category</span> 
					<select class="form-select" name="category" aria-label="Select a Category">
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
			
<!-- 			<div class="input-group mb-3"> -->
<!-- 			<span class="input-group-text" id="basic-addon1">Hidden </span>  -->
<!-- 			<input type="radio" placeholder="Price..." name="true" value="True" class="form-control"><br /> -->
<!-- 			<input type="radio" placeholder="Price..." name="false" class="form-control"><br /></div> -->

			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Artist</span> 
				<input type="text" name="artist" class="form-control" required><br /></div>
				
							<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Style</span> 
				<input type="text" name="style" class="form-control" required><br /></div>
				
							<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Format</span> 
				<input type="text" name="format" class="form-control" required><br /></div>
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