package at.tugraz.ist.agile.recommenderservice;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import at.tugraz.ist.agile.recommenderservice.marketplaces.CloudMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.WorkflowMarketplace;
import at.tugraz.ist.agile.recommenderservice.models.Cloud;
import at.tugraz.ist.agile.recommenderservice.models.Workflow;


public class RecommendCloud {
	
	public List<Cloud> recommendedClouds;
	
	RecommendCloud(){
		this.recommendedClouds = new ArrayList<Cloud>();
	}
	
	public void getRecommendation(String querystr) throws IOException, ParseException {
		
		System.out.println("LUCENE will calculate recommendation for clouds");
		
		// the "title" arg specifies the default field to use
		// when no field is explicitly specified in the query.
		Query q = null;
		try {
			q = new QueryParser("services",CloudMarketplace.analyzer_cloud).parse(querystr);
		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
			e.printStackTrace();
		}

		// 3. search
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(CloudMarketplace.directoryIndex_cloud);
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
		searcher.search(q, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d = searcher.doc(docId);
			System.out.println((i + 1) + ". TITLE:" + d.get("title"));
			// recommendedClouds.add(new Cloud(d.get("title"), d.get("link"), d.get("accesstype"), d.get("locations"), d.get("middlewares"), d.get("frameworks"), d.get("runtimes"), d.get("services")));
			
			boolean alreadyPlaced = false;
			Iterator<Cloud> iterator = recommendedClouds.iterator();
		    while(iterator.hasNext()) {
		        Cloud setElement = iterator.next();
		        if(setElement.getTitle().equals(d.get("title"))) {
		        	alreadyPlaced = true;
		        	break;
		        }
		    }
		    
			if(!alreadyPlaced)
				recommendedClouds.add(new Cloud(d.get("title"), d.get("link"), d.get("accesstype"), d.get("locations"), d.get("middlewares"), d.get("frameworks"), d.get("runtimes"), d.get("services"),d.get("pricing")));
			
		}

		// reader can only be closed when there
		// is no need to access the documents any more.
		reader.close();
	}
	
}

