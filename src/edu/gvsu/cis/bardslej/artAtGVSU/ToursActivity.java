package edu.gvsu.cis.bardslej.artAtGVSU;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.sax.Element;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ToursActivity extends Activity{
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tours_layout);
		
		ImageButton mapButton1 = (ImageButton) findViewById(R.id.imageButton1);
		mapButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
                startActivityForResult(intent, 0);
                
                URL url = null;
				try {
					url = new URL("http://gvsuartgallery.org/service.php/search/Search/rest?method=queryRest&type=ca_tours&query=*&additional_bundles[ca_tours.icon.largeicon][returnURL]=1&additional_bundles[ca_tours.access]");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                try {
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.getInputStream();
					InputStream in = connection.getInputStream();
					//DataInputStream dis = new DataInputStream(in);
					//String msg = dis.readLine();
					
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
					Document doc = docBuilder.parse(in);
					NodeList nodes = doc.getElementsByTagName("ca_tours");
					
					for(int i = 0; i < nodes.getLength(); i++){
						Element element = (Element) nodes.item(i);
						
						NodeList tourName = ((Document) element).getElementsByTagName("displayLabel");
						Element line = (Element) tourName.item(0);
						
					}

					int i = 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
			
			}
		});
//		
//		ImageButton mapButton2 = (ImageButton) findViewById(R.id.ImageButton2);
//		mapButton2.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
//                startActivityForResult(intent, 0);
//			}
//		});
//		
//		ImageButton mapButton3 = (ImageButton) findViewById(R.id.ImageButton3);
//		mapButton3.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(view.getContext(), MapViewActivity.class);
//                startActivityForResult(intent, 0);
//			}
//		});
	}
}
