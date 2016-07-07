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

public class Recommenders {
	
	public static Set<App> getCBAppRecomm(App app){
		ParseApp.getAppList(app.getTitle());
		RecommendedAppList.appList.clear();
		
		try {
			RecommendApps.getRecommendation(app.getTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RecommendedAppList.appList;
	}
	
	public static String getCBAppRecomm(App app, String results){
		
		getCBAppRecomm(app);
		return getRecommAppStr(results, new ArrayList<App>(RecommendedAppList.appList));
	}
	
	
	public static Set<WorkFlow> getCBWfRecomm(WorkFlow wf){
		ParseWF.getWorkFlows();
		RecommendedWorkFlowList.workflowList.clear();
		
		try {
			RecommendWorkFlow.getRecommendation(wf.getDatatag());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RecommendedWorkFlowList.workflowList;
	}
	
	public static String getCBWfRecomm(WorkFlow wf, String results){
		
		getCBWfRecomm(wf);
		
		return getRecommWfStr(results, new ArrayList<WorkFlow>(RecommendedWorkFlowList.workflowList));
	}
	
	
	public static List<App> getUBCFAppRecomm(){
		return UserBased.getUBCFApps();
	}
	
	public static String getUBCFAppRecomm(String results){
		List<App> res = UserBased.getUBCFApps();
		return getRecommAppStr(results, res);
	}
	
	public static List<WorkFlow> getUBCFWfRecomm(){
		return UserBased.getUBCFWfs();
	}
	
	public static String getUBCFWfRecomm(String results){
		List<WorkFlow> res = getUBCFWfRecomm();
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

}
