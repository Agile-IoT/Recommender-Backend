package at.tugraz.ist.agileRecommender.lucene.workflow;

import java.util.ArrayList;
import java.util.List;

public class RecommendedWorkFlowList {
	
	public static List<WorkFlow> workflowList = new ArrayList<WorkFlow>();
	
	public static void addNewWorkFlow(WorkFlow wf){
		workflowList.add(wf);
	}

}
