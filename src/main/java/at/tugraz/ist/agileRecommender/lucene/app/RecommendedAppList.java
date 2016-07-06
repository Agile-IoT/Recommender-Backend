package at.tugraz.ist.agileRecommender.lucene.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecommendedAppList {
	
	public static Set<App> appList = new HashSet<App>();
	
	public static void addNewApp(App a){
		appList.add(a);
	}

}
