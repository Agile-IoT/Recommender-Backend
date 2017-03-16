package at.tugraz.ist.agile.recommender.models;

import org.springframework.beans.factory.annotation.Autowired;

public class GatewayProfile {
	

	public long userID;
	public ListOfDevices devices;
	public ListOfApps apps;
	public ListOfWFs wfs;
	public String resources;
	public String location;
	public String pricingPreferences;
	
	public GatewayProfile(){
		this.userID = 0;
		this.devices = new ListOfDevices();
		this.apps = new ListOfApps();;
		this.wfs = new ListOfWFs();; 
		this.resources = "";
		this.location = "";
		this.pricingPreferences = "";
		
	}
	public GatewayProfile (long id, ListOfDevices str1, ListOfApps str2, ListOfWFs str3, String str4, String loc,String pricing){
		this.userID = id;
		this.devices = str1;
		this.apps = str2;
		this.wfs = str3; 
		this.resources = str4;
		this.location = loc;
		this.pricingPreferences = pricing;
	}
	
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPricingPreferences() {
		return pricingPreferences;
	}
	public void setPricingPreferences(String pricingPreferences) {
		this.pricingPreferences = pricingPreferences;
	}
	public ListOfDevices getDevices() {
		return devices;
	}
	public void setDevices(ListOfDevices devices) {
		this.devices = devices;
	}
	public ListOfApps getApps() {
		return apps;
	}
	public void setApps(ListOfApps apps) {
		this.apps = apps;
	}
	public ListOfWFs getWfs() {
		return wfs;
	}
	public void setWfs(ListOfWFs wfs) {
		this.wfs = wfs;
	}
	
	

}
