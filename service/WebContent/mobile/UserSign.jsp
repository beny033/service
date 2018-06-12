<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String job_id = request.getParameter("job_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Quick Parcel Service</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
$(document).ready(function(){
 var canvas = document.getElementById('canvas');
 var context = canvas.getContext('2d');
 context.lineWidth=2;
 context.lineCap="round";

 $(canvas).bind({"touchstart mousedown": function(event){
  
  event.preventDefault();
  
  if(event.type == 'touchstart'){
   event = event.originalEvent.targetTouches[0];
  }
  
  $(this).data("flag", "1");
  var position = $(this).offset();
  var x = event.pageX - position.left;
  var y = event.pageY - position.top;
  console.log("start x: " + x + ", y: " + y);
  context.beginPath();
  context.moveTo(x,y);

 }, "mousemove touchmove" : function(event) {
  
  event.preventDefault();
  
  if(event.type == 'touchmove'){
   event = event.originalEvent.targetTouches[0];
  }  

  var flag = $(this).data("flag");
  if(flag == 1){
   var position = $(this).offset();
   var x = event.pageX - position.left;
   var y = event.pageY - position.top; 
   
  }
  context.lineTo(x, y);
  context.stroke();
 }, "mouseup touchend mouseleave" : function(event) {
  
  event.preventDefault();

  console.log("type: " + event.type);
  if(event.type == 'touchend'){
   event = event.originalEvent.changedTouches[0];   
  }   

  $(this).data("flag", "0");
  var position = $(this).offset();
  
  var x = event.pageX - position.left;
  var y = event.pageY - position.top; 
  
  console.log("end: " + x + ", y: " + y);
 
 }
 
 }); 

 $("#id_clear").click(function(){
  canvas.width = canvas.width;
  context.lineWidth=10;
  context.lineCap="round";
 });

});
</script>
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
	#submit {
		width:50%;
		height:70px; 
		background-color:#8eb5ac;
	}
	#id_clear {
		width:50%; 
		height:70px;
		background-color:#8eb5ac; 
	}
</style>
<body>
	<div id="main">
		<jsp:include page="/mobile/Include.jsp"></jsp:include>		
	</div>
	<div id="user">  
		<div>
		  <canvas id="canvas" width="345" height="260" style="border:1px solid #000000"></canvas>
		</div>
		<div id="buttons">
		  <button id="submit" onclick="location.href='../signok?job_id=<%=job_id%>'">전송</button><input type="button" id="id_clear" value="다시작성" /> 
		</div>
	</div>
</body>
</html>