<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Quick Parcel Service</title>
</head>
<style>
	@media(min-width:350px) {
		#user {
			display:none;
		}
	}
	@media(max-width:350px) and (max-height:340px){
		#main{
			display:none;
		}
	}
	body {margin:0;}
	#user {
		background-color: #00bfcb;
		height:339px;
	}
	
	#countJob { 
		background-color: #3879a0;
		color:white; 
		height:60px;
	}
	.list {
		height: 50px;
		text-align:left;
		font-size:20px;
		text-decoration:none;
		color:black;
	}
	hr {
		border:0.5px solid black; 
	}
</style>
<body>
	<div id="main">
		<jsp:include page="/mobile/Include.jsp"></jsp:include>
	</div>
	
	<div id="user">
	  <div id="countJob">
	  	There are ${count} jobs.
	  </div>
	  <table>
	  <c:forEach var="list" items="${list}">
	  	<tr>
			${list}			  	
	  	</tr>
	  </c:forEach>
	  
	  </table>
	</div>
</body>
</html>