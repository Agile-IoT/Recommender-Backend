/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/

package org.eclipse.agail.recommenderserver;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.eclipse.agail.recommenderserver.marketplaces.*;
import org.eclipse.agail.recommenderserver.marketplaces.parsers.*;
import org.eclipse.agail.recommenderserver.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controller_Recommender {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_Recommender.class);
	
	private static boolean initFlag = false;

	public static void initiate() {
		
		CloudMarketplace.initiate();
		ParseCloud.getClouds();
		CloudMarketplace.stopAddingToMarketplace();
		
		WorkflowMarketplace.initiate();
		ParseNodeRed.getWorkFlows();
		WorkflowMarketplace.stopAddingToMarketplace();
		
		DeviceMarketplace.initiate();
		ParseDeviceStore.getDevList();
		DeviceMarketplace.stopAddingToMarketplace();
		
		
		initFlag = true;
	}
  
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
    	
		logger.info("Welcome to the AGILE Gateway Recommender Service! The client locale is {}.", locale);
		
		if (!initFlag)
			initiate();
		
		if (initFlag){
			List<String> cloudsRepoLines = new ArrayList<String>(CloudMarketplace.size);
			//Path cloudsRepo = Paths.get(System.getProperty("user.dir")+"\\Clouds");
			List<String> wfsRepoLines = new ArrayList<String>(WorkflowMarketplace.size);
			//Path wfsRepo = Paths.get(System.getProperty("user.dir")+"\\Workflows");
			List<String> devicesRepoLines= new ArrayList<String>(DeviceMarketplace.size);
			//Path devicesRepo = Paths.get(System.getProperty("user.dir")+"\\Devices");
		   
//			try {    
//		    	cloudsRepoLines = Files.readAllLines(cloudsRepo, StandardCharsets.UTF_8);
//		    	wfsRepoLines = Files.readAllLines(wfsRepo, StandardCharsets.UTF_8);
//		    	devicesRepoLines = Files.readAllLines(devicesRepo, StandardCharsets.UTF_8);
//		    } catch (Exception e) {}
//		    
//		    for(int i=0;i<cloudsRepoLines.size();i++){
//		    	String[]vals = cloudsRepoLines.get(i).split(":");
//		    	cloudsRepoLines.set(i,"https:"+vals[vals.length-1]);
//		    }
//		    
//		    for(int i=0;i<devicesRepoLines.size();i++){
//		    	String[]vals = devicesRepoLines.get(i).split(":");
//		    	devicesRepoLines.set(i,"https:"+vals[vals.length-1]);
//		    }
//		    
//		    for(int i=0;i<wfsRepoLines.size();i++){
//		    	String[]vals = wfsRepoLines.get(i).split(":");
//		    	wfsRepoLines.set(i,"https:"+vals[vals.length-1]);
//		    }
			
			for(int i=0;i<CloudMarketplace.size;i++)
				cloudsRepoLines.add(CloudMarketplace.cloudList.get(i).link);
			
			for(int i=0;i<WorkflowMarketplace.size;i++)
				wfsRepoLines.add(WorkflowMarketplace.workflowList.get(i).href); 
			
			for(int i=0;i<DeviceMarketplace.size;i++)
				devicesRepoLines.add(DeviceMarketplace.devList.get(i).getHref()); 
		       
			
			model.addAttribute("wfs", wfsRepoLines.size());
			model.addAttribute("devs", devicesRepoLines.size());
			model.addAttribute("clouds", cloudsRepoLines.size());
			
			// ====== changes from here based on Aeseir's answer========
		    
		    model.addAttribute("workflowList", wfsRepoLines);
		    model.addAttribute("deviceList", devicesRepoLines);
		    model.addAttribute("cloudList", cloudsRepoLines);
		       // ======= changes until here ==============
		}
		return "home";
	}
    
    @RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody GatewayProfile test(@RequestBody GatewayProfile profile) {
		GatewayProfile prof = new GatewayProfile();
		prof.devices.addDevice(new Device("devicename", "hrefofdevice"));
		
		return prof;
	}

//    @RequestMapping(value = "/updateRepositories", method = RequestMethod.GET)
//    public String updateRepositories() {
//    	initiate();
//    	return "home";
//		
//	}
	
    @RequestMapping(value = "/getRepositoryStatus", method = RequestMethod.GET)
   	public @ResponseBody String getRepositoryStatus() {
   		String status = "";
   		status += "Number Of Workflows: "+WorkflowMarketplace.size; 
   		status += ", Number Of Devices: "+DeviceMarketplace.size; 
   		status += ", Number Of Clouds: "+CloudMarketplace.size; 
   		return status;
   	}
    
	
	
	@RequestMapping(value = "/getDeviceRecommendation", method = RequestMethod.POST)
	public @ResponseBody ListOfDevices getDeviceRecommendation(@RequestBody GatewayProfile profile) {
		
		ListOfDevices devList = new ListOfDevices();
		devList = Recommenders.getDevRecommendations(profile);
		return devList;
	}
   
	@RequestMapping(value = "/getWorkflowRecommendation", method = RequestMethod.POST)
	public @ResponseBody ListOfWFs getWorkflowRecommendation(@RequestBody GatewayProfile profile) {
		
		ListOfWFs wfList = new ListOfWFs();
		wfList = Recommenders.getWorklowRecommendations(profile);
		return wfList;
	} 
	
	@RequestMapping(value = "/getCloudRecommendation", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ListOfClouds getCloudRecommendation(@RequestBody GatewayProfile profile) {
		
		if(profile.location=="")
			profile.location = "EU";
		if(profile.pricingPreferences=="")
			profile.pricingPreferences = "free";
		ListOfClouds clList = new ListOfClouds();
		clList = Recommenders.getCloudRecommendation(profile);
		return clList;
	}
	
}