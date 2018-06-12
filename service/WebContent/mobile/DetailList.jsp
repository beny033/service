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
	body {
		margin:0;
	}
	#user {
		background-color: #3879a0;
		color:white;
	}
	#contents {
		background-color:#3ac9c7;
	}
	button {
		width:100%;
		height:33px;
		margin:5px 0;
		background-color:#8eb5ac;
		color:white;
		font-size:15px;
	}
	
</style>
<body>
	<div id="main">
      <jsp:include page="/mobile/Include.jsp"></jsp:include>
	</div>

	<div id="user">
		Job Id: <a href='./?identifier=${identifier}'>${job_id}</a> (${status})
		<br><br>
		Customer: ${customer} <br>
		Address: ${address} <br>
		City: ${city} <br>
		State: ${state} <br>
		Zip: ${zip} <br>
		Product: ${product} <br>
		Comments: ${comments} <br><br>
	
	<div id="contents">
		<button onclick="location.href='mobile/GoogleMap.jsp'">위치정보 지도확인</button> <br>
		<button>배송관련 상세내용보기</button> <br>
		<c:choose>
		<c:when test="${status eq 'OPEN' }">
		  <button onclick="location.href='mobile/UserSign.jsp?job_id=${job_id}'">고객 확인받기</button> 
		</c:when>
		<c:otherwise>
		  <button>고객확인 완료된 배송</button> 
		</c:otherwise>		
		</c:choose>
	</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>