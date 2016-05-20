package at.tugraz.ist.agileRecommender.lucene.app;

import java.util.ArrayList;
import java.util.List;

public class RecommendedAppList {
	
	public static List<App> appList = new ArrayList<App>();
	
	public static void addNewApp(App a){
		appList.add(a);
	}

}
