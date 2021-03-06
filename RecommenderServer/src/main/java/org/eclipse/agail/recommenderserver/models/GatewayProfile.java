/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.models;

import org.springframework.beans.factory.annotation.Autowired;

public class GatewayProfile {
	
	public ListOfDevices devices;
	public ListOfApps apps;
	public ListOfWFs wfs;
	public ListOfClouds clouds;
	public String location;
	public String pricingPreferences;
	public String requiredServices;
	
	
	public GatewayProfile(){
		this.devices = new ListOfDevices();
		this.apps = new ListOfApps();
		this.wfs = new ListOfWFs();
		this.location = "";
		this.pricingPreferences = "";
		this.clouds = new ListOfClouds();
		this.requiredServices = "";
	}
	
	public GatewayProfile (ListOfDevices str1, ListOfApps str2, ListOfWFs str3, String loc,String pricing, ListOfClouds clouds, String requiredServices){
		
		this.devices = str1;
		this.apps = str2;
		this.wfs = str3; 
		this.location = loc;
		this.pricingPreferences = pricing;
		this.clouds = clouds;
		this.requiredServices = requiredServices;
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
	public ListOfClouds getClouds() {
		return clouds;
	}
	public void setClouds(ListOfClouds clouds) {
		this.clouds = clouds;
	}
	public String getRequiredServices() {
		return requiredServices;
	}
	public void setRequiredServices(String requiredServices) {
		this.requiredServices = requiredServices;
	}
	

}
