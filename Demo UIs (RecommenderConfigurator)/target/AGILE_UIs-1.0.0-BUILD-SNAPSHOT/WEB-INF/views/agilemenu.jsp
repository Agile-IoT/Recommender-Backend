<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>AGILE Management UI</title>
    
    <spring:url value="/resources/img/agileappmanager.png" var="appmanager" />
    <spring:url value="/resources/img/agiledevenv.png" var="agiledevenv" />
    <spring:url value="/resources/img/agiledevicemanager.png" var="agiledevicemanager" />
    <spring:url value="/resources/img/agilemenu.png" var="agilemenu" />
    <style> 
		body {
		    background: "${agilemenu}";
		    background-size: 100% 100%;
		    background-repeat: no-repeat;
		}
	</style>
	<style>
		* {
		    box-sizing: border-box;
		}
		.devmanagerbutton{
		    margin-left: 127px;
		    margin-top: 70px;
		    color: #000000;
		    width: 25px;
		    height: 15px;
		}
		.noderedbutton{
		    margin-left: 127px;
		    margin-top: 90px;
		    color: #000000;
		    width: 25px;
		    height: 15px;
		}
		.appmanagerbutton{
		    margin-left: 127px;
		    margin-top: 47px;
		    color: #000000;
		    width: 25px;
		    height: 15px;
		}
		
	</style>
	
</head>

<body  background="${agilemenu}"
		    background-size= 100%
		    background-repeat= no-repeat
>
<div class="devmanagerbutton">
	<a href="devmanager">__</a>
</div>

<div class="noderedbutton">
	<a href="nodered">__</a>
</div>

<div class="appmanagerbutton">
	<a href="appmanager">__</a>
</div>


</body>
</html>
