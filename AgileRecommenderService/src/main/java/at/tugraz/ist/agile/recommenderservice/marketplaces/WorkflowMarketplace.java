package at.tugraz.ist.agile.recommenderservice.marketplaces;

import java.util.ArrayList;
import java.util.List;
import at.tugraz.ist.agile.recommenderservice.models.Workflow;

public class WorkflowMarketplace {
	
	public static List<Workflow> workflowList = new ArrayList<Workflow>();
	
	public static void addNewWorkFlow(Workflow wf){
		workflowList.add(wf);
	}

}
