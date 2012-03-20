package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
			//connection.getInputStream();
			in = connection.getInputStream();
		}catch(MalformedURLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	
	public static ArtWork artWorkRequestID(String aID){
		String url = "http://gvsuartgallery.org/service.php/iteminfo/ItemInfo/rest?method=get&type=ca_objects&item_ids[0]=%d&bundles[1]=ca_objects.object_id&bundles[2]=ca_object_labels.name&bundles[3]=ca_objects.work_description&bundles[4]=ca_objects.idno&bundles[5]=ca_objects.work_date&bundles[6]=ca_objects.historical_context&bundles[7]=ca_object_representations.media.small&bundles[8]=ca_storage_locations.preferred_labels.name&bundles[9]=ca_entities.preferred_labels.displayname&options[ca_object_representations.media.small][returnURL]=1";
		url = url.replace("%d", aID);
		InputStream in = makeConnection(url);
		ArtWork artPiece = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(in);
			
			Element docElement = doc.getDocumentElement();
			//artPiece = new ArtWork(aID, aArtistID, aArtistName, aTitle, aDescription, aIdNo, aWorkDate, aHistContext, aImageURL, aLocName, aMedium, aGeoLoc, aStopID);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artPiece;
	}
}
