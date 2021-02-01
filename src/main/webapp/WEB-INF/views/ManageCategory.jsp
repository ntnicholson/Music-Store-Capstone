<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<!Doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>Dashboard</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/dashboard/">



<!-- Bootstrap core CSS -->
<%@ include file="../views/css/bootstrap.html"%>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

#productTable img {
	max-width: 100px;
	max-height: 100px;
}
</style>


<!-- Custom styles for this template -->
<%@ include file="../views/css/dashboard.html"%>
</head>
<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/home">Music
			Store</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link"
				href="/logout">Sign out</a></li>
		</ul>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="/admin/dashboard"> <span data-feather="home"></span>
								Dashboard
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/admin/product/manage"> <span
								data-feather="shopping-cart"></span> Products
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/admin/genre/manage"> <span data-feather="users"></span>
								Genres
						</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/admin/category/manage"> <span
								data-feather="bar-chart-2"></span> Categories
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/orders/manage"> <span
								data-feather="layers"></span> Orders
						</a></li>
					</ul>

					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Saved reports</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Current month
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Last quarter
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Social engagement
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Year-end sale
						</a></li>
					</ul>
				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h2>Manage Categories</h2>
					<div class="btn">
						<a href="create"><button type="submit" name="manage"
								value="Create" class="btn btn-sm btn-success">Create</button></a>
					</div>
				</div>
				<div class="table-responsive">
					<form method="post">
						<table class="table table-striped">
							<tbody>
								<tr>
									<th>ID</th>
									<th>Category</th>
									<th>Genre</th>
									<th>Manage</th>
								</tr>
								<c:forEach items="${categoryList}" var="categoryList">
									<tr>
										<td><c:out value="${categoryList.id}"></c:out></td>
										<td><c:out value="${categoryList.name}"></c:out></td>
										<td><c:out value="${categoryList.genre.name}"></c:out></td>
										<td><a href="update/${categoryList.id}" type="submit"><i
												class="material-icons">edit</i></a> <a
											href="delete/${categoryList.id}" type="submit"
											id="${categoryList.id}"><i class="material-icons">delete</i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br> <br>
					</form>
				</div>

			</main>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script src="dashboard.js"></script>
</body>
</html>