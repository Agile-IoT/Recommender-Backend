package at.tugraz.ist.agile.recommenderservice;

import java.util.List;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import at.tugraz.ist.agile.recommenderservice.models.*;

@RestController
@EnableAutoConfiguration
public class Controller_RecommenderService {
	
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the AGILE Gateway Recommender Service";
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