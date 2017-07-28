/*******************************************************************************
 * Copyright (C) 2017 TU Graz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TU Graz - initial API and implementation
 ******************************************************************************/
package at.tugraz.ist.agile.recommender.marketplaces.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import at.tugraz.ist.agile.recommender.marketplaces.CloudMarketplace;
import at.tugraz.ist.agile.recommender.marketplaces.WorkflowMarketplace;
import at.tugraz.ist.agile.recommender.models.Cloud;

public class ParseCloud {
	

	public static void getClouds() {
		 
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
