package at.tugraz.ist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import at.tugraz.ist.agile.configurator.models.App;
import at.tugraz.ist.agile.configurator.models.GatewayProfile;
import at.tugraz.ist.agile.configurator.models.Results;



public class ConfigurationManager {


	List<App> installedApps = new ArrayList<App>();
	GatewayProfile configuredProfile = new GatewayProfile();
	GatewayProfile profile = new GatewayProfile();
	
	
	
	public GatewayProfile getAppConfigurations(){
		RestTemplate restTemplate = new RestTemplate();
		MappingJacksonHttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJacksonHttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		
		getGatewayProfile();
		
		final String uri = "http://localhost:8090/configurator/getResourceOptimization";
		 
		configuredProfile = restTemplate.postForObject(uri, profile, GatewayProfile.class);
		
		return configuredProfile;
	}
	
	public void getGatewayProfile(){
		
		// TODO : should be taken from the gateway.
		// for demo , we fill it statically here
		profile.setSupportedConnectivityProtocolsOfGateway(new int[] {0,1,2,3});
		profile.setSupportedDataEncodingProtocolsOfGateway(new int[] {1,3});
		profile.setUserRequirementWeight_Cost(-1);
		profile.setUserRequirementWeight_Performance(1);
		profile.setUserRequirementWeight_Reliability(1);
		
		App app1 = new App();
		app1.setName("App-0");
		app1.setSupportedDataEncodingProtocolsOfApp(new int[] {0,2});
		app1.setSupportedConnectivitiyProtocolsOfApp(new int[] {2,3});
		
		App app2 = new App();
		app2.setName("App-1");
		app2.setSupportedDataEncodingProtocolsOfApp(new int[] {3,2});
		app2.setSupportedConnectivitiyProtocolsOfApp(new int[] {1,3});

		profile.setInstalledApps(new App[]{app1,app2});
		
		return;
	}

}
