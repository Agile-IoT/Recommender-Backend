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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
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
import org.eclipse.agail.recommenderserver.marketplaces.WorkflowMarketplace;
import org.eclipse.agail.recommenderserver.models.Workflow;


public class ParseNodeRed {

//	  public static void main(String[] args) {
//		  getWorkFlows();
//	  }
	  
	 
	 
	  public static void getWorkFlows() {
		    //String url_repo = System.getProperty("user.dir")+"\\Workflows";
		    //FileOperations.cleanFile(url_repo);
		    ParserGetter kit = new ParserGetter();
		    HTMLEditorKit.Parser parser = kit.getParser();
		    HTMLEditorKit.ParserCallback callback = new ReportAttributes();
		    
		   int falseAttemptCounter=0;
		   
		   while(falseAttemptCounter<10){
			    try {
			    	URL url=new URL("https://flows.nodered.org/");
			           
		   	        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		   	        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		            con.connect();
			         
				    InputStreamReader r = new InputStreamReader(con.getInputStream());
				    parser.parse(r, callback, false);
				    break; 
			    } catch (IOException e) {
				      System.err.println(e);
				      falseAttemptCounter++;
			    }
		   }
		   try{
		   Thread.sleep(10000);}
		   catch(Exception ex){}
		   
		   if(WorkflowMarketplace.workflowList.size()==0){
			   try {
				    InputStreamReader r = new InputStreamReader(ParseNodeRed.class.getClassLoader().getResourceAsStream("NodeRED.html"),StandardCharsets.UTF_8); 
				    parser.parse(r, callback, true);
			    } catch (IOException e) {
				      System.err.println(e);
			    }
		    }
		   
	  }
	 	  
	}

	class ReportAttributes extends HTMLEditorKit.ParserCallback {

		
	  Workflow wfToBeAdded = null;
	  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	     this.listAttributes(attributes);
	  }

	  private void listAttributes(AttributeSet attributes) {
		//String url_repo = System.getProperty("user.dir")+"\\Workflows";
	    Enumeration e = attributes.getAttributeNames();
	    int size = 0;
	    while (e.hasMoreElements()) {
	      size = WorkflowMarketplace.workflowList.size();
	      
	      Object name = e.nextElement();
	      Object value = attributes.getAttribute(name);
	      if (!attributes.containsAttribute(name.toString(), value)) {
	        //System.out.println("containsAttribute() fails");
	      }
	      if (!attributes.isDefined(name.toString())) {
	        //System.out.println("isDefined() fails");
	      }
	      
	      
		  if(name.toString().contains("class") && value.toString().contains("gistbox-node") )
			  wfToBeAdded = new Workflow("node", null, null, null);
		  else if(name.toString().contains("class") && value.toString().contains("gistbox-flow") )
			  wfToBeAdded = new Workflow("flow", null, null, null);
		 
		 
		  if(wfToBeAdded!=null){   
			  //WorkFlow last = WorkFlowList.workflowList.get(size-1);
			  
		      if(name.toString().contains("data-tags") && wfToBeAdded.getType()!=null && wfToBeAdded.getDatatag()==null)
		    	  wfToBeAdded.setDatatag(value.toString());
		      
		      if(name.toString().contains("data-owner") && wfToBeAdded.getType()!=null && wfToBeAdded.getDataowner()==null)
		    	  wfToBeAdded.setDataowner(value.toString());
		      
		      if(name.toString().contains("href") && ((value.toString().contains("/node/") || value.toString().contains("/flow/")) && wfToBeAdded.getType()!=null && wfToBeAdded.getHref()==null)){
		    	  String [] parsedLink = value.toString().split("https");
		    	  wfToBeAdded.setHref("https"+parsedLink[parsedLink.length-1]);
		    	  WorkflowMarketplace.addNewWorkFlow(wfToBeAdded);
			      String newLine= "WorkFlow #"+(size+1)+ " = Type:" + wfToBeAdded.type+ ", Href:" + wfToBeAdded.href;
				  System.out.println(newLine);
				  //FileOperations.appendNewLineToFile(url_repo, newLine);
			      
			      wfToBeAdded = null;
		      }
	      } 
		      
	    }
	    
	  }

	  public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	    this.listAttributes(attributes);
	  }
	}

	class ParserGetter extends HTMLEditorKit {
	  public HTMLEditorKit.Parser getParser() {
	    return super.getParser();
	  }
	}

