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

import java.text.DateFormat;
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
		
		DeviceMarketplace.initiate();
		ParseDeviceStore.getDevList();
		DeviceMarketplace.stopAddingToMarketplace();
		
		WorkflowMarketplace.initiate();
		ParseNodeRed.getWorkFlows();
		WorkflowMarketplace.stopAddingToMarketplace();
		
	
		
		initFlag = true;
	}
  
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
    	
		logger.info("Welcome to the AGILE Gateway Recommender Service! The client locale is {}.", locale);
		
		if (!initFlag)
			initiate();
				
		model.addAttribute("wfs", WorkflowMarketplace.size);
		model.addAttribute("devs", DeviceMarketplace.size);
		model.addAttribute("clouds", CloudMarketplace.size);
		
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