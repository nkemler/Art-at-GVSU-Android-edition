package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.*;
import java.net.*;
import org.w3c.dom.Document;

public class ParseXML {
	
	public static void main(String[] args) throws Exception {
		URL yahoo = new URL("http://www.yahoo.com/");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(yc.getInputStream()));
	        String inputLine;

    while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
        }
	
/*
	URL xmlUrl;
	InputStream in;
	Document doc;
	
	public ParseXML() throws Exception{
		
		xmlUrl = new URL("http://gvsuartgallery.org/service.php/search/Search/rest?method=queryRest&type=ca_tours&query=*&additional_bundles[ca_tours.icon.largeicon][returnURL]=1&additional_bundles[ca_tours.access]");
		URLConnection connect = xmlUrl.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
		
		String inputLine;
		
		while ((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
		}
		in.close();
	}
	*/
}
