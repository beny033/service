<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Quick Parcel Service</title>
    <style> 
      #map {
		height:100%;
      }    
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
</head>
<body>
   <div id="map"></div>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 36.417133, lng: 128.034053},
          zoom: 8   
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsg2sIQjKyvweFimB0loBLXFraLcSuRSI&callback=initMap"
    async defer></script>
</body>
</html>
