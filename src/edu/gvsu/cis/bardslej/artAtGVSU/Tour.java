package edu.gvsu.cis.bardslej.artAtGVSU;

import java.util.LinkedList;

/*
 * Tour class creates a tour object that holds data and image URLs to pieces of art
 */
public class Tour {
	
	String tourID;
	String tourName;
	String imageMainURL;
	String tourAccess;
	LinkedList<ArtWork> artPieces = new LinkedList<ArtWork>();

	public Tour(){
		tourID = null;
		tourName = null;
		imageMainURL = null;
		tourAccess = null;
		artPieces = null;
	}
	
	public Tour(String tID, String tName, String tImageMainURL, String tAccess){
		tourID = tID;
		tourName = tName;
		imageMainURL = tImageMainURL;
		tourAccess = tAccess;
		artPieces = null;
	}
	
	public Tour(String tID, String tName, String tImageMainURL, String tAccess, LinkedList<ArtWork> aPieces){
		tourID = tID;
		tourName = tName;
		imageMainURL = tImageMainURL;
		tourAccess = tAccess;
		artPieces = aPieces;
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

	public LinkedList<ArtWork> getArtPieces() {
		return artPieces;
	}

	public void setArtPieces(LinkedList<ArtWork> artPieces) {
		this.artPieces = artPieces;
	}	
}
