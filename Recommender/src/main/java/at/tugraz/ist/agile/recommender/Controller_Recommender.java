package at.tugraz.ist.agile.recommender;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import at.tugraz.ist.agile.recommender.marketplaces.AppMarketplace;
import at.tugraz.ist.agile.recommender.marketplaces.CloudMarketplace;
import at.tugraz.ist.agile.recommender.marketplaces.WorkflowMarketplace;
import at.tugraz.ist.agile.recommender.marketplaces.parsers.ParseCloud;
import at.tugraz.ist.agile.recommender.marketplaces.parsers.ParseDockerHub;
import at.tugraz.ist.agile.recommender.marketplaces.parsers.ParseNodeRed;
import at.tugraz.ist.agile.recommender.models.*;

@Controller
public class Controller_Recommender {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_Recommender.class);
	
	public static void main(String[] args) {

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
    
    @ResponseBody
	@RequestMapping(value = "/getAppRecommendation", method = RequestMethod.POST)
	public List<App> getAppRecommendation(@RequestBody GatewayProfile profile) {
		
		return Recommenders.getAppRecommendations(profile);
	}
    
    @ResponseBody
	@RequestMapping(value = "/getWorkflowRecommendation", method = RequestMethod.POST)
	public List<Workflow> getWorkflowRecommendation(@RequestBody GatewayProfile profile) {
		
		return Recommenders.getWorklowRecommendations(profile);
	}
    
    @ResponseBody
	@RequestMapping(value = "/getCloudRecommendation", method = RequestMethod.POST)
	public List<Cloud> getCloudRecommendation(@RequestBody GatewayProfile profile) {
		
		return Recommenders.getCloudRecommendation(profile);
	}

   
}