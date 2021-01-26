<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<%@ include file="bootstrap.html"%>
<title>Register</title>
</head>
<body style="background-color:indianred;">
<br/><br/><br/><br/>
<div class="d-flex justify-content-center align-items-center container-fluid ">
<div class="row">
	<div class="form-control">
	<form:form method="POST" action="/api/auth/signup" modelAttribute="userSignup" class="justify-content-center">
	<div class="form-group">
    <form:label path="username"><em>Name</em></form:label>
    <form:input path="username" class="form-control"/>
    </div>
    <div class="form-group">
    <form:label path="role"><em>Role</em></form:label>
    <form:input path="role" class="form-control"/>
    </div>
	<div class="form-group">
    <form:label path="email"><em>Email</em></form:label>
    <form:input path="email" class="form-control"/>
	</div>
    <div class="form-group">
    <form:label path="password"><em>Password</em></form:label>
    <form:input path="password" class="form-control"/>
    </div><br/>
    <input type="submit" value="Submit" class="btn btn-primary mb-2" />
</form:form>
</div>
</div>
</body>
</html>