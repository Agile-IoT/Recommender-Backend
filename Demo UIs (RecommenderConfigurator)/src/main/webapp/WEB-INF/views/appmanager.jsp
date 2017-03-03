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
		    background: "${appmanager}";
		    background-size: 100% 100%;
		    background-repeat: no-repeat;
		}
		.recomWindowFirst{
		    padding: 10px;
		    margin-left: 127px;
		    margin-top: 2px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 1000px;
		    height: 50px;
		}
		.recomWindow{
		    padding: 10px;
		    margin-left: 127px;
		    margin-top: 20px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 1000px;
		    height: 50px;
		}
		.appConfigurationButton{
		    margin-left: 40px;
		    margin-top: 205px;
		    color: #000000;
		    width: 25px;
		    height: 15px;
		}
	</style>
	
</head>

<body  background="${appmanager}"
		    background-size= 100%
		    background-repeat= no-repeat
>
<div class="appConfigurationButton">
	<a href="appconfigurator">__</a>
</div>

<div class="recomWindowFirst">
	<p> <strong>${appname1}</strong> <a href="${apphref1}">Download App</a> <br/> 
	${exp1}</p>
</div>
<div class="recomWindow">
	<p> <strong>${appname2}</strong> <a href="${apphref2}">Download App</a> <br/> 
	${exp2}</p>
</div>
<div class="recomWindow">
	<p> <strong>${appname3}</strong> <a href="${apphref3}">Download App</a> <br/> 
	${exp3}</p>
</div>
<div class="recomWindow">
	<p> <strong>${appname4}</strong> <a href="${apphref4}">Download App</a> <br/> 
	${exp4}</p>
</div>
<div class="recomWindow">
	<p> <strong>${appname5}</strong> <a href="${apphref5}">Download App</a> <br/> 
	${exp5}</p>
</div>

</body>
</html>
