<%@ page import="org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport"%>
<%@ page import="MyUtil.sql.sqlResults"%>
<%@ page import="MyUtil.sql.sqlQuery"%>
<%@ page import="MyUtil.CookieUtil" %>
<%@ page import="java.net.InetAddress" %>
<%@ page import="MyUtil.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Map</title>
        <meta charset="utf-8">
    </head>
    <body>
    	<div>
    		<%
    			/*CookieUtil cu = new CookieUtil();
    			if(cu.isExists("usr_name", request.getCookies()) == false) {
    				%><!-- <meta http-equiv="refresh" content="0; url=./login.jsp"> --><%
    			}
    			*/
    		%>
    	</div> 
        <div id="map" style="height: 90vh;width: 90vw; margin: auto auto;"></div>
    </body>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_CGRtCPfYi1H9ChMhjCBEu2kfmcTGyqw&callback=initMap"></script>
    <script>
        interval = null
        var map
        var curPosMk
        var circle
        var accAl = 0
        var radius = 0
        var track = false
        var isChanging = false
        var markers = []
        var iWindows = []

        function init() {
            navigator.geolocation.getCurrentPosition((pos) => {
                crd = pos.coords;
                lat = crd.latitude
                lon = crd.longitude
                map = new google.maps.Map(document.getElementById("map"), {
                    zoom: 18,
                    center: {lat: lat, lng: lon},
                });
                curPosMk = new google.maps.Marker({
                    position: {lat: lat, lng: lon},
                    map: map,
                });
                circle = new google.maps.Circle({
                    strokeColor: "#0000FF",
                    strokeOpacity: 0.8,
                    strokeWeight: 2,
                    fillOpacity: 0,
                    map,
                    center: {lat: lat, lng: lon},
                    radius: 0,
                });
            }, error, {timeout: 2000, enableHighAccuracy: true})
            toggleUpdate();
			setInterval(() => circleChange(), 5000);
        }
        function toggleUpdate() {
            clearInterval(interval)
            interval = setInterval(() => navigator.geolocation.getCurrentPosition(update, error, {enableHighAccuracy: true}), 1000)
        }
        function update(pos) {
            crd = pos.coords
            lat = crd.latitude
            lon = crd.longitude
            acc = crd.accuracy
            speed = crd.speed
            curPosMk.setPosition({lat: lat, lng: lon})
            circle.setCenter({lat: lat, lng: lon})
            accAl = acc
        }

        function circleChange() {
        	if (isChanging) {
				return
			}
        	isChanging = true
        	var circleInterval;
        	var nowAcc = accAl*1
        	if(nowAcc <= 1) return
        	var splitedAcc = nowAcc/10
        	function less() {
        		circle.setRadius(0)
        		circleInterval = setInterval(() => {
            		radius -= splitedAcc
                    if(radius <= 0) {clearInterval(circleInterval);}
                    circle.setRadius(radius)
    			}, 100);
        	}
        	circleInterval = setInterval(() => {
        		radius += splitedAcc
                if(radius >= nowAcc) {clearInterval(circleInterval);less()}
                circle.setRadius(radius)
			}, 100);
        	isChanging = false
        }

        function error(e) {
            console.log(e);
        }

        window.initMap = init
    </script>
</html>