/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.collaborative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.GenericUserSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.eclipse.agail.recommenderserver.models.App;
import org.eclipse.agail.recommenderserver.models.Cloud;
import org.eclipse.agail.recommenderserver.models.Device;
import org.eclipse.agail.recommenderserver.models.GatewayProfile;
import org.eclipse.agail.recommenderserver.models.ListOfApps;
import org.eclipse.agail.recommenderserver.models.ListOfClouds;
import org.eclipse.agail.recommenderserver.models.ListOfDevices;
import org.eclipse.agail.recommenderserver.models.ListOfWFs;
import org.eclipse.agail.recommenderserver.models.Workflow;
import org.springframework.beans.factory.annotation.Autowired;

public class CollaborativeFiltering {
	
	
	 List<RecommendedItem> recommendations=null;

	 
	//public String itemsFile = "C:\\Users\\spolater\\Desktop\\AGILE\\AGILE-GITHUB\\Recommender\\Recommender\\files\\items.data";
	//public String userProfilesFile = "C:\\Users\\spolater\\Desktop\\AGILE\\AGILE-GITHUB\\Recommender\\Recommender\\files\\UserProfiles.data";
	
	public String itemsFile = "/usr/share/tomcat8/webapps/files/items.data";
	public String userProfilesFile = "/usr/share/tomcat8/webapps/files/UserProfiles.data";
	
	 
	ListOfApps apps = new ListOfApps();
	ListOfDevices devs = new ListOfDevices();
	ListOfWFs wfs = new ListOfWFs();
	ListOfClouds clouds = new ListOfClouds();
	
	public ListOfApps getAppRecommendation(GatewayProfile profile){
		applyCollaborativeFiltering(profile);
		return apps;
	}
	
	public ListOfDevices getDeviceRecommendation(GatewayProfile profile){

		applyCollaborativeFiltering(profile);
		return devs;
	}
	
	public ListOfWFs getWorkflowRecommendation(GatewayProfile profile){
		applyCollaborativeFiltering(profile);
		return wfs;
	}
	
	public ListOfClouds getCloudRecommendation(GatewayProfile profile){
		applyCollaborativeFiltering(profile);
		return clouds;
	}
	
	
	private void applyCollaborativeFiltering(GatewayProfile profile){
		
		int userID = addNewItemsandUser(profile);
		System.out.println("userID: "+userID);
		
		try {
			// load the data from the file with format "userID,itemID,value"
			DataModel model = new FileDataModel(new File(userProfilesFile));
			
			//  compute the correlation coefficient between their interactions
			//UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			UserSimilarity similarity = new EuclideanDistanceSimilarity(model);
			// we'll use all that have a similarity greater than 0.1
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
			//UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);
			
			// all the pieces to create our recommender
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			
			//  get 10 items recommended for the user with userID 
			recommendations = recommender.recommend(userID, 10);
			
			for (RecommendedItem recommendation : recommendations) {
				System.out.println(recommendation);
				String item = getItem(recommendation.getItemID());
				if(item.split(",")[0].contains("App")){
					apps.getAppList().add( new App("App",item.split(",")[1],0,0));
				}
				else if(item.split(",")[0].contains("Device")){
					devs.getDeviceList().add( new Device("Device",item.split(",")[1]));
				}
				else if(item.split(",")[0].contains("Workflow")){
					wfs.getWfList().add( new Workflow("Workflow","Workflow","Workflow",item.split(",")[1]));
				}
				else if(item.split(",")[0].contains("Cloud")){
					clouds.getCloudList().add( new Cloud("Cloud",item.split(",")[1],"","","","","","",""));
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getItem(long itemNumber){

		String item =null;
		try (Stream<String> lines = Files.lines(Paths.get(itemsFile))) {
			item = lines.skip(itemNumber).findFirst().get();
		}catch(Exception ex){}
		
		return item;
	}
	
	private int addNewItemsandUser(GatewayProfile profile){
		int newuserID = getLastUserID()+1;
		
		int numberOfApps = 0;
		int numberOfWfs = 0;
		int numberOfDevices = 0;
		int numberOfClouds = 0;
		
		
		if(profile.apps.getAppList()!=null)
			numberOfApps = profile.apps.getAppList().size();
		if(profile.wfs.getWfList()!=null)
			numberOfWfs = profile.wfs.getWfList().size();
		if(profile.devices.getDeviceList()!=null)
			numberOfDevices = profile.devices.getDeviceList().size();
		if(profile.clouds.getCloudList()!=null)
			numberOfClouds = profile.clouds.getCloudList().size();
		
		int itemNumber=-2;
		
		for(int i=0;i<numberOfApps;i++){
			itemNumber = parseFile(profile.apps.getAppList().get(i).getHref());
			if(itemNumber<0)
				itemNumber=appendToBottomOfFile("App,"+profile.apps.getAppList().get(i).getHref(),itemsFile);
			appendToBottomOfFile(newuserID+","+itemNumber+",5.0",userProfilesFile);
		}
		for(int i=0;i<numberOfWfs;i++){
			itemNumber = parseFile(profile.wfs.getWfList().get(i).getHref());
			if(itemNumber<0)
				itemNumber=appendToBottomOfFile("Workflow,"+profile.wfs.getWfList().get(i).getHref(),itemsFile);

			appendToBottomOfFile(newuserID+","+itemNumber+",5.0",userProfilesFile);
		}
		for(int i=0;i<numberOfDevices;i++){
			itemNumber = parseFile(profile.devices.getDeviceList().get(i).getHref());
			if(itemNumber<0)
				itemNumber=appendToBottomOfFile("Device,"+profile.devices.getDeviceList().get(i).getHref(),itemsFile);
			appendToBottomOfFile(newuserID+","+itemNumber+",5.0",userProfilesFile);
		}
		
		for(int i=0;i<numberOfClouds;i++){
			itemNumber = parseFile(profile.clouds.getCloudList().get(i).getLink());
			if(itemNumber<0)
				itemNumber=appendToBottomOfFile("Cloud,"+profile.clouds.getCloudList().get(i).getLink(),itemsFile);
			appendToBottomOfFile(newuserID+","+itemNumber+",5.0",userProfilesFile);
		}
		
	
		return newuserID;
		
	}
	
	private int parseFile(String searchStr){
		 int itemNumber = -1;
		 File file = new File(itemsFile);
		 try{
		     Scanner scan = new Scanner(file);
		     int counter= -1;
		     while(scan.hasNext()){
		    	 	counter++;
		            String line = scan.nextLine().toLowerCase().toString();
		            if(line.contains(searchStr)){
		                //System.out.println(line);
		            	itemNumber = counter;
		            	break;
		            }
		           
		     }
		     scan.close();
		 }catch(Exception e){}
	     return itemNumber;
	 }
	
//	public void appendToTopOfFile(String line,String filename) {
//		
//		RandomAccessFile f;
//		try {
//			f = new RandomAccessFile(new File(filename), "rw");
//			f.seek(0); // to the beginning
//			f.write(line.getBytes());
//			f.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
	public int appendToBottomOfFile(String line,String filename) {
		
		line = "\n"+line;
	    int lineNumber=0;
		try {
			
			Files.write(Paths.get(filename), line.getBytes(), StandardOpenOption.APPEND);
			
			
			File file = new File(filename);
			Scanner fileScanner = new Scanner(file);

		    while(fileScanner.hasNextLine()){
		         System.out.println(fileScanner.nextLine());
		         lineNumber++;
		    }
		    fileScanner.close();
		  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineNumber-1;
		
	}
	
	public int getLastUserID(){
		int userID = 0;
		
		try {
			//BufferedReader reader = new BufferedReader(new FileReader(userProfilesFile));
			String lastLine="1,1";
			Scanner sc=new Scanner(new File(userProfilesFile));
		    while(sc.hasNextLine()){  //checking for the presence of next Line
		        	lastLine =sc.nextLine();  //reading and storing all lines
		    }
		    sc.close();  //close the scanner
		    userID = Integer.valueOf(lastLine.split(",")[0]);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return userID;
		}
		
}
