package edu.gvsu.cis.bardslej.artAtGVSU;

/*
 * Class for a piece of artWork and its detials
 */
public class ArtWork {
	
	String artID;
	String artistID;
	String artistName;
	String artTitle;
	String description;
	String idno;
	String workDate;
	String historicalContext;
	String imageURL;
	String locName;
	String medium;
	GeoPoint geoLoc;
	String stopID;
	
	public ArtWork(){
		artID = null;
		artistID = null;
		artistName = null;
		artTitle = null;
		description = null;
		idno = null;
		workDate = null;
		historicalContext= null;
		imageURL = null;
		locName = null;
		medium = null;
		geoLoc = null;
		stopID = null;
	}
	
	/*
	 * Constructor used for a piece of art shown by the tours menu
	 */
	public ArtWork(GeoPoint aGeoLoc, String aName, String aID, String aStopID, String aImageUrl){
		artID = aID;
		geoLoc = aGeoLoc;
		artTitle = aName;
		stopID = aStopID;
		imageURL = aImageUrl;
		artistID = null;
		artistName = null;
		description = null;
		idno = null;
		workDate = null;
		historicalContext= null;
		locName = null;
		medium = null;
	}
	
	public ArtWork(String aID, String aArtistID, String aArtistName, String aTitle, String aDescription, String aIdNo, String aWorkDate, String aHistContext, String aImageURL, String aLocName, String aMedium, GeoPoint aGeoLoc, String aStopID){
		artID = aID;
		artistID = aArtistID;
		artistName = aArtistName;
		artTitle = aTitle;
		description = aDescription;
		idno = aIdNo;
		workDate = aWorkDate;
		historicalContext= aHistContext;
		imageURL = aImageURL;
		locName = aLocName;
		medium = aMedium;
		geoLoc = aGeoLoc;
		stopID = aStopID;
	}
}
