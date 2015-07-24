<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css"> 
  html { height: 100% } 
  body { height: 100%; margin: 0px; padding: 0px; font-size: 9pt; } 

    div { float:left; }

    #map_canvas { width: 800px; height: 500px }

    #control {  }

    input { font-size: 9pt; }
    
    .rangeH {width: 1200px; height: 20px; margin: 0; padding: 0;}
	.rangeV {width: 20px; height: 600px; margin: 0; padding: 0;
         -webkit-appearance: slider-vertical; color: #00c;}
</style> 
<script type="text/javascript" 
    src="http://maps.google.com/maps/api/js?sensor=false&region=KR"> 
</script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">



	function getlocation(mhourValue) {
			
			var inputUserid = document.getElementById("inputUserid").value;
			var inputDate = document.getElementById("inputDate").value;
			//var viewCollection = document.getElementById("viewCollection").value;
			var newVal;
			if(mhourValue.length == 1){
				newVal = "0" + mhourValue;
			}else{
				newVal = mhourValue;
			}
			
			console.log(inputUserid + "\t" + inputDate);
			$.ajax({
				url : "location",
				method : "get",
				dataType : "json",
				data:{userId : inputUserid,
					  mdate : inputDate,
					  mHour : newVal
					  },
				success : function(responseData, status, xhr) {
					if( document.getElementById("polyline").checked == true){
						individualPath(mhourValue)
					}
					if(document.getElementById("circle").checked == true){
						initialize(responseData);	
					}
				}
			});
	}
	
	//경로 구하기
	function individualPath(mhourValue) {
		
		var inputUserid = document.getElementById("inputUserid").value;
		var inputDate = document.getElementById("inputDate").value;
		var newVal;
		
		if(mhourValue.length == 1){
			newVal = "0" + mhourValue;
		}else{
			newVal = mhourValue;
		}
		console.log(mhourValue + "\t" + newVal + "\t" + inputDate);
		
		$.ajax({
			url : "individualPath",
			method : "get",
			dataType : "json",
			data:{userId : inputUserid,
				  mDate : inputDate,
				  mHour : newVal
				  },
			success : function(responseData, status, xhr) {
				individualPathView(responseData);
			}
		});
}
	
	//구한 경로를 맵에 표시
	function individualPathView(responseData) {
		var mapOptions = {
			    zoom: 16,
			    center: new google.maps.LatLng(37.2939104, 127.20256640000002),
			    mapTypeId : google.maps.MapTypeId.ROADMAP
			  };
			  var bermudaTriangle;

			  map = new google.maps.Map(document.getElementById('map'),
			      mapOptions);

			  // Define the LatLng coordinates for the polygon.
			  
			  var poly = new Array();
			  for (var i = 0; i < responseData.length; i++) {
					var pos = new google.maps.LatLng(responseData[i].indvLat, responseData[i].indvLng);
					console.log(responseData[i].indvLat + "\t" + responseData[i].indvLng);
					poly.push(pos);
			  }
			  
			  // Construct the polygon.
			  bermudaTriangle = new google.maps.Polyline({
			    path: poly,
			    strokeColor: '#FF0000',
			    strokeOpacity: 1.0,
			    strokeWeight: 2
			  });

			  bermudaTriangle.setMap(map);

			  // Add a listener for the click event.
			  google.maps.event.addListener(bermudaTriangle, 'click', showArrays);

			  infoWindow = new google.maps.InfoWindow();
			}

			/** @this {google.maps.Polygon} */
			function showArrays(event) {

			  // Since this polygon has only one path, we can call getPath()
			  // to return the MVCArray of LatLngs.
			  var vertices = this.getPath();

			  var contentString = '<b>Bermuda Triangle polygon</b><br>' +
			      'Clicked location: <br>' + event.latLng.lat() + ',' + event.latLng.lng() +
			      '<br>';

			  // Iterate over the vertices.
			  for (var i =0; i < vertices.getLength(); i++) {
			    var xy = vertices.getAt(i);
			    contentString += '<br>' + 'Coordinate ' + i + ':<br>' + xy.lat() + ',' +
			        xy.lng();
			  }

			  // Replace the info window's content and position.
			  infoWindow.setContent(contentString);
			  infoWindow.setPosition(event.latLng);

			  infoWindow.open(map);
			  google.maps.event.addDomListener(window, 'load', initialize);
			}


	var StreetViewPanorama = new function() {
	}

	var globalMap;
	var globalMarker;
	var globalGeocoder;
	var positionMap = {};

	// 맵 초기화
	function initialize(responseData) {

		geocoder = new google.maps.Geocoder();

		// GPS 인식 가능 여부(현재 위치)
		if (navigator.geolocation) {

			navigator.geolocation
					.getCurrentPosition(
							function(pos) {

								// 현재 위경도 값(GPS) 변수에 넣기.
								var latitude = 37.2939104;
								var longitude = 127.20256640000002;

								var mapOptions = {
									zoom : 16,
									mapTypeId : google.maps.MapTypeId.ROADMAP,
									center : new google.maps.LatLng(latitude,
											longitude)
								};

								map = new google.maps.Map(document
										.getElementById('map'), mapOptions);

								/* var marker = new google.maps.Marker(

											position : new google.maps.LatLng(
													latitude1, longitude1),
											map : map,
											draggable : false,
											icon : "http://maps.google.com/mapfiles/ms/micons/man.png"
										});
								markers.push(marker); */

								if (responseData != 0) {
									for ( var i in responseData) {
										positionMap[i] = {
											center : new google.maps.LatLng(
													responseData[i].indvLat,
													responseData[i].indvLng),
											//population : responseData[i].locationCount
											population : 1
										}
										console.log(positionMap[i].center);

									}

								} else {

									positionMap[0] = {
										center : new google.maps.LatLng(
												latitude, longitude),
										population : 0
									}
								}

								// 현재 위치 기준 원 그리기
								for ( var i in positionMap) {

									var populationOptions = {
										strokeColor : '#000000',
										strokeOpacity : 0.8,
										strokeWeight : 2,
										fillColor : '#808080',
										fillOpacity : 0.5,
										map : map,
										center : positionMap[i].center,
										radius : 30 * positionMap[i].population
									};
									cityCircle = new google.maps.Circle(
											populationOptions);
								}
							},
							function(error) {
								switch (error.code) {
								case 1:
									$("#errormsg")
											.html(
													"User denied the request for Geolocation.");
									break;
								case 2:
									$("#errormsg")
											.html(
													"Location information is unavailable.");
									break;
								case 3:
									$("#errormsg")
											.html(
													"The request to get user location timed out.");
									break;
								case 0:
									$("#errormsg").html(
											"An unknown error occurred.");
									break;
								}
							});
		} else {
			alert("Geolocation is not supported by this browser.");
		}
	}

	$(window).load(function() {

		initialize(0);

	});
</SCRIPT>
<body>
	<div id="map" style="width: 1200px; height: 600px; margin-top: 20px;"></div><br>
	<input type="range" class = "rangeH" min="0" max="24" step="1" onchange="getlocation(this.value)"><br><br>
	<input type="radio" id="polyline" name = "dd" value="polyline"> polyline
	<input type="radio" id="circle" name = "dd" value="circle"> circle
	<p>
	userid : <input type="text" name="userid" id = "inputUserid"> Date : <input type="text" name="date" id = "inputDate"> 
	</p>
</body>
</html>