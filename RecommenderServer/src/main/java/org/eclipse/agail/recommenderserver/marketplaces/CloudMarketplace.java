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
import org.eclipse.agail.recommenderserver.models.Cloud;

public class CloudMarketplace {
	
	public static List<Cloud> cloudList = new ArrayList<Cloud>();
	public static IndexWriter indexWriter_cloudMarketplace;
	public static StandardAnalyzer analyzer_cloud;
	public static Directory directoryIndex_cloud;
	public static Document doc_cloud;
	public static int size = 0;
	
	public static void initiate(){
		doc_cloud = new Document();
		analyzer_cloud = new StandardAnalyzer();
		// 1. create the index
		directoryIndex_cloud = new RAMDirectory();
//		try {
//			directoryIndex_cloud = FSDirectory.open(Paths.get("C:\\temp\\index_cloud.lucene"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
		size++;
		
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
