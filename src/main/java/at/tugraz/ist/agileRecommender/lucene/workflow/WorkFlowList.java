package at.tugraz.ist.agileRecommender.lucene.workflow;

import java.util.ArrayList;
import java.util.List;

public class WorkFlowList {
	
	public static List<WorkFlow> workflowList = new ArrayList<WorkFlow>();
	
	public static void addNewWorkFlow(String type){
		workflowList.add(new WorkFlow(type));
	}

}
