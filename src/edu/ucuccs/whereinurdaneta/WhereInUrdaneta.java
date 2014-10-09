package edu.ucuccs.whereinurdaneta;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class WhereInUrdaneta extends Activity {

	RelativeLayout rel;
	private GoogleMap GMap;

	private static final LatLng URDANETA = new LatLng(15.9751895, 120.5703162);
	ParseObject p;
	final String APPLICATION_ID = "7BVKmFj5lddiYXKIUHSRWwTh8AbilJUbf0L5iPxX";
	final String CLIENT_KEY = "XAessF2ggXY69PXz8aeyD2uptaKi8YohToG3ePS5";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_where_in_urdaneta);
		rel = (RelativeLayout) findViewById(R.id.layoutbelow);
		rel.setVisibility(View.VISIBLE);

		// Getting reference to the SupportMapFragment of activity_main.xml
		MapFragment G_Map = (MapFragment) getFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		GMap = G_Map.getMap();

		GMap.moveCamera(CameraUpdateFactory.newLatLng(URDANETA));
		GMap.animateCamera(CameraUpdateFactory.zoomIn());
		GMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);

		Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Locations");

		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> listahan, ParseException e) {
				// TODO Auto-generated method stub

				List<Marker> markers = new ArrayList<Marker>();

				for (int i = 0; i < listahan.size(); i++) {

					listahan.get(i).getParseGeoPoint("location");

					ParseGeoPoint geo = listahan.get(i).getParseGeoPoint(
							"location");
					Marker marker = GMap.addMarker(new MarkerOptions()
							.position(
									new LatLng(geo.getLatitude(), geo
											.getLongitude()))
							.icon(BitmapDescriptorFactory
									.fromResource(R.drawable.university))

					);

					markers.add(marker);
			
				}
				
			}

		});
		GMap.clear();
		
	

		ParseQuery<ParseObject> malls = new ParseQuery<ParseObject>("Malls");

		malls.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> listahan, ParseException e) {
				// TODO Auto-generated method stub

				List<Marker> markers = new ArrayList<Marker>();

				for (int i = 0; i < listahan.size(); i++) {

					listahan.get(i).getParseGeoPoint("LatLang");

					ParseGeoPoint geo = listahan.get(i).getParseGeoPoint(
							"LatLang");

					Marker marker = GMap.addMarker(new MarkerOptions()
							.position(
									new LatLng(geo.getLatitude(), geo
											.getLongitude())).icon(
									BitmapDescriptorFactory
											.fromResource(R.drawable.mall))

					);
					
					markers.add(marker);

				}
			
			}

		});
		GMap.clear();
		GMap.clear();
		
	}

}
