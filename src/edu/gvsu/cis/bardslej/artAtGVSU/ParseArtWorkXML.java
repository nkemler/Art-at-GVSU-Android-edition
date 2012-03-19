package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class ParseArtWorkXML {
	/*
	 * Make Connection with URL parameter (URL string can be concatenated with conditions when
	 * passed into the method) returns the inputStream from the response.   
	 */
	private static InputStream makeConnection(String url){
		URL urlSend = null;
		InputStream in = null;
		try{
			urlSend = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlSend.openConnection();
			connection.getInputStream();
			in = connection.getInputStream();
		}catch(MalformedURLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	
	public static LinkedList<ArtWork> artWorkTourRequest(){
		InputStream in = makeConnection("http://gvsuartgallery.org/service.php/search/Search/rest?method=queryRest&type=ca_tours&query=*&additional_bundles[ca_tours.icon.largeicon][returnURL]=1&additional_bundles[ca_tours.access]");
		LinkedList<ArtWork> artPieces = new LinkedList<ArtWork>();
		
		return artPieces; 
	}
}
