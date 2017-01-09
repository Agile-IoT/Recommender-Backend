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

import at.tugraz.ist.agile.recommenderservice.models.Cloud;

public class CloudMarketplace {
	
	public static List<Cloud> cloudList = new ArrayList<Cloud>();
	public static IndexWriter indexWriter_cloudMarketplace;
	public static StandardAnalyzer analyzer_cloud;
	public static Directory directoryIndex_cloud;
	public static Document doc_cloud;
	
	public static void initiate(){
		doc_cloud = new Document();
		analyzer_cloud = new StandardAnalyzer();
		// 1. create the index
		directoryIndex_cloud = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(analyzer_cloud);
	    try {
	    	indexWriter_cloudMarketplace = new IndexWriter(directoryIndex_cloud, config);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	}
	
	public static void addNewCloud(Cloud cloud){
		doc_cloud = new Document();
		cloudList.add(cloud);
		
		doc_cloud.add(new TextField("title", cloud.getTitle(), Field.Store.YES));
		doc_cloud.add(new TextField("locations", cloud.getLocations().toString() ,Field.Store.YES));
		doc_cloud.add(new TextField("accesstype", cloud.getAccesstype(), Field.Store.YES));
		doc_cloud.add(new TextField("frameworks", cloud.getFrameworks(), Field.Store.YES));
		doc_cloud.add(new TextField("middlewares", cloud.getMiddlewares(), Field.Store.YES));
		doc_cloud.add(new TextField("runtimes", cloud.getRuntimes(), Field.Store.YES));
		doc_cloud.add(new TextField("services", cloud.getServices(), Field.Store.YES));
		doc_cloud.add(new TextField("pricing", cloud.getPricing(), Field.Store.YES));
		doc_cloud.add(new StringField("link", cloud.getLink(), Field.Store.YES));
				
		try {
			indexWriter_cloudMarketplace.addDocument(doc_cloud);
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void stopAddingToMarketplace(){
		try {
			indexWriter_cloudMarketplace.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
