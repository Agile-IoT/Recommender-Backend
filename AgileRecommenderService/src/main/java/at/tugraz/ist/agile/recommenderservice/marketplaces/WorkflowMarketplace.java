package at.tugraz.ist.agile.recommenderservice.marketplaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import at.tugraz.ist.agile.recommenderservice.models.App;
import at.tugraz.ist.agile.recommenderservice.models.Workflow;

public class WorkflowMarketplace {
	
	public static List<Workflow> workflowList = new ArrayList<Workflow>();
	public static IndexWriter indexWriter_wfMarketplace;
	public static StandardAnalyzer analyzer_wf;
	public static Directory directoryIndex_wf;
	public static Document doc_wf;
	
	public static void initiate(){
		doc_wf = new Document();
		analyzer_wf = new StandardAnalyzer();
		// 1. create the index
		directoryIndex_wf = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(analyzer_wf);
	    try {
	    	indexWriter_wfMarketplace = new IndexWriter(directoryIndex_wf, config);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		doc_wf = new Document();
	}

	public String type;
	public String datatag;
	public String dataowner;
	public String href;
	
	
	public static void addNewWorkFlow(Workflow wf){
		workflowList.add(wf);
		doc_wf.add(new StringField("type", wf.getType(), Field.Store.YES));
		doc_wf.add(new TextField("datatag", wf.getDatatag(), Field.Store.YES));
		doc_wf.add(new StringField("dataowner", wf.getDataowner(), Field.Store.YES));
		doc_wf.add(new StringField("href", wf.getHref(), Field.Store.YES));
				
		try {
			indexWriter_wfMarketplace.addDocument(doc_wf);
		} catch (IOException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void stopAddingToMarketplace(){
		try {
			indexWriter_wfMarketplace.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
