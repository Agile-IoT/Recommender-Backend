package at.tugraz.ist.agile.recommender;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import at.tugraz.ist.agile.recommender.marketplaces.*;
import at.tugraz.ist.agile.recommender.marketplaces.parsers.*;
import at.tugraz.ist.agile.recommender.models.*;

@Controller
public class Controller_Recommender {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_Recommender.class);
	 

	public static void initiate() {

		AppMarketplace.initiate();
		ParseDockerHub.getAppList("IoT");
		AppMarketplace.stopAddingToMarketplace();
		
		WorkflowMarketplace.initiate();
		ParseNodeRed.getWorkFlows();
		WorkflowMarketplace.stopAddingToMarketplace();
		
		CloudMarketplace.initiate();
		ParseCloud.getClouds();
		CloudMarketplace.stopAddingToMarketplace();
		
		DeviceMarketplace.initiate();
		ParseDeviceStore.getDevList("IoT");
		DeviceMarketplace.stopAddingToMarketplace();
	
	}
  
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to the AGILE Gateway Recommender Service! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
    

    @RequestMapping(value = "/updateRepositories", method = RequestMethod.GET)
	public String updateRepositories() {
    	initiate();
    	return "home";
		
	}
   
    
	@RequestMapping(value = "/getAppRecommendation", method = RequestMethod.POST)
	public @ResponseBody RecommendedApps getAppRecommendation(@RequestBody GatewayProfile profile) {
		
		RecommendedApps appList = new RecommendedApps();
		appList.setAppList(Recommenders.getAppRecommendations(profile));
		return appList;
	}
	
	@RequestMapping(value = "/getDeviceRecommendation", method = RequestMethod.POST)
	public @ResponseBody RecommendedDevices getDeviceRecommendation(@RequestBody GatewayProfile profile) {
		
		RecommendedDevices devList = new RecommendedDevices();
		devList.setDeviceList(Recommenders.getDevRecommendations(profile));
		return devList;
	}
   
	
	@RequestMapping(value = "/getWorkflowRecommendation", method = RequestMethod.POST)
	public @ResponseBody RecommendedWFs getWorkflowRecommendation(@RequestBody GatewayProfile profile) {
		
		RecommendedWFs wfList = new RecommendedWFs();
		wfList.setWfList(Recommenders.getWorklowRecommendations(profile));
		return wfList;
	} 
	
	
	@RequestMapping(value = "/getCloudRecommendation", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RecommendedClouds getCloudRecommendation(@RequestBody GatewayProfile profile) {
		
		RecommendedClouds clList = new RecommendedClouds();
		clList.setCloudList(Recommenders.getCloudRecommendation(profile));
		return clList;
	}

   
}