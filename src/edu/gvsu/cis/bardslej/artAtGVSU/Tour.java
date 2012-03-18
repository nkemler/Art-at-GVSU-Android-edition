package edu.gvsu.cis.bardslej.artAtGVSU;

import java.util.LinkedList;
import android.graphics.Point;

/*
 * Tour class creates a tour object that holds data and image URLs to pieces of art
 */
public class Tour {
	
	String tourID;
	String tourName;
	String imageMainURL;
	String tourAccess;
	LinkedList<String> imageURLs = new LinkedList<String>();
	LinkedList<Point> geoLoc = new LinkedList<Point>();

	public Tour(){
		tourID = null;
		tourName = null;
		imageMainURL = null;
		tourAccess = null;
		imageURLs = null;
		geoLoc = null;
	}
	
	public Tour(String tID, String tName, String tImageMainURL, String tAccess){
		tourID = tID;
		tourName = tName;
		imageMainURL = tImageMainURL;
		tourAccess = tAccess;
	}
	
	public Tour(String tID, String tName, String tImageMainURL, String tAccess, LinkedList<String> tImageURLs, LinkedList<Point> tLocations){
		tourID = tID;
		tourName = tName;
		imageMainURL = tImageMainURL;
		tourAccess = tAccess;
		imageURLs = tImageURLs;
		geoLoc = tLocations;
	}

	public String getTourID() {
		return tourID;
	}

	public void setTourID(String tourID) {
		this.tourID = tourID;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getImageMainURL() {
		return imageMainURL;
	}

	public void setImageMainURL(String imageMainURL) {
		this.imageMainURL = imageMainURL;
	}
	
	public String getTourAccess() {
		return tourAccess;
	}

	public void setTourAccess(String tourAccess) {
		this.tourAccess = tourAccess;
	}

	public LinkedList<String> getImageURLs() {
		return imageURLs;
	}

	public void setImageURLs(LinkedList<String> imageURLs) {
		this.imageURLs = imageURLs;
	}

	public LinkedList<Point> getGeoLoc() {
		return geoLoc;
	}

	public void setGeoLoc(LinkedList<Point> geoLoc) {
		this.geoLoc = geoLoc;
	}

	
}
