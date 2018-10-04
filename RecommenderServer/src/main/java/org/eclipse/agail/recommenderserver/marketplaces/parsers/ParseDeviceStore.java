/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.marketplaces.parsers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import org.eclipse.agail.recommenderserver.FileOperations;
import org.eclipse.agail.recommenderserver.marketplaces.DeviceMarketplace;
import org.eclipse.agail.recommenderserver.models.Device;

public class ParseDeviceStore {

//	  public static void main(String[] args) {
//	    ParserGetter kit = new ParserGetter();
//	    HTMLEditorKit.Parser parser = kit.getParser();
//	    HTMLEditorKit.ParserCallback callback = new ReportAttributes_app();
//
//	    try {
//	      URL u = new URL("https://play.google.com/store/apps?hl=en");
//	      InputStream in = u.openStream();
//	      InputStreamReader r = new InputStreamReader(in);
//	      parser.parse(r, callback, false);
//	    } catch (IOException e) {
//	      System.err.println(e);
//	    }
//	  }
	  
	  public static boolean flag_ResultNotFound = false;
	  public static int falseAttemptCounter=0;
	 	
	   
	  public static void getDevList() {
		    String url_repo = System.getProperty("user.dir")+"\\Devices";
			 
		  	flag_ResultNotFound= false;
		  	DeviceMarketplace.devList.clear();
		    ParserGetter kit = new ParserGetter();
		    HTMLEditorKit.Parser parser = kit.getParser();
		    HTMLEditorKit.ParserCallback callback = new ReportAttributes_dev();
		    int pageNumber = 1;
		    FileOperations.cleanFile(url_repo);
		    //System.setProperty("http.agent", "");
		    
		    
		    while(!flag_ResultNotFound){
			    try {
			    	String u = "https://www.amazon.com/s/ref=sr_pg_"+pageNumber+"?rh=n%3A172282%2Cn%3A541966%2Cn%3A193870011%2Ck%3Araspberry&page="+pageNumber+"&keywords=raspberry&ie=UTF8";
		    	
				    URL url=new URL(u);
			           
		   	        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		   	        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		            con.connect();
			         
				    InputStreamReader r = new InputStreamReader(con.getInputStream());
				    parser.parse(r, callback, false);
				    
				    falseAttemptCounter=0;
				    pageNumber++;
			    } catch (IOException e) {
			    	System.err.println(e);
			    	falseAttemptCounter++;
			    	
			    	try {
						Thread.sleep(10000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			    	
			    }
			    
			    if(falseAttemptCounter>10)
			    	flag_ResultNotFound = true;
		    }
		    
		    try {
				Thread.sleep(100000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		    
		    if(DeviceMarketplace.devList.size()==0){
		    	try {
		    		InputStreamReader r = new InputStreamReader(ParseNodeRed.class.getClassLoader().getResourceAsStream("Amazon.html"),StandardCharsets.UTF_8); 
					parser.parse(r, callback, true);
			    	
				    flag_ResultNotFound = false;
			    } catch (IOException e) {
			    	System.err.println(e);
			    }
		    	
		    }
		    	
		   
	  }

	}
	class ReportAttributes_dev extends HTMLEditorKit.ParserCallback {

      //public URL url_repo = ParseCloud.class.getClassLoader().getResource("Devices");
     		
	  Device devToBeAdded = null;
		 	
	  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	     this.listAttributes(attributes);
	  }

	  private void listAttributes(AttributeSet attributes) {
		String url_repo = System.getProperty("user.dir")+"\\Devices";
			
	    Enumeration e = attributes.getAttributeNames();
	    int size = 0;
	    
	    while (e.hasMoreElements()) {
	      size = DeviceMarketplace.devList.size();
	      Object name = e.nextElement();
	      Object value = attributes.getAttribute(name);
	     
	     
	      if(value.toString().contains("noResultsTitle")){
	    	  ParseDeviceStore.flag_ResultNotFound = true;
	    	  break;
	      }
	     
	      
		  if(value.toString().contains("a-link-normal s-access-detail-page") ){
			  devToBeAdded = new Device(null,null);
		  }
			 
		  
		  if(devToBeAdded!=null){ 
			  if(name.toString().contains("href")){
				  devToBeAdded.setHref(value.toString());
				  devToBeAdded.setTitle(value.toString().split("/")[3]);
				  DeviceMarketplace.addNewDev(devToBeAdded);
				  String newLine= "Dev #"+(size+1)+ " = Title:" + devToBeAdded.getTitle()+ ", Href:" + devToBeAdded.getHref();
				  System.out.println(newLine);
				  FileOperations.appendNewLineToFile(url_repo, newLine);
				  devToBeAdded = null;
				  
			  }
		  }
		
	    }
	    
	  }

	  public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	    this.listAttributes(attributes);
	  }
	}

//	class ParserGetter extends HTMLEditorKit {
//	  public HTMLEditorKit.Parser getParser() {
//	    return super.getParser();
//	  }
//	}

