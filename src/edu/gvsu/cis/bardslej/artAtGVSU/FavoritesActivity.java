package edu.gvsu.cis.bardslej.artAtGVSU;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FavoritesActivity extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("Favorites Needs to be implemented");
		setContentView(textView);
	}
}
