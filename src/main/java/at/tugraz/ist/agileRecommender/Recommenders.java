package at.tugraz.ist.agileRecommender;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import at.tugraz.ist.agileRecommender.lucene.app.App;
import at.tugraz.ist.agileRecommender.lucene.app.ParseApp;
import at.tugraz.ist.agileRecommender.lucene.app.RecommendedAppList;
import at.tugraz.ist.agileRecommender.lucene.workflow.ParseWF;
import at.tugraz.ist.agileRecommender.lucene.workflow.RecommendedWorkFlowList;
import at.tugraz.ist.agileRecommender.lucene.workflow.WorkFlow;
import at.tugraz.ist.agileRecommender.mahout.UserBased;
import at.tugraz.ist.agileRecommender.profile.Profile;

public class Recommenders {
	
	public static Set<App> getCBAppRecomm(Profile profile){
		
		String query = getQuery(profile);
		
		ParseApp.getAppList(query);
		RecommendedAppList.appList.clear();
		
		try {
			RecommendApps.getRecommendation(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RecommendedAppList.appList;
	}
	
	public static String getCBAppRecomm(Profile profile, String results){
		getCBAppRecomm(profile);
		return getRecommAppStr(results, new ArrayList<App>(RecommendedAppList.appList));
	}
	
	
	public static Set<WorkFlow> getCBWfRecomm(Profile profile){
		
		ParseWF.getWorkFlows();
		RecommendedWorkFlowList.workflowList.clear();
		
		try {
			RecommendWorkFlow.getRecommendation(getQuery(profile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RecommendedWorkFlowList.workflowList;
	}
	
	public static String getCBWfRecomm(Profile profile, String results){
		
		getCBWfRecomm(profile);
		
		return getRecommWfStr(results, new ArrayList<WorkFlow>(RecommendedWorkFlowList.workflowList));
	}
	
	
	public static List<App> getUBCFAppRecomm(long userID){
		return UserBased.getUBCFApps(userID);
	}
	
	public static String getUBCFAppRecomm(long userID, String results){
		List<App> res = getUBCFAppRecomm(userID);
		return getRecommAppStr(results, res);
	}
	
	public static List<WorkFlow> getUBCFWfRecomm(long userID){
		return UserBased.getUBCFWfs(userID);
	}
	
	public static String getUBCFWfRecomm(long userID, String results){
		List<WorkFlow> res = getUBCFWfRecomm(userID);
		return getRecommWfStr(results, res);
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
	
	private static String getRecommWfStr(String results, List<WorkFlow> workflowList){
		
		int count =1;
		for (Iterator<WorkFlow> it = workflowList.iterator(); it.hasNext(); ) {
		        WorkFlow f = it.next();
		        results += "<a href=http://flows.nodered.org"+f.getHref().toString()+">"+count+"."+f.href.toString()+"</a>"+"<br>";
		        count++;
		}
		return results;
		
	}
	
	private static String getQuery(Profile profi){
		
		String query ="iot";
		
		String query1 ="iot";
		String query2 ="iot";
		String query3 ="iot";
		
		if(profi.apps.length()>0){
			query1 = profi.apps.replace(" ", " OR ");
			query1 = query1.replace(",", " OR ");
		}
		
		if(profi.wfs.length()>0){
			query2 = profi.wfs.replace(" ", " OR ");
			query2 = query2.replace(",", " OR ");
		}
		
		if(profi.devices.length()>0){
		query3 = profi.devices.replace(" ", " OR ");
		query3 = query3.replace(",", " OR ");
		}
		
		query = (query+" OR "+ query1+" OR "+ query2+" OR "+ query3);
		
		return query;
	}

}
