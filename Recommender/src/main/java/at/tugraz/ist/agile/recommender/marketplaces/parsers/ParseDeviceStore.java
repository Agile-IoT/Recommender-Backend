package at.tugraz.ist.agile.recommender.marketplaces.parsers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import at.tugraz.ist.agile.recommender.marketplaces.DeviceMarketplace;
import at.tugraz.ist.agile.recommender.models.Device;

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
	  
	  public static void getDevList(String query) {
		  	DeviceMarketplace.devList.clear();
		    ParserGetter kit = new ParserGetter();
		    HTMLEditorKit.Parser parser = kit.getParser();
		    HTMLEditorKit.ParserCallback callback = new ReportAttributes_dev();
		    
		    query=query.replaceAll(" ", "+");
		    int pageNumber = 1;
		    while(!flag_ResultNotFound){
			    try {
			    	String url = "https://hub.docker.com/search/?isAutomated=0&isOfficial=0&page="+pageNumber+"&pullCount=0&q=REPLACE&starCount=0";
			    	url = url.replaceAll("REPLACE", query);
				    URL u = new URL(url);
				    InputStream in = u.openStream();
				    InputStreamReader r = new InputStreamReader(in);
				    parser.parse(r, callback, false);
			    } catch (IOException e) {
			      System.err.println(e);
			    }
			    pageNumber++;
			    flag_ResultNotFound = true;
		    }
		   
	  }

	}
	class ReportAttributes_dev extends HTMLEditorKit.ParserCallback {

	  Device devToBeAdded = null;
		
	  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	     this.listAttributes(attributes);
	  }

	  private void listAttributes(AttributeSet attributes) {
		
	    Enumeration e = attributes.getAttributeNames();
	    int size = 0;
	    
	    while (e.hasMoreElements()) {
	      size = DeviceMarketplace.devList.size();
	      Object name = e.nextElement();
	      Object value = attributes.getAttribute(name);
	     
	     
	      if(value.toString().contains("ResultsNotFound")){
	    	  ParseDeviceStore.flag_ResultNotFound = true;
	      }
		  if(value.toString().contains("RepositoryListItem__flexible") ){
			  devToBeAdded = new Device(null,null);
		  }
			 
		  
		  if(devToBeAdded!=null){ 
			  if(name.toString().contains("href")){
				  devToBeAdded.setHref("https://hub.docker.com"+value.toString());
				  devToBeAdded.setTitle(value.toString().replaceAll("/r/", ""));
				  DeviceMarketplace.addNewDev(devToBeAdded);
				  System.out.println("App #"+(size+1)+ " = Title:" + devToBeAdded.getTitle()+ ", Href:" + devToBeAdded.getHref());
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

