package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.Button;
import android.widget.Toast;

public class MapViewActivity extends MapActivity {
	
	MapController mControl;
	GeoPoint geoP;
	MapView map;
	long start;
	long stop;
	MyLocationOverlay points;
	MapController controller;
	int x, y;
	Drawable d;
	List<Overlay> overlayList;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		
		//TextView textView = new TextView(this);
		//textView.setText("Tours");
		//setContentView(textView);
		
		map = (MapView) findViewById(R.id.mapView);
		map.displayZoomControls(true);
		map.setBuiltInZoomControls(true);
		
		PointOverlay pointOverlay = new PointOverlay();
		overlayList = map.getOverlays();
		overlayList.add(pointOverlay);		
		
		//d = getResources().getDrawable(R.drawable.pin);
		//Tour t = ParseToursXML.getTour("1");
		//controller.animateTo(t.artPieces.get(1).geoLoc);
		//for(int i = 0; i < t.artPieces.size(); i++){
		//	OverlayItem overlayItem = new OverlayItem(t.artPieces.get(i).geoLoc, t.artPieces.get(i).artTitle, null);
		//	TourPinpoints custom = new TourPinpoints(d, MapViewActivity.this);
		//	custom.createPinPoint(overlayItem);
		//	overlayList.add(custom);
		//}
		//controller.setZoom(10);
		
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
	
	class PointOverlay extends Overlay{
		public boolean onTouchEvent(MotionEvent e, MapView m){
			if(e.getAction() == MotionEvent.ACTION_DOWN){
				start = e.getEventTime();
				x = (int) e.getX();
				y = (int) e.getY();
				//point to where was touched on screen
				geoP = map.getProjection().fromPixels(x, y);
			}
			if(e.getAction() == MotionEvent.ACTION_UP){
				stop = e.getEventTime();
			}
			if(stop - start > 1500){
				AlertDialog alert = new AlertDialog.Builder(MapViewActivity.this).create();
				alert.setTitle("Pick an  Option");
				alert.setMessage("lets select something");
				alert.setButton("place a pin", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						d = getResources().getDrawable(R.drawable.pin);
						Tour t = ParseToursXML.getTour("1");
						//controller.animateTo(t.artPieces.get(1).geoLoc);
						for(int i = 0; i < t.artPieces.size(); i++){
							OverlayItem overlayItem = new OverlayItem(t.artPieces.get(i).geoLoc, t.artPieces.get(i).artTitle, null);
							TourPinpoints custom = new TourPinpoints(d, MapViewActivity.this);
							custom.createPinPoint(overlayItem);
							overlayList.add(custom);
						}
					}
				});
				alert.setButton2("get address", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Geocoder geocoder =  new Geocoder(getBaseContext(), Locale.getDefault());
						try{
							List<Address> address = geocoder.getFromLocation(geoP.getLatitudeE6() / 1E6, geoP.getLongitudeE6() / 1E6, 1);
							if(address.size() > 0){
								String display = "";
								for (int i = 0; i < address.get(0).getMaxAddressLineIndex() ; i++){
									display += address.get(0).getAddressLine(i) + "\n";
								}
								Toast t = Toast.makeText(getBaseContext(), display, Toast.LENGTH_LONG);
								t.show();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							
						}
					}
				});
				alert.setButton3("option 3", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				
				alert.show();
				return true;
			}
			return false;
		}
	}
}
