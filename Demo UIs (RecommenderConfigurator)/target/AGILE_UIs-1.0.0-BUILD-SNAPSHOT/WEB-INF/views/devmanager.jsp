<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>AGILE Management UI</title>
    
    <spring:url value="/resources/img/agileappmanager.png" var="appmanager" />
    <spring:url value="/resources/img/agiledevenv.png" var="agiledevenv" />
    <spring:url value="/resources/img/agiledevicemanager.png" var="devmanager" />
    <spring:url value="/resources/img/agilemenu.png" var="agilemenu" />
    <style> 
		body {
		    background: "${devmanager}";
		    background-size: 100% 100%;
		    background-repeat: no-repeat;
		}
		.recomWindowFirst{
		    padding: 10px;
		    margin-left: 127px;
		    margin-top: 200px;
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
	</style>
	
</head>

<body  background="${devmanager}"
		    background-size= 100% 
		    background-repeat= no-repeat
>
<div class="recomWindowFirst">
	<p> <strong>${devname1}</strong> <a href="url">${devhref1}</a> <br/> 
	${exp1}</p>
</div>
<div class="recomWindow">
	<p> <strong>${devname2}</strong> <a href="url">${devhref2}</a> <br/> 
	${exp2}</p>
</div>
<div class="recomWindow">
	<p> <strong>${devname3}</strong> <a href="url">${devhref3}</a> <br/> 
	${exp3}</p>
</div>
<div class="recomWindow">
	<p> <strong>${devname4}</strong> <a href="url">${devhref4}</a> <br/> 
	${exp4}</p>
</div>
<div class="recomWindow">
	<p> <strong>${devname5}</strong> <a href="url">${devhref5}</a> <br/> 
	${exp5}</p>
</div>

</body>
</html>
