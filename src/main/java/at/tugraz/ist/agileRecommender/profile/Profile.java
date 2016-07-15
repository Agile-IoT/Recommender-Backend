package at.tugraz.ist.agileRecommender.profile;

public class Profile {
	
	public long userID;
	
	public String devices;
	public String apps;
	public String wfs;
	public String resources;
	
	public Profile(){
		
	}
	public Profile(long id, String str1,String str2,String str3,String str4){
		this.userID = id;
		this.devices = str1;
		this.apps = str2;
		this.wfs = str3; 
		this.resources = str4;
	}
	
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getDevices() {
		return devices;
	}
	public void setDevices(String devices) {
		this.devices = devices;
	}
	public String getApps() {
		return apps;
	}
	public void setApps(String apps) {
		this.apps = apps;
	}
	public String getWfs() {
		return wfs;
	}
	public void setWfs(String wfs) {
		this.wfs = wfs;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	
	

}
