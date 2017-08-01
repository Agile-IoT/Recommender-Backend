/*******************************************************************************
 * Copyright (C) 2017 TUGraz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TUGraz - initial API and implementation
 ******************************************************************************/

package org.eclipse.agail.recommenderserver.marketplaces.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;


public class TestURLS {

    public static void main(String[] args) throws IOException {
//        URL url = new URL("http://flows.nodered.org/");
//        //URLConnection hc = url.openConnection();
//        //hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
//        System.setProperty("http.agent", ""); 
//        
//        InputStream in = url.openStream();
//	    InputStreamReader r = new InputStreamReader(in);
//        //System.out.println(hc.getContentType());
//	    System.out.println(r.read());
//	    
//	    
//	    
	    try {       
           
            
           	URL url=new URL("https://flows.nodered.org/");
	           
   	        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
   	        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            con.connect();
	         
		    InputStreamReader r = new InputStreamReader(con.getInputStream());
		    System.out.println(r.read());
		    // parser.parse(r, callback, false);
            
            //InputStream in = url.openStream();
            //InputStreamReader r = new InputStreamReader(in);
            //System.out.println(r.read());
            
            
            //dumpl all cert info
   	     	//print_https_cert(con);

   	        //dump all the content
   	     	// print_content(con);
   	     
            // System.out.println(con.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void print_https_cert(HttpsURLConnection con){

        if(con!=null){

          try {

    	System.out.println("Response Code : " + con.getResponseCode());
    	System.out.println("Cipher Suite : " + con.getCipherSuite());
    	System.out.println("\n");

    	Certificate[] certs = con.getServerCertificates();
    	for(Certificate cert : certs){
    	   System.out.println("Cert Type : " + cert.getType());
    	   System.out.println("Cert Hash Code : " + cert.hashCode());
    	   System.out.println("Cert Public Key Algorithm : "
                                        + cert.getPublicKey().getAlgorithm());
    	   System.out.println("Cert Public Key Format : "
                                        + cert.getPublicKey().getFormat());
    	   System.out.println("\n");
    	}

    	} catch (SSLPeerUnverifiedException e) {
    		e.printStackTrace();
    	} catch (IOException e){
    		e.printStackTrace();
    	}

         }

       }

       private static void print_content(HttpsURLConnection con){
    	if(con!=null){

    	try {

    	   System.out.println("****** Content of the URL ********");
    	   BufferedReader br =
    		new BufferedReader(
    			new InputStreamReader(con.getInputStream()));

    	   String input;

    	   while ((input = br.readLine()) != null){
    	      System.out.println(input);
    	   }
    	   br.close();

    	} catch (IOException e) {
    	   e.printStackTrace();
    	}

           }

       }

}