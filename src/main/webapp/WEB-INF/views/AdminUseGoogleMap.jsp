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
	
	var pop = 0;
	function getTotalLocation(Val) {
			
			var inputDate = document.getElementById("inputDate").value;
			var newVal;
			
			if(Val.length == 1){
				newVal = "0" + Val;
			}else{
				newVal = Val;
			}
			$.ajax({
				url : "totallocation",
				method : "get",
				dataType : "json",
				data:{
					  mdate : inputDate,
					  mHour : newVal
					  },
				success : function(responseData, status, xhr) {
					initialize(responseData);
				}
			});
	}
	
	function getpopulation(x,y){
		var mhourValue = document.getElementById("mhourValue").value;
		var inDate = document.getElementById("inputDate").value;
		var newVal;
		
		if(mhourValue.length == 1){
			newVal = "0" + mhourValue;
		}else{
			newVal = mhourValue;
		}
		
		$.ajax({
			url : "getcount",
			async: false,
			method : "get",
			dataType : "text",
			data:{
				  lat : x,
				  lng : y,
				  mHour : newVal,
				  inputDate : inDate
				  },
			success : function(responseData, status, xhr) {
				getCount(responseData);
			}
		});
	}
	
	function getCount(responseData){
		pop = responseData;
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
										getpopulation(responseData[i].lat, responseData[i].lng);
										console.log("pop : "+pop);
										positionMap[i] = {
											center : new google.maps.LatLng(
													responseData[i].lat,
													responseData[i].lng),
											population : pop
										}
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
										radius : 30* positionMap[i].population
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
	<input type="range" id = "mhourValue" class = "rangeH" min="0" max="24" step="1" onchange="getTotalLocation(this.value)"><br><br>
	<p>
	Date : <input type="text" name="date" id = "inputDate"> 
	</p>
</body>
</html>