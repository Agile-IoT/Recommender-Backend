package at.tugraz.ist.agileRecommender;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import at.tugraz.ist.agileRecommender.lucene.app.App;
import at.tugraz.ist.agileRecommender.lucene.app.ParseApp;
import at.tugraz.ist.agileRecommender.lucene.app.RecommendedAppList;
import at.tugraz.ist.agileRecommender.lucene.workflow.ParseWF;
import at.tugraz.ist.agileRecommender.lucene.workflow.RecommendedWorkFlowList;
import at.tugraz.ist.agileRecommender.lucene.workflow.WorkFlow;

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
		
		int count =1;
		for (Iterator<App> it = RecommendedAppList.appList.iterator(); it.hasNext(); ) {
		        App f = it.next();
		        results += "<a href=https://play.google.com/"+f.getHref().toString()+">"+count+"."+f.getTitle().toString()+"</a>"+"<br>";
		        count++;
		}
		return results;
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
		
		int count =1;
		for (Iterator<WorkFlow> it = RecommendedWorkFlowList.workflowList.iterator(); it.hasNext(); ) {
		        WorkFlow f = it.next();
		        results += "<a href=http://flows.nodered.org"+f.getHref().toString()+">"+count+"."+f.href.toString()+"</a>"+"<br>";
		        count++;
		}
		return results;
	}
	

}
