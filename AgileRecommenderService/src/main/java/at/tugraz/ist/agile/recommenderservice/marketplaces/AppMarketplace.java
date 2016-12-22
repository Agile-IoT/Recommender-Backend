package at.tugraz.ist.agile.recommenderservice.marketplaces;

import java.util.ArrayList;
import java.util.List;

import at.tugraz.ist.agile.recommenderservice.models.App;

public class AppMarketplace {
	
	public static List<App> appList = new ArrayList<App>();
	
	public static void addNewApp(App a){
		appList.add(a);
	}

}
