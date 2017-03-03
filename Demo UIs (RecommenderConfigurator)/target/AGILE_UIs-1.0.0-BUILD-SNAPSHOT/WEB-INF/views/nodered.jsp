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
		    background: "${agiledevenv}";
		    background-size: 100% 100%;
		    background-repeat: no-repeat;
		}
		.recomWindowFirst{
		    padding: 10px;
		    margin-left: 970px;
		    margin-top: 210px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 320px;
		    height: 20px;
		}
		.recomWindow{
		    padding: 10px;
		    margin-left: 970px;
		    margin-top: 20px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 320px;
		    height: 20px;
	</style>
    
</head>

<body  background="${agiledevenv}"
		    background-size= 100% 
		    background-repeat= no-repeat
>
<div class="recomWindowFirst">
	<p><strong>Recommended Workflows/Nodes:</strong> <br/> 
	<small><strong>${wfname1}</strong></small> <font size="1"><a href="url">${wfhref1}</a> <br/> 
	${exp1}</font> </p>
</div>
<div class="recomWindow">
	<p><small><strong>${wfname2}</strong></small> <font size="1"><a href="url">${wfhref2}</a> <br/> 
	${exp2}</font> </p>
</div>
<div class="recomWindow">
	<p><small><strong>${wfname3}</strong></small> <font size="1"><a href="url">${wfhref3}</a> <br/> 
	${exp3}</font> </p>
</div>
<div class="recomWindow">
	<p><strong>Recommended Cloud Servers:</strong> <br/> 
	<small><strong>${cloudname1}</strong></small> <font size="1"><a href="url">${cloudhref1}</a> <br/> 
	${exp4}</font> </p>
</div>
<div class="recomWindow">
	<p><small><strong>${cloudname2}</strong></small> <font size="1"><a href="url">${cloudhref2}</a> <br/> 
	${exp5}</font> </p>
</div>


</body>
</html>
