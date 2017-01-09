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
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import at.tugraz.ist.agile.recommender.marketplaces.AppMarketplace;
import at.tugraz.ist.agile.recommender.models.App;
import at.tugraz.ist.agile.recommender.models.Workflow;

public class RecommendApps {

	
	public List<App> recommendedApps;
	
	RecommendApps(){
		this.recommendedApps = new ArrayList<App>();
	}
	
	
	public void getRecommendation(String querystr) throws IOException, ParseException {
		
		System.out.println("LUCENE will calculate recommendation for apps");
		
		// the "title" arg specifies the default field to use
		// when no field is explicitly specified in the query.
		Query q = null;
		try {
			q = new QueryParser("title", AppMarketplace.analyzer_app).parse(querystr);
		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
			e.printStackTrace();
		}

		// 3. search
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(AppMarketplace.directoryIndex_app);
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
		searcher.search(q, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d = searcher.doc(docId);
			System.out.println((i + 1) + ". TITLE:" + d.get("title") + " HREF:" + d.get("href"));
			
			boolean alreadyPlaced = false;
			Iterator<App> iterator = recommendedApps.iterator();
		    while(iterator.hasNext()) {
		        App setElement = iterator.next();
		        if(setElement.getTitle().equals(d.get("title"))) {
		        	alreadyPlaced = true;
		        	break;
		        }
		    }
		    
			if(!alreadyPlaced)
				recommendedApps.add(new App(d.get("title"),d.get("href"),Integer.valueOf(d.get("stars")),Integer.valueOf(d.get("downloads"))));
		}

		// reader can only be closed when there
		// is no need to access the documents any more.
		reader.close();
	}

	
	
}
