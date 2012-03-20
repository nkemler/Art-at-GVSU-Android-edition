package edu.gvsu.cis.bardslej.artAtGVSU;


import java.util.LinkedList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ToursActivity extends Activity{
	
	//Gets enough information in tour object to display everything except for the image icons
	private LinkedList<Tour> retrieveTourInformation(){
		LinkedList<Tour> tours = new LinkedList<Tour>();
		tours = ParseToursXML.toursRequest();
		
		//Get minimal data of each artwork stops for each tour
		for(int i = 0; i < tours.size(); i++){
			ParseToursXML.toursIndividualDataRequest(tours.get(i).tourID);
		}
		
		return ParseToursXML.getTours();
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tours_layout);		
		
		ImageButton mapButton1 = (ImageButton) findViewById(R.id.imageButton1);
		mapButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
				
				LinkedList<Tour> t = retrieveTourInformation();
				//Must call each image as a search so that the artwork in each  
				//for(int i = 0; i < tSelected.getArtPieces().size(); i++){
					//ParseArtWorkXML.artWorkRequestID(tSelected.getArtPieces().get(i).artID);
				//}
                startActivityForResult(intent, 0);    
			}
		});
		
		ImageButton mapButton2 = (ImageButton) findViewById(R.id.ImageButton2);
		mapButton2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
                startActivityForResult(intent, 0);
			}
		});
		
		ImageButton mapButton3 = (ImageButton) findViewById(R.id.ImageButton3);
		mapButton3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
                startActivityForResult(intent, 0);
			}
		});
	}
}
