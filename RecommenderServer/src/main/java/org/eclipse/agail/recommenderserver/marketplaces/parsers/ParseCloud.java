/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.marketplaces.parsers;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.eclipse.agail.recommenderserver.FileOperations;
import org.eclipse.agail.recommenderserver.marketplaces.CloudMarketplace;
import org.eclipse.agail.recommenderserver.marketplaces.WorkflowMarketplace;
import org.eclipse.agail.recommenderserver.models.Cloud;

public class ParseCloud {
	
	public static void getClouds() {
		    String url_repo = System.getProperty("user.dir")+"\\Clouds";
		    FileOperations.cleanFile(url_repo);
			Properties prop = new Properties();
			InputStream input = null;
		
			try {
		
				String filename = "CloudMarketplace.properties";
				input = ParseCloud.class.getClassLoader().getResourceAsStream(filename);
				if(input==null){
			            System.out.println("Sorry, unable to find " + filename);
				    return;
				}
			
		
				//load a properties file from class path, inside static method
				prop.load(input);
		
		        //get the property value and print it out
				String[] titles = prop.getProperty("titles").split(";");
				String[] links = prop.getProperty("links").split(";");
				String[] accesstype = prop.getProperty("accesstype").split(";");
				String[] locations = prop.getProperty("locations").split(";");
				String[] middlewares = prop.getProperty("middlewares").split(";");
				String[] frameworks = prop.getProperty("frameworks").split(";");
				String[] runtimes = prop.getProperty("runtimes").split(";");
				String[] services = prop.getProperty("services").split(";");
				String[] pricing = prop.getProperty("pricing").split(";");
				
				for(int i=0; i<titles.length;i++){
					Cloud cloudToBeAdded = new Cloud(titles[i],links[i],accesstype[i],locations[i],middlewares[i],frameworks[i],runtimes[i],services[i],pricing[i]);
					System.out.println(cloudToBeAdded.getTitle());
					String newLine= "Cloud #"+(i+1)+ " = Name:" + titles[i]+ ", Href:" + links[i];
					System.out.println(newLine);
					FileOperations.appendNewLineToFile(url_repo, newLine);
				    
					CloudMarketplace.addNewCloud(cloudToBeAdded);
				}
				
			} catch (IOException ex) {
				ex.printStackTrace();
		    } finally{
		    	if(input!=null){
		    		try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    	}    
		   }
		 
	 }

}
