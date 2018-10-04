<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>AGILE Recommender</title>

<style> 
div.ex1 {
    background-color: lightblue;
    height: 200px;
    width: 900px;
    overflow-y: scroll;
}
</style> 
</head>


<body>
<h1>
	The AGILE Recommender Server  
	
</h1>
<P>
<a href="http://agile-iot.eu/">AGILE</a> (Adaptive & Modular Gateway for the IoT) is a modular gateway for the Internet of Things with support of a <a href="http://agile.ist.tugraz.at:8080/doc/">Recommender Service</a> on it.
</P>


<!-- <table> -->
<!-- <thread> -->
<!--   <tr> -->
<!--     <th>Cloud Repository</th> -->
<!--   </tr> -->
<!-- </thread> -->
<!-- <tbody> -->
<%--   <c:forEach var="cloudListValue" items="${cloudList}"> --%>
<!--     <tr> -->
<!--       <td> -->
<%--              ${cloudListValue}       --%>
<!--      </td> -->
<!--     </tr> -->
<%--   </c:forEach> --%>
<!-- </tbody> -->
<!-- </table> -->

<!-- <table> -->
<!-- <thread> -->
<!--   <tr> -->
<!--     <th>Device Repository</th> -->
<!--   </tr> -->
<!-- </thread> -->
<!-- <tbody> -->
<%--   <c:forEach var="deviceListValue" items="${deviceList}"> --%>
<!--     <tr> -->
<!--       <td> -->
<%--              ${deviceListValue}       --%>
<!--      </td> -->
<!--     </tr> -->
<%--   </c:forEach> --%>
<!-- </tbody> -->
<!-- </table> -->


<!-- <table> -->
<!-- <thread> -->
<!--   <tr> -->
<!--     <th>Workflow Repository</th> -->
<!--   </tr> -->
<!-- </thread> -->
<!-- <tbody> -->
<%--   <c:forEach var="workflowListValue" items="${workflowList}"> --%>
<!--     <tr> -->
<!--       <td> -->
<%--              ${workflowListValue}       --%>
<!--      </td> -->
<!--     </tr> -->
<%--   </c:forEach> --%>
<!-- </tbody> -->
<!-- </table> -->


<h2>Device Repository: ${devs} devices</h2>
<div class="ex1">
<ol>
  <c:forEach var="deviceListValue" items="${deviceList}">
	<li><a href="${deviceListValue}">${deviceListValue}</a></li>
  </c:forEach>
</ol> 
</div>

<h2>Workflow Repository: ${wfs} flows/nodes</h2>
<div class="ex1">
<ol>
  <c:forEach var="workflowListValue" items="${workflowList}">
	<li><a href="${workflowListValue}">${workflowListValue}</a></li>
  </c:forEach>
</ol> 
</div>

<h2>Cloud Repository: ${clouds} clouds</h2>
<div class="ex1">
<ol>
  <c:forEach var="cloudListValue" items="${cloudList}">
	<li><a href="${cloudListValue}">${cloudListValue}</a></li>
  </c:forEach>
</ol> 
</div>


<iframe src="resources/info.pdf" style="height:2100px;width:900px" align="left"">

This browser does not support PDFs. Please download the PDF to view it: <a href="resources/info.pdf">Download PDF</a>

</iframe> 

<!-- 	https://github.com/Agile-IoT/Recommender/ -->
<%-- 	The time on the server is ${serverTime}.  --%>

</body>

</html>
