/*******************************************************************************
 /*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.BooleanClause;
import org.eclipse.agail.recommenderserver.collaborative.CollaborativeFiltering;
import org.eclipse.agail.recommenderserver.marketplaces.CloudMarketplace;
import org.eclipse.agail.recommenderserver.marketplaces.parsers.ParseGooglePlayStore;
import org.eclipse.agail.recommenderserver.marketplaces.parsers.ParseNodeRed;
import org.eclipse.agail.recommenderserver.models.*;


public class Recommenders {
	
//	public static void main(String [] args){
//		
//		// TEST
//		Workflow wf = new Workflow();
//		//wf.setType("node");
//		//wf.setHref("/node/node-red-contrib-ftp-server");
//		
//		wf.setType("flow");
//		wf.setHref("/flow/51f68bd87a897caa5c3148457cc084c0");
//		
//		
//		List wfList = new ArrayList<Workflow>();
//		wfList.add(wf);
//		
//		ListOfWFs totalList = new ListOfWFs();
//		totalList.setWfList(wfList);
//		
//		totalList = updateFlowsNodes(totalList);
//		
//	}
//	
	public static ListOfApps getAppRecommendations(GatewayProfile profile){
		
		String query = getQuery(profile,0);
		
		RecommendApps recommendApp = new RecommendApps();
	
		try {
			recommendApp.getRecommendation(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfApps recommondedApps_CF = cf.getAppRecommendation(profile);
		
		ListOfApps recommondedApps_CB = recommendApp.recommendedApps;
		ListOfApps totalList = new ListOfApps(); 
		totalList.getAppList().addAll(recommondedApps_CF.getAppList());
		totalList.getAppList().addAll(recommondedApps_CB.getAppList());
		return totalList;
	}
	
	public static ListOfDevices getDevRecommendations(GatewayProfile profile){
		
		String query = getQuery(profile,1);
		
		RecommendDevices recommendDev = new RecommendDevices();
	
		try {
			recommendDev.getRecommendation(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfDevices recommondedDevs_CF = cf.getDeviceRecommendation(profile);
		
		ListOfDevices recommondedDevs_CB = recommendDev.recommendedDevices;
		
		ListOfDevices totalList = new ListOfDevices(); 
		totalList.getDeviceList().addAll(recommondedDevs_CF.getDeviceList());
		totalList.getDeviceList().addAll(recommondedDevs_CB.getDeviceList());
		return totalList;
		
	}
	
	public static ListOfWFs getWorklowRecommendations(GatewayProfile profile){
		
		String query = getQuery(profile,2);
		
		RecommendWorkFlow recommendWf = new RecommendWorkFlow();
		
		try {
			recommendWf.getRecommendation(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return recommendWf.recommendedWorkflows;
		
		ListOfWFs recommondedWf_CB = recommendWf.recommendedWorkflows;
		
		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfWFs recommondedWf_CF = cf.getWorkflowRecommendation(profile);
		
		ListOfWFs totalList = new ListOfWFs(); 
		totalList.getWfList().addAll(recommondedWf_CF.getWfList());
		totalList.getWfList().addAll(recommondedWf_CB.getWfList());
		
		totalList = updateFlowsNodes(totalList);
		
		return totalList;
		
	}
	
	public static ListOfClouds getCloudRecommendation(GatewayProfile profile){
		
		RecommendCloud recommendCloud = new RecommendCloud();
		
		try {
			recommendCloud.getRecommendation(profile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListOfClouds recommondedCl_CB = recommendCloud.recommendedClouds;

		CollaborativeFiltering cf = new CollaborativeFiltering();
		ListOfClouds recommondedCl_CF = cf.getCloudRecommendation(profile);
		
		ListOfClouds totalList = new ListOfClouds(); 
		totalList.getCloudList().addAll(recommondedCl_CF.getCloudList());
		totalList.getCloudList().addAll(recommondedCl_CB.getCloudList());
		
		return totalList;
	
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
	
	private static String getRecommWfStr(String results, List<Workflow> workflowList){
		
		int count =1;
		for (Iterator<Workflow> it = workflowList.iterator(); it.hasNext(); ) {
				Workflow f = it.next();
		        results += "<a href=http://flows.nodered.org"+f.getHref().toString()+">"+count+"."+f.href.toString()+"</a>"+"<br>";
		        count++;
		}
		return results;
		
	}
	
	private static String getQuery(GatewayProfile profi, int type){
		
		String query  = "iot~ OR i~";
		String query1 = "";
		String query2 = "";
		String query3 = "";
		
		if(profi.apps.getAppList()!=null)
		for(int i=0;i<profi.apps.getAppList().size();i++){
			query1 = "\""+profi.apps.getAppList().get(i).getTitle()+"\""+"~";
			query1 = query1.replace(" ", " OR ");
			if(type==1){ // device recommendation
				query1 = query1.replace(" OR ", "^4 OR ");
				query1 = query1+"^4";
			}
			query = query+" OR "+query1;
			
		}
		
		if(profi.wfs.getWfList()!=null)
		for(int i=0;i<profi.wfs.getWfList().size();i++){
			query2 = "\""+profi.wfs.getWfList().get(i).getDatatag().replaceAll(","," ")+ "\"";
			query2 = query2.replace(" ", " OR ");
			if(type==1 || type==2){ // device or wf recommendation
				query2 = query2.replace(" OR ", "^4 OR ");
				query2 = query2+"^4";
			}
			query = query+" OR "+ query2;
			
		}
		
		if(profi.devices.getDeviceList()!=null)
		for(int i=0;i<profi.devices.getDeviceList().size();i++){
			query3 = "\""+profi.devices.getDeviceList().get(i).getTitle()+"\""+"~";
			query3 = query3.replace(" ", " OR ");
			if(type==0 || type==2){ // app or wf recommendation
				query3 = query3.replace(" OR ", "^4 OR ");
				query3 = query3+"^4";
			}
			
			query = query+" OR "+query3;
			
		}
		
		
		query = query.replace("\"", "");
		return query;
	}
	
	
    
    private static ListOfWFs updateFlowsNodes(ListOfWFs wflist){
		
    	for (int i=0;i<wflist.getWfList().size();i++){
    		
    		// UPDATE LINK
    		wflist.getWfList().get(i).setHref("https://flows.nodered.org"+wflist.getWfList().get(i).getHref());
    		
			char [] out = new char[12000];
			URL url;
			try {
				
				url = new URL(wflist.getWfList().get(i).getHref().toString());
				HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
				con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		        con.connect();
				InputStream input = con.getInputStream();
				byte[] bytes = IOUtils.toByteArray(input);
		
				String str = new String(bytes);
				String substr = str;
				// ADD DESCRIPTION
				// flow-description"> or "flow-title">
				int start = str.lastIndexOf("flow-description\">");
				if (start!=-1){
					substr = str.substring(start);
					start = substr.indexOf(">");
					start += 1;
					substr = substr.substring(start);
				}
				
				else{
					start = str.lastIndexOf("flow-title\">");
					start += 12;
					substr = str.substring(start);
					start = substr.indexOf("<p>");
					start += 3;
					substr = substr.substring(start);
				}
				
				int end = substr.indexOf("</p>");
				String desc = substr.substring(0, end);
				wflist.getWfList().get(i).setDescription(desc);
				
				
				
				// ADD JS CODE
				if(wflist.getWfList().get(i).getType().equals("flow")){
					
					start = str.indexOf("javascript\">");
					start += 12;
					substr = str.substring(start);
					end = substr.indexOf("</pre>");
					
					StringEscapeUtils util = new StringEscapeUtils();
					
					String code = substr.substring(0, end);
					code = util.unescapeHtml4(code);
//					code = code.replace("&quot;", "\"");
//					code = code.replace("&lt;", "<");
//					code = code.replace("&gt;", ">");
//					code = code.replace("&#x3D;", "=");
//					code = code.replace("&#39;", "'");
//					code = code.replace("&#x2F;", "/");
					wflist.getWfList().get(i).setJavascriptCode(code);
				}
				
				// ADD INSTALL COMMAND
				if(wflist.getWfList().get(i).getType().equals("node")){
					start = str.indexOf("<code>npm install ");
					start += 6;
					substr = str.substring(start);
					end = substr.indexOf("</code>");
					
					String command = substr.substring(0, end);
					wflist.getWfList().get(i).setInstallCommand(command);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
		return wflist;
	}

}

