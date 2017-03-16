package at.tugraz.ist.agile.recommender;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import at.tugraz.ist.agile.recommender.collaborative.CollaborativeFiltering;
import at.tugraz.ist.agile.recommender.marketplaces.parsers.ParseGooglePlayStore;
import at.tugraz.ist.agile.recommender.marketplaces.parsers.ParseNodeRed;
import at.tugraz.ist.agile.recommender.models.*;


public class Recommenders {
	
	public static ListOfApps getAppRecommendations(GatewayProfile profile){
		
		String query = getQuery(profile);
		
		RecommendApps recommendApp = new RecommendApps();
	
		try {
			recommendApp.getRecommendation(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfApps recommondedApps_CF = cf.getAppRecommendation(profile);
		
		ListOfApps recommondedApps_CB = recommendApp.recommendedApps;
		ListOfApps totalList = new ListOfApps(); 
		totalList.getAppList().addAll(recommondedApps_CF.getAppList());
		totalList.getAppList().addAll(recommondedApps_CB.getAppList());
		return totalList;
	}
	
	public static ListOfDevices getDevRecommendations(GatewayProfile profile){
		
		String query = getQuery(profile);
		
		RecommendDevices recommendDev = new RecommendDevices();
	
		try {
			recommendDev.getRecommendation(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfDevices recommondedDevs_CF = cf.getDeviceRecommendation(profile);
		
		ListOfDevices recommondedDevs_CB = recommendDev.recommendedDevices;
		
		ListOfDevices totalList = new ListOfDevices(); 
		totalList.getDeviceList().addAll(recommondedDevs_CF.getDeviceList());
		totalList.getDeviceList().addAll(recommondedDevs_CB.getDeviceList());
		return totalList;
		
	}
	
	public static ListOfWFs getWorklowRecommendations(GatewayProfile profile){
		
		RecommendWorkFlow recommendWf = new RecommendWorkFlow();
		
		try {
			recommendWf.getRecommendation(getQuery(profile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return recommendWf.recommendedWorkflows;
		
		ListOfWFs recommondedWf_CB = recommendWf.recommendedWorkflows;

		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfWFs recommondedWf_CF = cf.getWorkflowRecommendation(profile);
		
		ListOfWFs totalList = new ListOfWFs(); 
		totalList.getWfList().addAll(recommondedWf_CF.getWfList());
		totalList.getWfList().addAll(recommondedWf_CB.getWfList());
		
		return totalList;
		
		
	}
	
	public static ListOfClouds getCloudRecommendation(GatewayProfile profile){
		
		RecommendCloud recommendCloud = new RecommendCloud();
		
		try {
			recommendCloud.getRecommendation(profile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListOfClouds recommondedCl_CB = recommendCloud.recommendedClouds;

		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfClouds recommondedCl_CF = cf.getCloudRecommendation(profile);
		
		ListOfClouds totalList = new ListOfClouds(); 
		totalList.getCloudList().addAll(recommondedCl_CF.getCloudList());
		totalList.getCloudList().addAll(recommondedCl_CB.getCloudList());
		
		return totalList;
	
	}
	
	private static String getRecommAppStr(String results, List<App> appList){
		
		int count =1;
		for (Iterator<App> it = appList.iterator(); it.hasNext(); ) {
		        App f = it.next();
		        results += "<a href=https://play.google.com/"+f.getHref().toString()+">"+count+"."+f.getTitle().toString()+"</a>"+"<br>";
		        count++;
		}
		return results;
		
	}
	
	private static String getRecommWfStr(String results, List<Workflow> workflowList){
		
		int count =1;
		for (Iterator<Workflow> it = workflowList.iterator(); it.hasNext(); ) {
				Workflow f = it.next();
		        results += "<a href=http://flows.nodered.org"+f.getHref().toString()+">"+count+"."+f.href.toString()+"</a>"+"<br>";
		        count++;
		}
		return results;
		
	}
	
	private static String getQuery(GatewayProfile profi){
		
		String query  = "Raspberry";
		String query1 = "";
		String query2 = "";
		String query3 = "";
		
		if(profi.apps.getAppList()!=null)
		for(int i=0;i<profi.apps.getAppList().size();i++){
			query1 = profi.apps.getAppList().get(i).getTitle();
			query = query+" OR "+ query1;
		}
		
		if(profi.wfs.getWfList()!=null)
		for(int i=0;i<profi.wfs.getWfList().size();i++){
			query2 = profi.wfs.getWfList().get(i).getDatatag();
			query = query+" OR "+ query2;
		}
		
		if(profi.devices.getDeviceList()!=null)
		for(int i=0;i<profi.devices.getDeviceList().size();i++){
			query3 = profi.devices.getDeviceList().get(i).getTitle();
			query = query+" OR "+ query3;
		}
		
		return query;
	}

}

