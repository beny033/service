<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Android @ MSI Wireless</title>
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
	#user {
		background-color:#5bcac6;
		height:339px;  
	}
	#userHeader {
		background-color:#3879a0;
		color:white;
		height:60px;
	}
	body {
		margin:0;
	}
	button {
		width:100%;
		height:50px;
		background-color:#59b4b9;
		color:white;
		margin:5px 0 5px 0;
		font-size:15px;
		text-align:center;
	}
</style> 
<body>
<div id="main">  
  <jsp:include page="view/Header.jsp"/>
	Welcome to the Unlocking Android Sample Application Service for Chapter 12<br>
<br>
This website allows you to manage jobs for use in conjunction with the sample application built and described in Unlocking Android, Chapter 12.<br>
<br>
The context of this application is a mobile field service technician who must travel to different job sites to perform maintenance on equipment.  Once arriving at the site, the technician's job is to troubleshoot the machinery and perform some any required maintenance procedures.<br> 
<br>
Of course, not all technicians are going to be familiar with every piece of equipment that they run into.  To help remedy this lack of training, our sample application includes a link to further information that the dispatcher can provide.  That additional information comes in the form of a url, which could link to a manufacturer's web site, or perhaps to an online audio or video resource to assist in the troubleshooting process.<br>
<br>
Once the service call has been made, the technician has the opportunity to record a client signature and CLOSE the job order.<br>
<br>
Clearly a full featured job management system would encompass much more, however this application covers the basics and additional data elements such as customer address, travel time, travel costs, time on job, miscellaneous expenses and the like are easy enough to add - and that is left as an exercise to the reader!<br>
<br>
Entering jobs is easy, just pick a string identifier for yourself - it could be your email address or just a number.  Enter that value in the field below and any available jobs will display.  If there are no jobs, you can enter a new one.  Enjoy!<br>

<br />
<br />
<form method="POST" action="showjobs">
	Your identifier:&nbsp;<input name="id" maxlength="50"> 
<input type=submit value="Look Up My Jobs">
</form><br>
<br>
Feel free to drop us a note if you have any comments or questions on the Sample Application or this service.<br>
Oh-Bongki<br>
MSI Services, Inc.<br>
23 Route 206<br>
Byram Township, NJ 07874<br>
973.448.0070<br>
http://msiservices.com<br>
  <jsp:include page="view/Footer.jsp"/>
</div>
<div id="user">
  <div id="userHeader">
	User : ${param.identifier}
	<br>
	Server : ${param.server}
  </div>
   
  <div id="contents">
    <button>배송 불러오기</button>
    <button onclick="location.href='orderlist?identifier=${param.identifier}&server=${param.server}'">배송 예약목록</button>
    <button onclick="location.href='mobile/User.jsp'">계정 등록</button>
  </div>
</div>	


























</body>
</html>