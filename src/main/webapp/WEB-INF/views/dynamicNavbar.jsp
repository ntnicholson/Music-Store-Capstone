<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.capstone.entity.User"%>
    <%@ page import="com.capstone.payload.response.JwtResponse"%>
    <% HttpSession s = request.getSession(false);
    if (s.getAttribute("SPRING_SECURITY_CONTEXT") == null){
    	response.sendRedirect("/login");
    }
    JwtResponse jwt = (JwtResponse)session.getAttribute("SPRING_SECURITY_CONTEXT"); 
    %>
    <%@ page session="true" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-end fixed-top">
  <ul class="navbar-nav">

    <li class="nav-item">
      <a class="nav-link" >|</a>
    </li>
    <li class="nav-item" id="ShoppingCart">
      <a class="nav-link" href="/cart"><span class="material-icons">shopping_cart</span></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/logout">Logout</a>
    </li>
  </ul>
</nav>
<br/><br/>