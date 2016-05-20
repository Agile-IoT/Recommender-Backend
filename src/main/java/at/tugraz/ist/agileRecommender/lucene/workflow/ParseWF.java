package at.tugraz.ist.agileRecommender.lucene.workflow;

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

import at.tugraz.ist.agileRecommender.lucene.app.App;

public class ParseWF {

	  public static void main(String[] args) {
	    ParserGetter kit = new ParserGetter();
	    HTMLEditorKit.Parser parser = kit.getParser();
	    HTMLEditorKit.ParserCallback callback = new ReportAttributes();

	    try {
	      URL u = new URL("http://flows.nodered.org/");
	      InputStream in = u.openStream();
	      InputStreamReader r = new InputStreamReader(in);
	      parser.parse(r, callback, false);
	    } catch (IOException e) {
	      System.err.println(e);
	    }
	  }
	  
	  public static void getWorkFlows() {
		    ParserGetter kit = new ParserGetter();
		    HTMLEditorKit.Parser parser = kit.getParser();
		    HTMLEditorKit.ParserCallback callback = new ReportAttributes();

		    try {
		      URL u = new URL("http://flows.nodered.org/");
		      InputStream in = u.openStream();
		      InputStreamReader r = new InputStreamReader(in);
		      parser.parse(r, callback, false);
		    } catch (IOException e) {
		      System.err.println(e);
		    }
	  }
	  
	  
	}



	class ReportAttributes extends HTMLEditorKit.ParserCallback {

	  WorkFlow wfToBeAdded = null;
	  public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position) {
	     this.listAttributes(attributes);
	  }

	  private void listAttributes(AttributeSet attributes) {
		
	    Enumeration e = attributes.getAttributeNames();
	    int size = 0;
	    while (e.hasMoreElements()) {
	      size = WorkFlowList.workflowList.size();
	      
	      Object name = e.nextElement();
	      Object value = attributes.getAttribute(name);
	      if (!attributes.containsAttribute(name.toString(), value)) {
	        //System.out.println("containsAttribute() fails");
	      }
	      if (!attributes.isDefined(name.toString())) {
	        //System.out.println("isDefined() fails");
	      }
	      
	      
		  if(name.toString().contains("class") && value.toString().contains("gistbox-node") )
			  wfToBeAdded = new WorkFlow("node", null, null, null);
		  else if(name.toString().contains("class") && value.toString().contains("gistbox-flow") )
			  wfToBeAdded = new WorkFlow("flow", null, null, null);
		  
		 
		  if(wfToBeAdded!=null){   
			  //WorkFlow last = WorkFlowList.workflowList.get(size-1);
			  
		      if(name.toString().contains("data-tags") && wfToBeAdded.getType()!=null && wfToBeAdded.getDatatag()==null)
		    	  wfToBeAdded.setDatatag(value.toString());
		      
		      if(name.toString().contains("data-owner") && wfToBeAdded.getType()!=null && wfToBeAdded.getDataowner()==null)
		    	  wfToBeAdded.setDataowner(value.toString());
		      
		      if(name.toString().contains("href") && ((value.toString().contains("/node/") || value.toString().contains("/flow/")) && wfToBeAdded.getType()!=null && wfToBeAdded.getHref()==null)){
		    	  wfToBeAdded.setHref(value.toString());
		    	  WorkFlowList.addNewWorkFlow(wfToBeAdded);
			      System.out.println("WorkFlow #"+size+ " = Type:" + wfToBeAdded.type+ ", Href:" + wfToBeAdded.href);
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

