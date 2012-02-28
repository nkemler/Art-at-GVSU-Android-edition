package edu.gvsu.cis.bardslej.artAtGVSU;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BrowseActivity extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("Browse needs to be implemented");
		setContentView(textView);
	}
}
