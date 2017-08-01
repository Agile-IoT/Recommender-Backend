package org.eclipse.agail.recommenderserver.models;

import java.util.ArrayList;
import java.util.List;

public class ListOfApps {
	
	private List<App> appList = new ArrayList<App>();

	public List<App> getAppList() {
		return appList;
	}

	public void setAppList(List<App> appList) {
		this.appList = appList;
	}

	
}
