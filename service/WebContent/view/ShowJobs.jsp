<%@page import="com.bong.service.model.ServiceDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Android @ MSI Wireless</title>
</head>
<body>

  <jsp:include page="Header.jsp"/>
<h3>Job List for [${identifier}]</h3>
<hr />
	<c:choose>
	  <c:when test="${list eq null}">
	    There are no Jobs available.
	    <br>
	    Add a <a href="view/AddJob.jsp?id=${identifier}">Job</a>
	  </c:when>
	  <c:otherwise>
	    <table border="1">
	      <tr style=text-align:center;>
	        <th>Job Id#</th>
	        <th>Customer</th>
	        <th>Address</th>
	        <th>City</th>
	        <th>State</th>
	        <th>Zip</th>
	        <th>Product</th>
	        <th>Product_URL</th>
	        <th>Comments</th>
	        <th>Status</th>
	      </tr>
	      <c:forEach var="list" items="${list}">
	      <tr> 
	      	 ${list}
	      </tr>
		  </c:forEach>
	    </table>
	    <a href="#">Export Your Job List</a> <br><br>
	    Add a <a href="view/AddJob.jsp?id=${identifier}">Job</a>
	   </c:otherwise>
	  </c:choose>
	  <p><a href="./index.jsp">Home</a><br>
  <jsp:include page="Footer.jsp"/>
</body>
</html>