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
    border: none;
    color: #33b5e5;
    padding: 15px 90px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(
	    function() {
	    	var x = '${output}';
	    	$("input[value="+x+"]").click();
	    	var y = '${algorithm}';
	    	$("input[value="+y+"]").click();
	    	
	    });
</script>

</head>
<body>

<div class="header">
<h1>AGILE Recommender Server</h1>
</div>

<div class="row">


<div class="col-4 menu">
<ul>
<h1>Gateway Profile</h1>
<li>
<p><b>Create Your Gateway Profile</b></p>
<form action="/agileRecommender/getRecommendation" method="post">
  	Apps:<br><input type="text" name="apps" value="${apps}" size="50"><br>
	Workflows:<br><input type="text" name="wfs" value="${wfs}" size="50"><br>
	Devices:<br><input type="text" name="devices" value="${devices}" size="50"><br>
	Resources:<br><input type="text" name="resources" value="${resources}" size="50"><br>
	Algorithm:<br><input type="radio" name="alg" value="CB"> Content Based<br>
  				  <input type="radio" name="alg" value="UBCF" > User Based CF<br>
 				  <input type="radio" name="alg" value="IBCF"> Item Based CF<br>
 	Output:<br><input type="radio" name="out" id="out" value="App"> App<br>
  				  <input type="radio" name="out" id="out" value="Workflow" > Workflow<br>
 				  <input type="radio" name="out" id="out" value="Device" > Device<br>
   <input class="button" type="submit" value="Calculate Recommendation">
</form>
<li>
</ul>
</div>

<div class="col-5 menu">
<h1>Recommendation Results</h1>
<p>${results}</p>
</div>
</div>
 
</body>
</html>
