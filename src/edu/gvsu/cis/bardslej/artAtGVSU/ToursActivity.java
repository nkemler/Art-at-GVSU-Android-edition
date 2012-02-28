package edu.gvsu.cis.bardslej.artAtGVSU;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToursActivity extends Activity{
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tours_layout);
		
		Button mapButton = (Button) findViewById(R.id.showMapButton);
		mapButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
                startActivityForResult(intent, 0);
			}
		});
	}
}
