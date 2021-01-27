<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.capstone.entity.User"%>
    <%@ page session="true" %>
    <% String name = (String)session.getAttribute("currentsess"); %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-end fixed-top">
  <ul class="navbar-nav">
  <%-- <span class="navbar-brand mb-0 h4">Navbar</span> --%>
    <li class="nav-item">
      <a class="nav-link" ><% out.print(name); %></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" >|</a>
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