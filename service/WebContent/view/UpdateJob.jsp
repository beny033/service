<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Android @ MSI Wireless</title>
</head>
<body>
  <jsp:include page="Header.jsp"/>
  	<br />
	<br />
	<form method="POST" action="./updatejob">
	<table>
	<tr><td>User/Identifier:</td><td><input type=text readonly name=id value=${identifier }></td></tr>
	<tr><td>Job ID:</td><td><input type=text readonly name=job_id value=${job_id }></td></tr>
	<tr><td>Status:</td><td><input type=text name=status value=${status }></td></tr>
	<tr><td>Customer:</td><td><input name="customer" value=${customer } maxlength="50"></td></tr>
	<tr><td>Address:</td><td><input name="address" value=${address } maxlength="50"></td></tr>
	<tr><td>City:</td><td><input name="city" value=${city } maxlength="50"></td></tr>
	<tr><td>State:</td><td><input name="state" value=${state } maxlength="2"></td></tr>
	<tr><td>Zip:</td><td><input name="zip" value=${zip } maxlength="10"></td></tr>
	<tr><td>Product:</td><td><input name="product" value=${product } maxlength="50"></td></tr>
	<tr><td>Product URL:</td><td><input name="producturl" value=${product_url } maxlength="100"></td></tr>
	<tr><td>Comments:</td><td><input name="comments" value=${comments } maxlength="100"></td></tr>
	</table>
	<input type=submit value="Update Job Record">
	</form><br>
	<br>
  	<a href="./deletejob?job_id=${job_id}&id=${identifier}">Delete Job</a>
  
  
  
  <jsp:include page="Footer.jsp"/>
</body>
</html>