<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		background-color:#5bcac6;
		height:340px;  	 
	}
	.message {
		display:block;
		background-color: #3879a0;
		color:white;
		height:50px;
	}
	
	.text {
		width:98.9%;
		height:30px; 
		background-color:#00afbd;
		color:white;
		font-size:20px;
	}
	#submit {
		background-color:#70b4ad;
		color:white;
		height: 30px;
		width: 200px;
		font-size:15px;
		position:relative;
		left:5px;
		top:15px;
	}
</style>
<body>

<div id="main">
  <jsp:include page="/mobile/Include.jsp"></jsp:include>
</div>


<div id="user">
	<form action="../" method="post">
		<span class="message">
		등록할 메일주소를 입력하세요. <br>
		</span>
		  <input type="text" name="identifier" class="text">
		<span class="message">
		접속할 주소를 입력하세요.
		</span>
		  <input type="text" class="text" name="server" value="http://android12.msi-wireless.com">
		  <input type="submit" id="submit" value="입력한 내용을 저장합니다.">
	</form>
</div>	
</body>
</html>