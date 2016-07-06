package at.tugraz.ist.agileRecommender.profile;

import java.util.Random;

public class RandomProfileGenerator {

	public Profile gwProfile;
	
	String[] devices = {"temperature sensor","gas sensor","pressure sensor","zigbee","ble"};

	String[] apps = {"temprature alarm","fire alarm","smart home manager"};

	String[] wfs = {"temprature sensor node","gas sensor node","temperature alarm workflow","fire alarm workflow"};

	
	String memory = "Memory = %";
	String power = "Power= ";
	String cpu = "CPU = %";
	
	public Profile generateProfile (){
		
		gwProfile = new Profile();
		
		// DEVICE LIST
		Random randomGenerator = new Random();
	    int numberOfdevices = randomGenerator.nextInt(4)+1;
	    
	    String deviceList = "";
	    for (int i=0;i<numberOfdevices;i++){
	    	if(i>0)
	    		deviceList += ",";
	    	deviceList += devices[i];
	    }
		
	    gwProfile.devices = deviceList; 
	  
		// APP LIST
		int numberOfapps = randomGenerator.nextInt(3);
	    
	    String appList = "";
	    for (int i=0;i<numberOfapps;i++){
	    	if(i>0)
	    		appList += ",";
	    	appList += apps[i];
	    }
		
	    gwProfile.apps = appList; 
	    
	    
	    
		// WF LIST
		int numberOfwfs = randomGenerator.nextInt(4);
	    
	    String wfList = "";
	    for (int i=0;i<numberOfwfs;i++){
	    	if(i>0)
	    		wfList += ",";
	    	wfList += wfs[i];
	    }
		
	    gwProfile.wfs = wfList; 	    

		// Resources
		int cpuLevel = randomGenerator.nextInt(100);
		int memoryLevel = randomGenerator.nextInt(100);
		int batteryLevel = randomGenerator.nextInt(100);
	    
		boolean isBattery = randomGenerator.nextBoolean();
		
		if (isBattery){
			power +="Battery Mode %";
			power += batteryLevel;
		}
		else
			power +="AC Mode";
	    
		memory += memoryLevel;
		cpu += cpuLevel;
		
	    gwProfile.resources = memory+ ","+ cpu + ","+ power ; 
	   
	    
		return gwProfile;
	}
		
		
			
}
