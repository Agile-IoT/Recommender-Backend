package at.tugraz.ist;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.tugraz.ist.agile.configurator.models.GatewayProfile;
import at.tugraz.ist.agile.configurator.models.Results;
import at.tugraz.ist.agile.recommender.models.App;
import at.tugraz.ist.agile.recommender.models.RecommendedApps;
import at.tugraz.ist.agile.recommender.models.RecommendedClouds;
import at.tugraz.ist.agile.recommender.models.RecommendedDevices;
import at.tugraz.ist.agile.recommender.models.RecommendedWFs;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "agilemenu";
	}
	
	@RequestMapping(value = "/appconfigurator", method = RequestMethod.GET)
	public String appconfigurator(Locale locale, Model model) {
		
		ConfigurationManager confmng = new ConfigurationManager();
		GatewayProfile configuredApps= confmng.getAppConfigurations();
		
		model.addAttribute("appname1", "1- "+configuredApps.getInstalledApps()[0].getName());
		model.addAttribute("dataencoding1", "Data Encoding Protocol ID: &nbsp;"+configuredApps.getInstalledApps()[0].getInUse_DataEncodingProtocol());
		model.addAttribute("connencoding1", "Connectivity Protocol ID: &nbsp;"+configuredApps.getInstalledApps()[0].getInUse_ConnectivitiyProtocol());
		
		model.addAttribute("appname2", "2- "+configuredApps.getInstalledApps()[1].getName());
		model.addAttribute("dataencoding2", "Data Encoding Protocol ID: &nbsp;"+configuredApps.getInstalledApps()[1].getInUse_DataEncodingProtocol());
		model.addAttribute("connencoding2", "Connectivity Protocol ID: &nbsp;"+configuredApps.getInstalledApps()[1].getInUse_ConnectivitiyProtocol());
		
		model.addAttribute("errormessage", "Error Message: </br>"+configuredApps.getErrorMessage());

		
		return "appconfigurator";
	}
	
	 
    @RequestMapping(value = "/appmanager")
	public String appmanager(Locale locale, Model model) {
    	
		AppManager appmng = new AppManager();
		RecommendedApps recomApps= appmng.getRecommendedApps();
		
		model.addAttribute("appname1", "1- "+recomApps.getAppList().get(0).getTitle()+":");
		model.addAttribute("apphref1", recomApps.getAppList().get(0).getHref());
		model.addAttribute("exp1", "This app is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		

		model.addAttribute("appname2", "2- "+recomApps.getAppList().get(1).getTitle()+":");
		model.addAttribute("apphref1", recomApps.getAppList().get(1).getHref());
		model.addAttribute("exp2", "This app is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		

		model.addAttribute("appname3", "3- "+recomApps.getAppList().get(2).getTitle()+":");
		model.addAttribute("apphref3", recomApps.getAppList().get(2).getHref());
		model.addAttribute("exp3", "This app is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		

		model.addAttribute("appname4", "4- "+recomApps.getAppList().get(3).getTitle()+":");
		model.addAttribute("apphref4", recomApps.getAppList().get(3).getHref());
		model.addAttribute("exp4", "This app is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		

		model.addAttribute("appname5", "5- "+recomApps.getAppList().get(4).getTitle()+":");
		model.addAttribute("apphref5", recomApps.getAppList().get(4).getHref());
		model.addAttribute("exp5", "This app is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		return "appmanager";
	}
    
    @RequestMapping(value = "/devmanager", method = RequestMethod.GET)
	public String devmanager(Locale locale, Model model) {
    	DeviceManager devmng = new DeviceManager();
    	RecommendedDevices recomDevs= devmng.getRecommendedDevices();
		
		model.addAttribute("devname1", "1- "+recomDevs.getDeviceList().get(0).getTitle()+":");
		model.addAttribute("devhref1", recomDevs.getDeviceList().get(0).getHref());
		model.addAttribute("exp1", "This device is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		model.addAttribute("devname2", "2- "+recomDevs.getDeviceList().get(1).getTitle()+":");
		model.addAttribute("devhref2", recomDevs.getDeviceList().get(1).getHref());
		model.addAttribute("exp1", "This device is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		model.addAttribute("devname3", "3- "+recomDevs.getDeviceList().get(2).getTitle()+":");
		model.addAttribute("devhref3", recomDevs.getDeviceList().get(2).getHref());
		model.addAttribute("exp3", "This device is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		model.addAttribute("devname4", "4- "+recomDevs.getDeviceList().get(3).getTitle()+":");
		model.addAttribute("devhref4", recomDevs.getDeviceList().get(3).getHref());
		model.addAttribute("exp4", "This device is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		model.addAttribute("devname5", "5- "+recomDevs.getDeviceList().get(4).getTitle()+":");
		model.addAttribute("devhref5", recomDevs.getDeviceList().get(4).getHref());
		model.addAttribute("exp5", "This device is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
		
		return "devmanager";
	}
    
    @RequestMapping(value = "/nodered", method = RequestMethod.GET)
	public String nodered(Locale locale, Model model) {
		
    	WFManager wfmng = new WFManager();
    	RecommendedWFs recomWFs= wfmng.getRecommendedWFs();
		
		model.addAttribute("wfname1", "1- "+recomWFs.getWfList().get(0).getType()+":");
		model.addAttribute("wfhref1", recomWFs.getWfList().get(0).getHref());
		model.addAttribute("exp1", "This workflow/node is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
				
		model.addAttribute("wfname2", "2- "+recomWFs.getWfList().get(1).getType()+":");
		model.addAttribute("wfhref2", recomWFs.getWfList().get(1).getHref());
		model.addAttribute("exp2", "This workflow/node is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
				
		model.addAttribute("wfname3", "3- "+recomWFs.getWfList().get(2).getType()+":");
		model.addAttribute("wfhref3", recomWFs.getWfList().get(2).getHref());
		model.addAttribute("exp3", "This workflow/node is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
				
		CloudManager clmng = new CloudManager();
    	RecommendedClouds recomCLs= clmng.getRecommendedClouds();
		
		model.addAttribute("cloudname1", "1- "+recomCLs.getCloudList().get(0).getTitle()+":");
		model.addAttribute("cloudhref1", recomCLs.getCloudList().get(0).getLink());
		model.addAttribute("exp4", "This cloud server is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
				
		model.addAttribute("cloudname2", "2- "+recomCLs.getCloudList().get(1).getTitle()+":");
		model.addAttribute("cloudhref2", recomCLs.getCloudList().get(1).getLink());
		model.addAttribute("exp5", "This cloud server is recommended to you because "+"it is related to your installed apps and plugged devices"+".");
				
		
		return "nodered";
	}
    
	
}
