package at.tugraz.ist.agile.recommender;

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
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import at.tugraz.ist.agile.recommender.marketplaces.CloudMarketplace;
import at.tugraz.ist.agile.recommender.marketplaces.WorkflowMarketplace;
import at.tugraz.ist.agile.recommender.models.Cloud;
import at.tugraz.ist.agile.recommender.models.GatewayProfile;
import at.tugraz.ist.agile.recommender.models.ListOfClouds;
import at.tugraz.ist.agile.recommender.models.Workflow;


public class RecommendCloud {
	
	public ListOfClouds recommendedClouds;
	public String queryCloud;
	//public Query finalQuery;
	public Query finalQuery;
	
	RecommendCloud(){
		this.recommendedClouds = new ListOfClouds();
	}
	
	public void getRecommendation(GatewayProfile profile) throws IOException, ParseException {
		
		System.out.println("LUCENE will calculate recommendation for clouds");
		generateQuery(profile);
		
		

		// 3. search
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(CloudMarketplace.directoryIndex_cloud);
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
		searcher.search(finalQuery, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d = searcher.doc(docId);
			System.out.println((i + 1) + ". Title:" + d.get("title"));
			
			boolean alreadyPlaced = false;
			Iterator<Cloud> iterator = recommendedClouds.getCloudList().iterator();
		    while(iterator.hasNext()) {
		        Cloud setElement = iterator.next();
		        if(setElement.getTitle().equals(d.get("title"))) {
		        	alreadyPlaced = true;
		        	break;
		        }
		    }
		    
			if(!alreadyPlaced)
				recommendedClouds.getCloudList().add(new Cloud(d.get("title"), d.get("link"), d.get("accesstype"), d.get("locations"), d.get("middlewares"), d.get("frameworks"), d.get("runtimes"), d.get("services"),d.get("pricing")));
			
		}

		// reader can only be closed when there
		// is no need to access the documents any more.
		reader.close();
	}
	
	public void generateQuery(GatewayProfile profile){
	
		String[] fields= {"locations","pricing"};
		String[] queries = {profile.getLocation(),profile.getPricingPreferences().replaceAll(",", " OR ")};
	
		BooleanClause.Occur[] flags = {BooleanClause.Occur.MUST,
		                BooleanClause.Occur.SHOULD};
		 
		 
		MultiFieldQueryParser queryParserCloud = new MultiFieldQueryParser(queries, CloudMarketplace.analyzer_cloud);
		
	    try {
			finalQuery= queryParserCloud.parse(queries, fields, flags, CloudMarketplace.analyzer_cloud);
		} catch (org.apache.lucene.queryparser.classic.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

