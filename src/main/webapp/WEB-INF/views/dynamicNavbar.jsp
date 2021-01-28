<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.capstone.entity.User"%>
    <%@ page import="com.capstone.payload.response.JwtResponse"%>
    <%@ page session="true" %>
    <% JwtResponse jwt = (JwtResponse)session.getAttribute("SPRING_SECURITY_CONTEXT"); %>
    <% String role = (String)jwt.getRoles().get(0); %> 

<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-end fixed-top" onload="return hideShoppingCart('<%= role %>')">
  <ul class="navbar-nav">
  <%-- <span class="navbar-brand mb-0 h4">Navbar</span> --%>
    <li class="nav-item">
      <a class="nav-link" ><% out.print(jwt.getUsername()); %></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" >|</a>
    </li>
    <li class="nav-item" id="ShoppingCart">
      <a class="nav-link" ><span class="material-icons">shopping_cart</span></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/dashboard">Dashboard</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/logout">Logout</a>
    </li>
  </ul>
</nav>
<br/><br/>