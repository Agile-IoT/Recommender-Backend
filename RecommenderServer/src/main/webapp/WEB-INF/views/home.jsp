<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>AGILE Recommender</title>
</head>
<body>
<h1>
	The AGILE Recommender Server  
	
</h1>
<P>
<a href="http://agile-iot.eu/">AGILE</a> (Adaptive & Modular Gateway for the IoT) is a modular gateway for the Internet of Things with support of a <a href="http://agile.ist.tugraz.at:8080/doc/">Recommender Service</a> on it.
<br />Recommendable Items in the Current Repository => Devices: ${devs}, Workflows/Nodes: ${wfs}, Clouds: ${clouds}. 
</P>

<iframe src="resources/info.pdf" style="height:2100px;width:900px" align="left"">

This browser does not support PDFs. Please download the PDF to view it: <a href="resources/info.pdf">Download PDF</a>

</iframe> 

<!-- 	https://github.com/Agile-IoT/Recommender/ -->
<%-- 	The time on the server is ${serverTime}.  --%>

</body>

</html>
