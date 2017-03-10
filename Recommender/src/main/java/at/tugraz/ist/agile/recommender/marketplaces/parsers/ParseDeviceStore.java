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
			    	//String url = "https://www.amazon.de/s/ref=nb_sb_noss_2?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&url=node%3D2076361031&field-keywords=raspberry";
			    	//String url = "https://www.amazon.de/s/ref=sr_pg_2?rh=n%3A80084031%2Cn%3A2076361031%2Ck%3Araspberry&page="+pageNumber+"&keywords=raspberry&ie=UTF8N";
			    	String url = "https://www.amazon.com/s/ref=sr_pg_3?fst=as%3Aoff&rh=n%3A172282%2Cn%3A541966%2Cn%3A193870011%2Ck%3Araspberry&page="+pageNumber+"&keywords=raspberry&ie=UTF8&qid=1489160336&spIA=B01CNOWH3S,B01C6Q2GSY,B01C6Q4GLE,B01CYX4HRM";
			    	//url = url.replaceAll("REPLACE", query);
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
		  if(value.toString().contains("a-link-normal s-access-detail-page  a-text-normal") ){
			  devToBeAdded = new Device(null,null);
		  }
			 
		  
		  if(devToBeAdded!=null){ 
			  if(name.toString().contains("href")){
				  devToBeAdded.setHref(value.toString());
				  devToBeAdded.setTitle(value.toString().split("/")[3]);
				  DeviceMarketplace.addNewDev(devToBeAdded);
				  System.out.println("Dev #"+(size+1)+ " = Title:" + devToBeAdded.getTitle()+ ", Href:" + devToBeAdded.getHref());
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

