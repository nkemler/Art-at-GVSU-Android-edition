package edu.gvsu.cis.bardslej.artAtGVSU;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapViewActivity extends MapActivity {
	
	MapController mControl;
	GeoPoint geoP;
	MapView mapV;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		
		//TextView textView = new TextView(this);
		//textView.setText("Tours");
		//setContentView(textView);
		
		mapV = (MapView) findViewById(R.id.mapView);
		mapV.displayZoomControls(true);
		mapV.setBuiltInZoomControls(true);
		
		Button mapButton = (Button) findViewById(R.id.backButton);
		mapButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), ArtAtGVSUActivity.class);
                startActivityForResult(intent, 0);
			}
		});
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
