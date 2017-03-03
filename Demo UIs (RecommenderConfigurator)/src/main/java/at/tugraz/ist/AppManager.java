package at.tugraz.ist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import at.tugraz.ist.agile.recommender.models.App;
import at.tugraz.ist.agile.recommender.models.GatewayProfile;
import at.tugraz.ist.agile.recommender.models.RecommendedApps;


public class AppManager {

	List<App> installedApps = new ArrayList<App>();
	RecommendedApps recommendedApps = new RecommendedApps();
	GatewayProfile profile = new GatewayProfile();
	
	
	public RecommendedApps getRecommendedApps(){
		
		RestTemplate restTemplate = new RestTemplate();
		MappingJacksonHttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJacksonHttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		
		getGatewayProfile();
		
		final String uri = "http://localhost:8080/Recommender/getAppRecommendation";
		 
		recommendedApps = restTemplate.postForObject(uri, profile, RecommendedApps.class);
		
		return recommendedApps;
		
	}
	
	public void getGatewayProfile(){
		
		// TODO : should be taken from the gateway.
		// for demo , we fill it statically here
		
		
		return;
	}
	
	
	
	
}
