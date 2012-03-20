package edu.gvsu.cis.bardslej.artAtGVSU;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MapViewActivity extends MapActivity {
	
	MapView map;
	MapController controller;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		
		map = (MapView) findViewById(R.id.mapView);
		map.displayZoomControls(true);
		map.setBuiltInZoomControls(true);
		
		List<Overlay> mapOverlays = map.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.pin);
		TourPinpoints itemizedoverlay = new TourPinpoints(drawable, this);

		Tour t = ParseToursXML.getTour("3");

		for(int i = 0; i < t.artPieces.size(); i++){
			GeoPoint gp = t.artPieces.get(i).geoLoc;
			OverlayItem overlayItem = new OverlayItem(gp, t.artPieces.get(i).artTitle, null);
			itemizedoverlay.createPinPoint(overlayItem);
		}
		
		mapOverlays.add(itemizedoverlay);	
		controller = map.getController();
		controller.animateTo(t.artPieces.get(1).geoLoc);
		controller.setZoom(17);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
