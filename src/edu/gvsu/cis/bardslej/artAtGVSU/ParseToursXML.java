package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


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
	public static LinkedList<Tour> toursRequest(){

		InputStream in = makeConnection("http://gvsuartgallery.org/service.php/search/Search/rest?method=queryRest&type=ca_tours&query=*&additional_bundles[ca_tours.icon.largeicon][returnURL]=1&additional_bundles[ca_tours.access]");
		LinkedList<Tour> tours = new LinkedList<Tour>(); 
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(in);
			
			Element docElement = doc.getDocumentElement();
			NodeList toursList = docElement.getElementsByTagName("ca_tours");
			int toursCount = toursList.getLength();
			
			for(int i = 0; i < toursCount; i++){
				Element tour = (Element) toursList.item(i);
				NodeList tourDetails = tour.getChildNodes();
				String tourId = tour.getAttribute("tour_id");
				String tourName = tourDetails.item(0).getTextContent();
				String tourImageURL = tourDetails.item(1).getTextContent();
				String tourAccess = tourDetails.item(2).getTextContent();
				Tour t = new Tour(tourId, tourName, tourImageURL, tourAccess);
				tours.add(t);
			}
		} catch (SAXException e) {
			// TODO Auto-generated cathch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tours;
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
