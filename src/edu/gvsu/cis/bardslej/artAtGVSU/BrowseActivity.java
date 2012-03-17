package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BrowseActivity extends Activity {
	
	
	
	URL xmlUrl;
	String inputLine;
	public void parseXML() throws Exception{
		
		xmlUrl = new URL("http://gvsuartgallery.org/service.php/search/Search/rest?method=queryRest&type=ca_tours&query=*&additional_bundles[ca_tours.icon.largeicon][returnURL]=1&additional_bundles[ca_tours.access]");
		URLConnection connect = xmlUrl.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
	
		
		while ((inputLine = in.readLine()) != null){
			inputLine = inputLine + "/n D";
		}
		in.close();
	}
	
	public void onCreate(Bundle savedInstanceState){
		try {
			parseXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText(inputLine);
		setContentView(textView);
	}
}
