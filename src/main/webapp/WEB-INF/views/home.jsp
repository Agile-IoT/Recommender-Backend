<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>

<title>Home</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
    box-sizing: border-box;
}
.row::after {
    content: "";
    clear: both;
    display: block;
}
[class*="col-"] {
    float: left;
    padding: 15px;
}
.col-1 {width: 8.33%;}
.col-2 {width: 16.66%;}
.col-3 {width: 25%;}
.col-4 {width: 33.33%;}
.col-5 {width: 41.66%;}
.col-6 {width: 50%;}
.col-7 {width: 58.33%;}
.col-8 {width: 66.66%;}
.col-9 {width: 75%;}
.col-10 {width: 83.33%;}
.col-11 {width: 91.66%;}
.col-12 {width: 100%;}
html {
    font-family: "Lucida Sans", sans-serif;
}
.header {
    background-color: #9933cc;
    color: #ffffff;
    padding: 15px;
}
.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
.menu li {
    padding: 4px;
    margin-bottom: 3px;
    background-color :#33b5e5;
    color: #ffffff;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}
.menu li:hover {
    background-color: #0099cc;
}


.button {
    background-color: white;
    border: gray;
    color: #33b5e5;
    padding: 5px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    width: 100%;
    margin: 2px 2px;
    cursor: pointer;
}
.astext {
    background:none;
    border:none;
    margin:0;
    padding:0;
}s

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(
	    function() {
	    	var x = '${output}';
	    	$("input[value="+x+"]").click();
	    	var y = '${algorithm}';
	    	$("input[value="+y+"]").click();
	    	var k = '${knowledgebase}';
	    	$("input[value="+k+"]").click();
	    });
</script>

</head>
<body>

<div class="header">
<h1>AGILE Recommender Server</h1>
</div>

<div class="row">


<div class="col-6 menu">
<ul>
<h1>Gateway Profile</h1>
<li>
<p><b>Your AGILE Gateway Profile</b> <button class="astext" onClick="refreshPage()">(<u>change profile</u>)</button><br></p>
<form action="/agileRecommender/getRecommendation" method="post">
  	UserID:<br><input type="text" name="userID" value="${userID}" size= "80" ><br>
  	Apps:<br><input type="text" name="apps" value="${apps}" size= "80" ><br>
	Workflows:<br><input type="text" name="wfs" value="${wfs}" size="80"><br>
	Devices:<br><input type="text" name="devices" value="${devices}" size="80"><br>
	Resources:<br><input type="text" name="resources" value="${resources}" size="80"><br>
	Algorithm:<br><input type="radio" name="alg" value="CB"> Content Based<br>
  				  <input type="radio" name="alg" value="UBCF" > User Based CF<br>
 				  <input type="radio" name="alg" value="IBCF"> Item Based CF<br>
 				  
 	<script type="text/javascript">
     var k = '${algorithm}';
	    $("input[value="+k+"]").click();
   </script>
 	What to recommend:<br><input type="radio" name="out" id="out" value="App"> App<br>
  				  <input type="radio" name="out" id="out" value="Workflow" > Workflow<br>
 				  <input type="radio" name="out" id="out" value="Device" > Device<br>
  
   <script type="text/javascript">
     var k = '${output}';
	 $("input[value="+k+"]").click();
	 
   </script>
   
   <input type="hidden" name="kbUpdate" id="kbUpdate" value=""} /> 
   <input type="hidden" name="fd" id="fd" value= ""/>
   
   <input class="button" type="submit"  onclick="getInputs()" value="Calculate Recommendation"> 
</form>

<li>
</ul>

<ul>
<h1>Knowledge Base</h1>
<li>
<form id="readFileForm" action="/agileRecommender/readFile" method="post">
Select Knowledgebase to Read or Edit:<br><input type="radio" name="kb" id="kb" value="AppRatings"> AppRatings<br>
	  				  <input type="radio" name="kb" id="kb" value="WfRatings" > WfRatings<br>
	 				  <input type="radio" name="kb" id="kb" value="AppList" > AppList<br>
	 				  <input type="radio" name="kb" id="kb" value="WfList" > WfList<br>
	 				  
	 				  <script type="text/javascript">
						   
							var k = '${knowledgebase}';
							 $("input[value="+k+"]").click();
						  
					  </script>
	 				  
	   <input class="button" type="submit" value="Read File"> <br>
</form>


<b>${knowledgebase}:</b>
<textarea id="myTextarea" rows="4" cols="87">
${fileData}
</textarea><br>
<form id="updateForm" action="/agileRecommender/updateFile" method="post">
	<input type="hidden" name="kbUpdate" id="kbUpdate" value=""/> 
	<input type="hidden" name="fd" id="fd" value=""/>
	<input class="button" type="submit" onclick="getInputs()" value="Update Changed File"> 
</form>

<!--
	App Ratings (CF Knowledge Base):<br><iframe src="../../../../resources/AppRatings" name="iframe_a" width="100%"></iframe><br>
	Workflow Ratings (CF Knowledge Base):<br><iframe src="../../../../resources/WfRatings" name="iframe_a" width="100%"></iframe><br>
	App List (CF Knowledge Base):<br><iframe src="../../../../resources/WfList" name="iframe_a" width="100%"></iframe><br>
	Workflow List (CF Knowledge Base):<br><iframe src="../../../../resources/AppList" name="iframe_a" width="100%"></iframe><br>	
	-->		  
	
<li>
</ul>
</div>

<div class="col-6 menu">
<h1>Recommendation Results</h1>
<p>${results}</p>

</div>
</div>

<script type="text/javascript">
function refreshPage(){
    window.location.href = "/agileRecommender/";
} 

function getInputs() {
	document.getElementById("updateForm").elements.namedItem("kbUpdate").value= getKBValue();
	document.getElementById("updateForm").elements.namedItem("fd").value = getTextArea();
}
function getTextArea() {
	return document.getElementById("myTextarea").value;
}
function getKBValue() {
	var val;
    // get list of radio buttons with specified name
    var radios = document.getElementById("readFileForm").elements["kb"];
    // loop through list of radio buttons
    for (var i=0, len=radios.length; i<len; i++) {
        if ( radios[i].checked ) { // radio checked?
            val = radios[i].value; // if so, hold its value in val
            break; // and break out of for loop
        }
    }
    return val; // return value of checked radio or undefined if none checked
}
</script>
 
<script type="text/javascript">
    window.onload = function () { 
    	var x = '${output}';
	    $("input[value="+x+"]").click();
	    var y = '${algorithm}';
	    $("input[value="+y+"]").click();
	    var k = '${knowledgebase}';
	    $("input[value="+k+"]").click();
    }
</script>

</body>
</html>
