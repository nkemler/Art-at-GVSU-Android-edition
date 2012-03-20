package edu.gvsu.cis.bardslej.artAtGVSU;

import java.util.ArrayList;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class ArtAtGVSUActivity extends TabActivity{
    
	private TabHost mTabHost;
	
	//Gets enough information in tour object to display everything except for the image icons
	private void retrieveTourInformation(){
		ArrayList<Tour> tours = new ArrayList<Tour>();
		tours = ParseToursXML.toursRequest();
		
		//Get minimal data of each artwork stops for each tour
		for(int i = 0; i < tours.size(); i++){
			ParseToursXML.toursIndividualDataRequest(tours.get(i).tourID);
		}
	}
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Make call to tours so that information is recieved when app first opens 
		retrieveTourInformation();
		
        Resources res = getResources();
        mTabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        	
        
        //Tours Tab
        intent = new Intent(this, ToursActivity.class);
        spec = mTabHost.newTabSpec("Tours").setIndicator("Tours", res.getDrawable(R.drawable.tours_icon)).setContent(intent);
        mTabHost.addTab(spec);
        
        //Browse Tab
        intent = new Intent(this, BrowseActivity.class);
        spec = mTabHost.newTabSpec("Browse").setIndicator("Browse", res.getDrawable(R.drawable.browse_icon)).setContent(intent);
        mTabHost.addTab(spec);
        
        //Favorites Tab
        intent = new Intent(this, FavoritesActivity.class);
        spec = mTabHost.newTabSpec("Favs").setIndicator("Favs", res.getDrawable(R.drawable.favorites_icon)).setContent(intent);
        mTabHost.addTab(spec);
    }
}