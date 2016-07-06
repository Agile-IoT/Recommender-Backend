package at.tugraz.ist.agileRecommender.lucene.workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecommendedWorkFlowList {
	
	public static Set<WorkFlow> workflowList = new HashSet<WorkFlow>();
	
	public static void addNewWorkFlow(WorkFlow wf){
		workflowList.add(wf);
	}

}
