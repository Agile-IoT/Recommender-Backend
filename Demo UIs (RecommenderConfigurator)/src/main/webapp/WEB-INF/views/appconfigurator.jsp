<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>AGILE Management UI</title>
    
    <spring:url value="/resources/img/agileappconfigurator.png" var="agileappconfigurator" />
 
   <style> 
		body {
		    background: "${agileappconfigurator}";
		    background-size: 100% 100%;
		    background-repeat: no-repeat;
		}
		.recomWindowFirst{
		    padding: 10px;
		    margin-left: 270px;
		    margin-top: 20 px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 1000px;
		    height: 60px;
		}
		.recomWindow{
		    padding: 10px;
		    margin-left: 270px;
		    margin-top: 20px;
		    color: #000000;
		    background-color: #ffffff;
		    width: 1000px;
		    height: 60px;
		}
		.appConfigurationButton{
		    margin-left: 40px;
		    margin-top: 205px;
		    color: #000000;
		    width: 25px;
		    height: 15px;
		}
		.applyButton{
		    color: #000000;
		    width: 180px;
		    height: 50px;
		}
	</style>
	
</head>

<body  background="${agileappconfigurator}"
		    background-size= 100%
		    background-repeat= no-repeat
>
<div class="appConfigurationButton">
	<a href="devmanager">__</a>
</div>
	
<div class="recomWindowFirst">
	<p> <strong>${appname1}</strong> </br>${dataencoding1} </br>${connencoding1}</p>
</div>
<div class="recomWindow">
	<p> <strong>${appname2}</strong> </br>${dataencoding2} </br>${connencoding2}</p>
</div>
<div class="recomWindow">
	<p> <strong>${errormessage}</strong><br/> </p></br>
	<button  class="applyButton" type="button" onclick="alert('Recommended App Configurations are applied!')">Apply Recommended Configurations</button>
</div>


</body>
</html>
