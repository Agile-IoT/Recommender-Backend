/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.marketplaces;

import java.io.IOException;
import java.nio.file.Paths;
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
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.eclipse.agail.recommenderserver.models.App;

public class AppMarketplace {
	
	public static List<App> appList = new ArrayList<App>();
	public static IndexWriter indexWriter_appMarketplace;
	public static StandardAnalyzer analyzer_app;
	public static Directory directoryIndex_app;
	public static Document doc_app;
	public static int size = 0;
	
	public static void initiate(){
		doc_app = new Document();
		analyzer_app = new StandardAnalyzer();
		// 1. create the index
		directoryIndex_app = new RAMDirectory();
		// FSDirectory directoryIndex_app = FSDirectory.open(Paths.get("C:\\temp\\index_app.lucene"));

//		try {
//			directoryIndex_app = FSDirectory.open(Paths.get("C:\\temp\\index_app.lucene"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		IndexWriterConfig config = new IndexWriterConfig(analyzer_app);
	    try {
	    	indexWriter_appMarketplace = new IndexWriter(directoryIndex_app, config);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void addNewApp(App app){
		doc_app = new Document();
		size++;
		appList.add(app);
		
		doc_app.add(new TextField("title", app.getTitle(), Field.Store.YES));
		doc_app.add(new TextField("stars", Integer.toString(app.getStars()), Field.Store.YES));
		doc_app.add(new TextField("downloads", Integer.toString(app.getStars()), Field.Store.YES));
		doc_app.add(new StringField("href", app.getHref(), Field.Store.YES));
				
		try {
			indexWriter_appMarketplace.addDocument(doc_app);
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void stopAddingToMarketplace(){
		try {
			indexWriter_appMarketplace.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
