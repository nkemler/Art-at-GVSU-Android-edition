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
	LinkedList<String> imageURLs = new LinkedList<String>();
	LinkedList<Point> geoLoc = new LinkedList<Point>();

	public Tour(){
		tourID = null;
		tourName = null;
		imageMainURL = null;
		LinkedList<String> imageURLs = null;
		LinkedList<Point> geoLoc = null;
	}
	
	public Tour(String tID, String tName, String tImageMainURL){
		tourID = tID;
		tourName = tName;
		imageMainURL = tImageMainURL;
	}
	
	public Tour(String tID, String tName, String tImageMainURL, LinkedList<String> tImageURLs, LinkedList<Point> tLocations){
		tourID = tID;
		tourName = tName;
		imageMainURL = tImageMainURL;
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
