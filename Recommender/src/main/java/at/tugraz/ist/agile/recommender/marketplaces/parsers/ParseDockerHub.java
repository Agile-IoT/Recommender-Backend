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

import at.tugraz.ist.agile.recommender.marketplaces.AppMarketplace;
import at.tugraz.ist.agile.recommender.models.App;

public class ParseDockerHub {

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
	  
	  public static void getAppList(String query) {
		  	AppMarketplace.appList.clear();
		    ParserGetter kit = new ParserGetter();
		    HTMLEditorKit.Parser parser = kit.getParser();
		    HTMLEditorKit.ParserCallback callback = new ReportAttributes_app2();
		    
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
		    }
	  }

	}
	class ReportAttributes_app2 extends HTMLEditorKit.ParserCallback {

	  App appToBeAdded = null;
		
	  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	     this.listAttributes(attributes);
	  }

	  private void listAttributes(AttributeSet attributes) {
		
	    Enumeration e = attributes.getAttributeNames();
	    int size = 0;
	    
	    while (e.hasMoreElements()) {
	      size = AppMarketplace.appList.size();
	      Object name = e.nextElement();
	      Object value = attributes.getAttribute(name);
	     
	     
	      if(value.toString().contains("ResultsNotFound")){
	    	  ParseDockerHub.flag_ResultNotFound = true;
	      }
		  if(value.toString().contains("RepositoryListItem__flexible") ){
			  appToBeAdded = new App(null,null,-1,-1);
		  }
			 
		  
		  if(appToBeAdded!=null){ 
			  if(name.toString().contains("href")){
				  appToBeAdded.setHref("https://hub.docker.com"+value.toString());
				  appToBeAdded.setTitle(value.toString().replaceAll("/r/", ""));
				  
			  }
			  if(value.toString().contains("RepositoryListItem__value")){
				  if(appToBeAdded.getStars()==-1)
					  appToBeAdded.setStars(0);
				  else if(appToBeAdded.getDownloads()==-1){
					  appToBeAdded.setDownloads(0);
					  AppMarketplace.addNewApp(appToBeAdded);
				  	  System.out.println("App #"+(size+1)+ " = Title:" + appToBeAdded.getTitle()+ ", Href:" + appToBeAdded.getHref()+ ", Stars:" + appToBeAdded.getStars()+ ", Downloads:" + appToBeAdded.getDownloads());
				  	  appToBeAdded = null;
				  }
				  
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

