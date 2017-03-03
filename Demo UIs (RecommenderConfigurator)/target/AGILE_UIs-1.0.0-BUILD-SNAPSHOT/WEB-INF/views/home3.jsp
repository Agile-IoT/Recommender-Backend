<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>AGILE Recommender UI</title>
    
    <spring:url value="/resources/img/dashbard4_1.jpg" var="background" />
    
    <spring:url value="/resources/css/bootstrap.min.css" var="mincss" />
	<spring:url value="/resources/font-awesome/css/font-awesome.css" var="font" />
	<spring:url value="/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" var="checkbox" />
	<spring:url value="/resources/css/plugins/switchery/switchery.css" var="switchery" />
	<spring:url value="/resources/css/style.css" var="style" />
	<spring:url value="/resources/js/jquery-2.1.1.js" var="jquery" />

    <link href="${mincss}" rel="stylesheet">
    <link href="${font}" rel="stylesheet">
    <link href="${checkbox}" rel="stylesheet">
    <link href="${switchery}" rel="stylesheet">
    <link href="${style}" rel="stylesheet">
    <script src="${jquery}"></script>
    
    
	<script type="text/javascript">
		
	    $(document).ready(function(){
	    	$("#createRooms").click(function(){
	        	$("#tableTbodyRooms").empty();
	        	
	        	var kitchens = parseInt($("#numberOfKitchens").val())+1;
	        	var step = 1;
	        	
	        	for (step = 1; step < kitchens; step++) {
	        	  	// Runs 5 times, with values of step 0 through 4.
	        	  	console.log('Walking east one step');
	        	  	
		            var markup = "<tr><td>Kitchen-"+step+"</td>"
		            			 +"<td><input type='checkbox'  checked class='i-checks' name='Kitchen-"+step+"-Fridge'></td>"
		           				 +"<td><input type='checkbox'   class='i-checks' name='Kitchen-"+step+"-TV'></td>"
		            		     + "<td><input type='checkbox'  checked class='i-checks' name='Kitchen-"+step+"-Stove'></td></tr>";
		            $("#tableTbodyRooms").append(markup);
	        	}    
		            
	        	
	        	var bathrooms = parseInt($("#numberOfBathrooms").val())+1;
	        	step = 1;
	        	for (step = 1; step < bathrooms; step++) {
	        	  	// Runs 5 times, with values of step 0 through 4.
	        	  	console.log('Walking east one step');
	        	    var markup = "<tr><td>Bathroom-"+step+"</td>"
				       			 +"<td><input type='checkbox'   class='i-checks' name='Bathroom-"+step+"-Fridge'></td>"
				      				 +"<td><input type='checkbox'   class='i-checks' name='Bathroom-"+step+"-TV'></td>"
				       		     + "<td><input type='checkbox'  checked class='i-checks' name='Bathroom-"+step+"-Stove'></td></tr>";
				       $("#tableTbodyRooms").append(markup);
	        	}
	        	
	        	var livingrooms = parseInt($("#numberOfLivingrooms").val())+1;
	        	step = 1;
	        	for (step = 1; step < livingrooms; step++) {
	        	  	// Runs 5 times, with values of step 0 through 4.
	        	  	console.log('Walking east one step');
	        	  	var markup = "<tr><td>Livingroom-"+step+"</td>"
			       			 +"<td><input type='checkbox'  checked class='i-checks' name='Livingroom-"+step+"-Fridge'></td>"
			      				 +"<td><input type='checkbox'  checked class='i-checks' name='Livingroom-"+step+"-TV'></td>"
			       		     + "<td><input type='checkbox'  checked class='i-checks' name='Livingroom-"+step+"-Stove'></td></tr>";
			       $("#tableTbodyRooms").append(markup);
	        	}
	        	
	        	var bedrooms = parseInt($("#numberOfBedrooms").val())+1;
	        	step = 1;
	        	for (step = 1; step < bedrooms; step++) {
	        	  	// Runs 5 times, with values of step 0 through 4.
	        	  	console.log('Walking east one step');
	        	  	var markup = "<tr><td>Bedroom-"+step+"</td>"
			       			 +"<td><input type='checkbox'  checked class='i-checks' name='Bedroom-"+step+"-Fridge'></td>"
			      				 +"<td><input type='checkbox'  checked class='i-checks' name='Bedroom-"+step+"-TV'></td>"
			       		     + "<td><input type='checkbox'  checked class='i-checks' name='Bedroom-"+step+"-Stove'></td></tr>";
			       $("#tableTbodyRooms").append(markup);
	        	}
	        	
	        	var otherrooms = parseInt($("#numberOfOtherRooms").val())+1;
	        	step = 1;
	        	for (step = 1; step < otherrooms; step++) {
	        	  	// Runs 5 times, with values of step 0 through 4.
	        	  	console.log('Walking east one step');
	        	  	var markup = "<tr><td>OtherRoom-"+step+"</td>"
			       			 +"<td><input type='checkbox'  checked class='i-checks' name='OtherRoom-"+step+"-Fridge'></td>"
			      				 +"<td><input type='checkbox'  checked class='i-checks' name='OtherRoom-"+step+"-TV'></td>"
			       		     + "<td><input type='checkbox'  checked class='i-checks' name='OtherRoom-"+step+"-Stove'></td></tr>";
			       $("#tableTbodyRooms").append(markup);
	        	}
	        	
	        	
	       
	        });
	     
	    });   
	   </script>
		
	   <script type="text/javascript">
	   	
		 $(document).ready(function(){
			 $("#go").click(function(){
		
        		$("#tableTbodyResults").empty();
        	
	        	var userInput = {
	    				isComfortControlNeeded: document.getElementById("isComfortControlNeeded").checked,
	    				isEnergySavingNeeded: document.getElementById("isEnergySavingNeeded").checked,
	    				isHealthSupportNeeded: document.getElementById("isHealthSupportNeeded").checked,
	    				isSafetySecurityNeeded: document.getElementById("isSafetySecurityNeeded").checked,
	    				isCostImportant: document.getElementById("isCostImportant").checked,
	    				isStabilityNeeded: document.getElementById("isStabilityNeeded").checked,
	    				isSensibleToElectricSmog: document.getElementById("isSensibleToElectricSmog").checked,
	    				smartHome: {
	    					areTubesInstalled: document.getElementById("areTubesInstalled").checked,
	    					builtWith: document.getElementById("builtWith").value,
	    					communication: document.getElementById("communication").value,
	    					age: document.getElementById("age").value,
	    					installation: document.getElementById("installation").value,
	    					rooms: []
	    				}
	    		};
	    		
	    		console.log(userInput);
	    	    var userInputObj = JSON.stringify(userInput);
	    	    console.log(userInputObj);
	            
		    	 $.ajax({
		    	        url: "http://localhost:8080/rest/solver",
		    	        type: 'POST',
		    	        data: userInputObj,  
		    	        contentType: "application/json; charset=utf-8",
		    	        success: function(json) {
		    	        	console.log(json);
		    	        	var counter = 0;
		    	        	var markup="";
		    	        	$.each(json, function(index, obj) {
		    	        			counter++;
		    	        			// console.log(obj.age);
		    	                    markup = "<tr>"+
		    	                    "<td>Option-"+counter+"</td>"+
	    	                		"<td>"+obj.age+"</td>"+
	    	                		"<td>"+obj.areTubesInstalled+"</td>"+
	    	                		"<td>"+obj.builtWith+"</td>"+
	    				            "<td>"+obj.communication+"</td>"+
	    				            "</tr>";
		    	                    $("#tableTbodyResults").append(markup);
		    	             });
		    	        	if(markup==""){
		    	        		 	markup = "<tr>"+
		    	                    "<td>Option-"+0+"</td>"+
	    	                		"<td>NO SOLUTION</td>"+
	    	                		"<td>NO SOLUTION</td>"+
	    	                		"<td>NO SOLUTION</td>"+
	    	                		"<td>NO SOLUTION</td>"+
	    				            "</tr>";
		    	                    $("#tableTbodyResults").append(markup);
		    	        	}
		    	        		
		    	        }
		    	    	
		    	  });
    	});  
			 });
		 </script>
	
	
	
	
	
</head>

<body background="${background}">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">      
            <h2>
                AGILE Recommender UI
            </h2>
        </div>
        <div class="col-lg-2">  
        </div>  
                
    </div>
    <div class="wrapper wrapper-content animated fadeInRight">
      
       		<div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Please select your smarthome preferences: </h5>
                        <div class="ibox-content">
								<form id="formTakeInputs">
								 	<div class="col-lg-3">
		                                Energy Saving Mode: <input type="checkbox" id="isEnergySavingNeeded" class="js-switch_r2" /> </br>
		                                High Security Mode: <input type="checkbox" id="isSafetySecurityNeeded" class="js-switch_r3" /></br>
		                                Age: <select data-placeholder="Choose a Country..." id="age" class="chosen-select" style="width:100px;" tabindex="2">
										                <option value="0">0</option>
									                </select>
							                	
		                              
		                            </div>
		                            <div class="col-lg-3">
		                                Full Comfort Mode: <input type="checkbox" id="isComfortControlNeeded" class="js-switch_r4" /> </br>
	                                	Health Support Mode: <input type="checkbox" id="isHealthSupportNeeded" class="js-switch_r5" /></br>
	                                	Building Material: <select data-placeholder="Choose a Country..." id="builtWith" class="chosen-select" style="width:100px;" tabindex="2">
										                <option value="Steel">Steel</option>
										                <option value="Other">Wood</option>
										                <option value="Other">Other</option>
									                </select>
							                	
	                                </div>
	                                <div class="col-lg-3">
		                                High Stability Mode: <input type="checkbox" id="isStabilityNeeded" class="js-switch_r6" /></br>
		                                Low Cost Mode: <input type="checkbox" id="isCostImportant" class="js-switch_r7"  /></br>
		                                Communication Mode: <select data-placeholder="Choose a Country..." id="communication" class="chosen-select" style="width:100px;" tabindex="2">
										                <option value="Wired">Wired</option>
										                <option value="Wireless">Wireless</option>
									                </select>
	                                </div>
	                                <div class="col-lg-3">
		                                Electric Smog Sensitivity Mode: <input id="isSensibleToElectricSmog" type="checkbox" class="js-switch_r8" /></br>
		                                Tube Installation Mode: <input type="checkbox" id="areTubesInstalled" class="js-switch_r10" /></br>
		                                Installation Mode: <select data-placeholder="Choose a Country..." id="installation" class="chosen-select" style="width:100px;" tabindex="2">
										                <option value="Professional">Professional</option>
										                <option value="DIY">DIY</option>
									                </select>
									    
	                                </div>
	                           
	               
	    					
	                            </form>
                              </br>
                              </br>
                              </br>
                              </br>
                              </br>
                              </br>
                              </br>
                        </div>
                    </div>
                </div>
        
         </div>
         <div class="row">
         		 <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Please select your room preferences:</h5>  <button type="button" id="createRooms" class="btn btn-sm btn-primary" style="position: absolute; right: 0;"> Create Rooms!</button> </span></div> 
                        <div class="ibox-content">
                           <form>
                             <div class="row">
		                            <div class="col-lg-2">
			                            <h3>
			                                Kitchen
			                            </h3>
			                             Number of Kitchens:</br>
		                                <div class="m-r-md inline">
		                                <input type="text" id="numberOfKitchens" value="2" class="dial m-r" data-fgColor="#1AB394" data-width="85" data-height="85" data-step="1" data-min="1" data-max="10" data-displayPrevious=true/>
		                                </div>
		                               
		                               
		                            </div> 
		                            <div class="col-lg-2">
		                            	<h3>
			                                Bathroom
			                            </h3>
			                             Number of Bathrooms:</br>
		                                <div class="m-r-md inline">
		                                <input type="text" id="numberOfBathrooms" value="2" class="dial m-r" data-fgColor="#1AB394" data-width="85" data-height="85" data-step="1" data-min="1" data-max="10" data-displayPrevious=true/>
		                                </div>
		                            </div> 
		                            <div class="col-lg-2">
				                        <h3>
			                                Livingroom
			                            </h3>
			                             Number of Livingrooms:</br>
		                                <div class="m-r-md inline">
		                                <input type="text" id="numberOfLivingrooms" value="3" class="dial m-r" data-fgColor="#1AB394" data-width="85" data-height="85" data-step="1" data-min="1" data-max="10" data-displayPrevious=true/>
		                                </div>
		                            </div> 
		                            
		                            <div class="col-lg-2">
				                        <h3>
			                                Bedroom
			                            </h3>
			                             Number of Bedrooms:</br>
		                                <div class="m-r-md inline">
		                                <input type="text" id="numberOfBedrooms" value="2" class="dial m-r" data-fgColor="#1AB394" data-width="85" data-height="85" data-step="1" data-min="1" data-max="10" data-displayPrevious=true/>
		                                </div>
		                            </div> 
		                            
		                            <div class="col-lg-4">
				                        <h3>
			                                Other Room
			                            </h3>
			                             Number of Other Rooms:</br>
		                                <div class="m-r-md inline">
		                                <input type="text" id="numberOfOtherRooms" value="0" class="dial m-r" data-fgColor="#1AB394" data-width="85" data-height="85" data-step="1" data-min="0" data-max="10" data-displayPrevious=true/>
		                                </div>
		                            </div> 
	                         </div>
	                         </form>
	                         
	                         <div class="row">
	                          <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
								        <th>RoomType</th>
								        <th>Fridge</th>
								        <th>TV</th>
								        <th>Stove</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tableTbodyRooms">
                                    
                                   
                                    </tbody>
                                </table>
                           		</div>
	                         </div>  
	                                             
                         </div>
                    </div> 
                </div>  
         </div>
      
	<div class="row">
        <div class="col-lg-12">

                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Configuration Options for your Smarthome </h5> </span></div> 
                        <div class="ibox-content">
                            <h3>
                            Do you want to see configuration options? &nbsp;
                            <button type="button" id="go" class="btn btn-sm btn-primary"> &nbsp;Go!&nbsp;&nbsp;</button>
                                
                            </h3>
                             <div class="row">
	                          <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                    	<th>Configuration Options</th>
                                    	<th>Age</th>
								        <th>Tubes</th>
								        <th>Built with</th>
								        <th>Network Type</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tableTbodyResults">
                                    
                                   
                                    </tbody>
                                </table>
                           		</div>
	                         </div>  
                                
                        </div>
                    </div>
                </div>
        </div>
  
    </div>
    </div>
    
    
    <!-- Mainly scripts -->
    <spring:url value="/resources/js/bootstrap.min.js" var="minjs" />
    <spring:url value="/resources/js/plugins/switchery/switchery.js" var="switchjs" />
    
    
    <script src="${jquery}"></script>
    <script src="${minjs}"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

    <!-- Custom and plugin javascript -->

    <!-- Switchery -->
    <script src="${switchjs}"></script>
   
    <!-- Custom and plugin javascript -->
    <spring:url value="/resources/js/plugins/pace/pace.min.js" var="minjs2" />
    <spring:url value="/resources/js/plugins/slimscroll/jquery.slimscroll.min.js" var="slimscroll" />
    
    <script src="${minjs2}"></script>
    <script src="${slimscroll}"></script>
   
    <!-- JSKnob -->
    <spring:url value="/resources/js/plugins/jsKnob/jquery.knob.js" var="knob" />
    <script src="${knob}"></script>

    <script>
        $(document).ready(function(){


            var elem2 = document.querySelector('.js-switch_r2');
            var switchery2 = new Switchery(elem2, { color: '#1AB394' });

            var elem3 = document.querySelector('.js-switch_r3');
            var switchery3 = new Switchery(elem3, { color: '#1AB394' });

            var elem4 = document.querySelector('.js-switch_r4');
            var switchery4 = new Switchery(elem4, { color: '#1AB394' });

            var elem5 = document.querySelector('.js-switch_r5');
            var switchery5 = new Switchery(elem5, { color: '#1AB394' });

            var elem6 = document.querySelector('.js-switch_r6');
            var switchery6 = new Switchery(elem6, { color: '#1AB394' });

            var elem7 = document.querySelector('.js-switch_r7');
            var switchery7 = new Switchery(elem7, { color: '#1AB394' });


            var elem8 = document.querySelector('.js-switch_r8');
            var switchery8 = new Switchery(elem8, { color: '#1AB394' });

            var elem9 = document.querySelector('.js-switch_r9');
            var switchery9 = new Switchery(elem9, { color: '#1AB394' });
            
            var elem10 = document.querySelector('.js-switch_r10');
            var switchery10 = new Switchery(elem10, { color: '#1AB394' });
            
            var elem11 = document.querySelector('.js-switch_r11');
            var switchery11 = new Switchery(elem11, { color: '#1AB394' });
            
            var elem12 = document.querySelector('.js-switch_r12');
            var switchery12 = new Switchery(elem12, { color: '#1AB394' });
            
            var elem13 = document.querySelector('.js-switch_r13');
            var switchery13 = new Switchery(elem13, { color: '#1AB394' });
            
            var elem14 = document.querySelector('.js-switch_r14');
            var switchery14 = new Switchery(elem14, { color: '#1AB394' });


        });

        $(".dial").knob();
    </script>
   </script>
   
</body>

</html>
