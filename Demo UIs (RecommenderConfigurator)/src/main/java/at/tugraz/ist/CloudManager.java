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
import at.tugraz.ist.agile.recommender.models.RecommendedClouds;


public class CloudManager {

	List<App> installedApps = new ArrayList<App>();
	GatewayProfile profile = new GatewayProfile();
	
	
	RecommendedClouds recommendedClouds = new RecommendedClouds();
	
	
	
	public RecommendedClouds getRecommendedClouds(){
		
		RestTemplate restTemplate = new RestTemplate();
		MappingJacksonHttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJacksonHttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
	
		
		getGatewayProfile();
		
		final String uri = "http://localhost:8080/Recommender/getCloudRecommendation";
		 
		recommendedClouds = restTemplate.postForObject(uri, profile, RecommendedClouds.class);
		
		return recommendedClouds;
		
	}
	
	public void getGatewayProfile(){
		
		// TODO : should be taken from the gateway.
		// for demo , we fill it statically here
	
		
		return;
	}
	
	
	
	
}
