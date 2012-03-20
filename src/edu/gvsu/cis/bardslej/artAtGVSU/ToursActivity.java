package edu.gvsu.cis.bardslej.artAtGVSU;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ToursActivity extends Activity{
	
	/*
	 * Get tour image from URL
	 */
	public Bitmap fetchImage(String tImageURL){
		URL url;
		try {
			url = new URL(tImageURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream is = connection.getInputStream();
			Bitmap img;
			img = BitmapFactory.decodeStream(is);
			return img;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tours_layout);		
		ArrayList<Tour> tours = ParseToursXML.getTours();
		
		
		ImageButton mapButton1 = (ImageButton) findViewById(R.id.imageButton1);
		mapButton1.setImageBitmap(fetchImage(tours.get(1).imageMainURL));
		mapButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
				
				//Must call each image as a search so that the artwork in each  
				//for(int i = 0; i < tSelected.getArtPieces().size(); i++){
					//ParseArtWorkXML.artWorkRequestID(tSelected.getArtPieces().get(i).artID);
				//}
				
                startActivityForResult(intent, 0);    
			}
		});
		
		ImageButton mapButton2 = (ImageButton) findViewById(R.id.ImageButton2);
		mapButton2.setImageBitmap(fetchImage(tours.get(0).imageMainURL));
		mapButton2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
                startActivityForResult(intent, 0);
			}
		});
		
		ImageButton mapButton3 = (ImageButton) findViewById(R.id.ImageButton3);
		mapButton3.setImageBitmap(fetchImage(tours.get(2).imageMainURL));
		mapButton3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
                startActivityForResult(intent, 0);
			}
		});
	}
}
