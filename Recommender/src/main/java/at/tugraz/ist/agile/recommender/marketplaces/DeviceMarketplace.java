package at.tugraz.ist.agile.recommender.marketplaces;

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

import at.tugraz.ist.agile.recommender.models.Device;

public class DeviceMarketplace {
	
	public static List<Device> devList = new ArrayList<Device>();
	public static IndexWriter indexWriter_devMarketplace;
	public static StandardAnalyzer analyzer_dev;
	public static Directory directoryIndex_dev;
	public static Document doc_dev;
	
	public static void initiate(){
		
		doc_dev = new Document();
		analyzer_dev = new StandardAnalyzer();
		// 1. create the index
		directoryIndex_dev = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(analyzer_dev);
	    try {
	    	indexWriter_devMarketplace = new IndexWriter(directoryIndex_dev, config);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void addNewDev(Device dev){
		doc_dev = new Document();
		devList.add(dev);
		
		doc_dev.add(new TextField("title", dev.getTitle(), Field.Store.YES));
		doc_dev.add(new StringField("href", dev.getHref(), Field.Store.YES));
				
		try {
			indexWriter_devMarketplace.addDocument(doc_dev);
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void stopAddingToMarketplace(){
		try {
			indexWriter_devMarketplace.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
