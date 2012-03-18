package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.*;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import android.provider.ContactsContract.CommonDataKinds.Website;
import android.sax.Element;

public class ParseToursXML {
	
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

	
	/*
	 * Makes a connection with the tours request and parses the XML returned from the database
	 * This request returns information about the Tours in general not about each specific tour.
	 */
	public static void toursRequest(){

		InputStream in = makeConnection("http://gvsuartgallery.org/service.php/search/Search/rest?method=queryRest&type=ca_tours&query=*&additional_bundles[ca_tours.icon.largeicon][returnURL]=1&additional_bundles[ca_tours.access]");
		
        try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			XMLReader saxReader = saxParser.getXMLReader();
			
			//saxReader.setContentHandler(handler);
			saxReader.parse(new InputSource(in));
			//String 
			
;			//NodeList tourNodes = doc.getElementsByTagName("ca_tours");
			//int tourNodeCount = tourNodes.getLength();
			
			//for(int i = 0; i < tourNodeCount; i++){
			//	Element tour = (Element) tourNodes.item(i);
			//	String tourName = getTextValue("displayLabel", tour);
			//}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Builds the URL to send and parses the XML for the specific tour data.
	 */
	public static void toursIndividualDataRequest(int requestedTour){
		//Add tour number to the URL
		StringBuilder url = new StringBuilder();
		url.append(requestedTour);
		InputStream in = makeConnection(url.toString());
	
	}
	
	/*
	 * Builds the URL to send and parses the XML for the specific tour images.
	 */
	public static void toursIndividualImagesRequest(int requestedTour){
		//Add tour number to the URL
		StringBuilder url = new StringBuilder();
		url.append(requestedTour);
		InputStream in = makeConnection(url.toString());
	
	}
}
