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
		.labelFirst{
		    margin-left: 970px;
		    margin-top: 210px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 320px;
		    height: 5px;
		}
		.labelInside{
		    margin-left: 970px;
		    margin-top: 35px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 320px;
		    height: 5px;
		}
		.recomWindow{
		    padding: 10px;
		    margin-left: 970px;
		    margin-top: 7px;
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
<div class="labelFirst">
	<p><strong>Recommended Workflows/Nodes:</strong></p>
</div>
<div class="recomWindow">
	<p>	<small><strong>${wfname1}</strong></small> <font size="1"><a href="${wfhref1}">Download</a> <br/> 
	${exp1}</font> </p>
</div>
<div class="recomWindow">
	<p><small><strong>${wfname2}</strong></small> <font size="1"><a href="${wfhref2}">Download</a> <br/> 
	${exp2}</font> </p>
</div>
<div class="recomWindow">
	<p><small><strong>${wfname3}</strong></small> <font size="1"><a href="${wfhref3}">Download</a> <br/> 
	${exp3}</font> </p>
</div>
<div class="labelInside">
	<p><strong>Recommended Cloud Servers:</strong></p>
</div>
<div class="recomWindow">
	<p><small><strong>${cloudname1}</strong></small> <font size="1"><a href="${cloudhref1}">Go To This Cloud</a> <br/> 
	${exp4}</font> </p>
</div>
<div class="recomWindow">
	<p><small><strong>${cloudname2}</strong></small> <font size="1"><a href="${cloudhref2}">Go To This Cloud</a> <br/> 
	${exp5}</font> </p>
</div>


</body>
</html>
