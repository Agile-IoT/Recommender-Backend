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

public class ParseHtml {

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
			  WorkFlowList.addNewWorkFlow("node");
		  else if(name.toString().contains("class") && value.toString().contains("gistbox-flow") )
			  WorkFlowList.addNewWorkFlow("flow");
		  
		 
		  if(size>0){   
			  WorkFlow last = WorkFlowList.workflowList.get(size-1);
			  
		      if(name.toString().contains("data-tags") && last.getType()!=null && last.getDatatag()==null)
		    	  WorkFlowList.workflowList.get(WorkFlowList.workflowList.size()-1).setDatatag(value.toString());
		      
		      if(name.toString().contains("data-owner") && last.getType()!=null && last.getDataowner()==null)
		    	  WorkFlowList.workflowList.get(WorkFlowList.workflowList.size()-1).setDataowner(value.toString());
		      
		      if(name.toString().contains("href") && ((value.toString().contains("/node/") || value.toString().contains("/flow/")) && last.getType()!=null && last.getHref()==null)){
		    	  WorkFlowList.workflowList.get(WorkFlowList.workflowList.size()-1).setHref(value.toString());
			      System.out.println("WorkFlow #"+size+ " = Type:" + last.type+ ", Href:" + last.href);
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

