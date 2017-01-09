package at.tugraz.ist.agile.recommender;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
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
	public @ResponseBody List<App> getAppRecommendation(@RequestBody GatewayProfile profile) {
		
		return Recommenders.getAppRecommendations(profile);
	}
   
	
	@RequestMapping(value = "/getWorkflowRecommendation")
	public @ResponseBody List<Workflow> getWorkflowRecommendation(@RequestBody GatewayProfile profile) {
		
		return Recommenders.getWorklowRecommendations(profile);
	} 
	
	
	@RequestMapping(value = "/getCloudRecommendation")
	public @ResponseBody List<Cloud> getCloudRecommendation(@RequestBody GatewayProfile profile) {
		
		return Recommenders.getCloudRecommendation(profile);
	}

   
}