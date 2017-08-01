/*******************************************************************************
 * Copyright (C) 2017 TUGraz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TUGraz - initial API and implementation
 ******************************************************************************/

package org.eclipse.agail.recommenderserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.eclipse.agail.recommenderserver.collaborative.CollaborativeFiltering;
import org.eclipse.agail.recommenderserver.models.App;
import org.eclipse.agail.recommenderserver.models.GatewayProfile;
import org.eclipse.agail.recommenderserver.models.ListOfApps;
import org.eclipse.agail.recommenderserver.models.ListOfDevices;
import org.eclipse.agail.recommenderserver.models.ListOfWFs;

public class Test {
	
	public static CollaborativeFiltering cf = new CollaborativeFiltering();
	static Recommenders recommenders = new Recommenders();
	public static String testFile = "C:\\Users\\spolater\\Desktop\\AGILE\\AGILE-GITHUB\\Recommender\\Recommender\\files\\test.csv";
	public static String testFile2 = "C:\\Users\\spolater\\Desktop\\AGILE\\AGILE-GITHUB\\Recommender\\Recommender\\files\\test2.csv";	

	public static void main(String[] args){
		
		//testFiles();
		testCollaborativeFiltering();
		//testgetAppRecommendation(); // size= 2
		//testgetDeviceRecommendation();  // size= 2
		//testgetWFRecommendation(); // size= 3
	}
	
	public static void testFiles(){
		System.out.println(cf.userProfilesFile);
		System.out.println(cf.itemsFile);
		
		
		System.out.println(cf.getLastUserID());
		System.out.println(cf.getItem(0));
			
		int lastline= cf.appendToBottomOfFile("7,5,5.0", cf.userProfilesFile);
		int lastline2= cf.appendToBottomOfFile("App,hebele", cf.itemsFile);
		
		System.out.println(cf.getLastUserID());
		System.out.println(cf.getItem(0));
	}

	
	public static void testgetAppRecommendation(){
		GatewayProfile profile = new GatewayProfile();
		List<App> appList = new ArrayList<App>();
		appList.add(new App("App","hebele",0,0));
		profile.apps.setAppList(appList);
		
		ListOfApps recs = cf.getAppRecommendation(profile);
		System.out.println(recs.getAppList().size());
		
	}
	
	public static void testgetWFRecommendation(){
		GatewayProfile profile = new GatewayProfile();
		List<App> appList = new ArrayList<App>();
		appList.add(new App("App","hebele",0,0));
		profile.apps.setAppList(appList);
		
		ListOfWFs recs = cf.getWorkflowRecommendation(profile);
		System.out.println(recs.getWfList().size());
		
	}
	
	public static void testgetDeviceRecommendation(){
		GatewayProfile profile = new GatewayProfile();
		List<App> appList = new ArrayList<App>();
		appList.add(new App("App","hebele",0,0));
		profile.apps.setAppList(appList);
		
		ListOfDevices recs = cf.getDeviceRecommendation(profile);
		System.out.println(recs.getDeviceList().size());
		
	}
	
	public static void testCollaborativeFiltering (){
		
		System.out.println("testCollaborativeFiltering");
		
		try {
			// load the data from the file with format "userID,itemID,value"
			DataModel model = new FileDataModel(new File(testFile2));
			
			//  compute the correlation coefficient between their interactions
			UserSimilarity similarity = new EuclideanDistanceSimilarity(model);
			
			double similar= similarity.userSimilarity(1, 2);
			System.out.println(similar);
			
			// we'll use all that have a similarity greater than 0.1
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
			
			// all the pieces to create our recommender
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			
			//  get three items recommended for the user with userID 2
			List<RecommendedItem> recommendations = recommender.recommend(2, 10);
			for (RecommendedItem recommendation : recommendations) {
				System.out.println(recommendation);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
