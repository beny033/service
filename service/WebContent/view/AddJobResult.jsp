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
  result is SUCCESS
  <br><br>
  Job Added.
  <br>
  <a href="./showjobs?id=${id}">View Jobs</a>
  <jsp:include page="Footer.jsp"/>
</body>
</html>