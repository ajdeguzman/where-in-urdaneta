package edu.ucuccs.whereinurdaneta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

public class WhereInUrdaneta extends Activity {

	EditText editText;
	ImageView img_btn;
	RelativeLayout rel;
	private GoogleMap GMap;
	private static final LatLng URDANETA = new LatLng(15.9751895, 120.5703162);
	ParseObject p;
	final String APPLICATION_ID = "7BVKmFj5lddiYXKIUHSRWwTh8AbilJUbf0L5iPxX";
	final String CLIENT_KEY = "XAessF2ggXY69PXz8aeyD2uptaKi8YohToG3ePS5";

	LatLng PSU = new LatLng(15.9782426, 120.5715607);
	LatLng PUNP = new LatLng(15.9847439, 120.5726536);
	LatLng ABE = new LatLng(15.9826905, 120.5714945);
	LatLng UCU = new LatLng(15.980504, 120.560681);
	LatLng Manantan = new LatLng(15.980216, 120.5717094);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_where_in_urdaneta);

		editText = (EditText) findViewById(R.id.editText);
		img_btn = (ImageView) findViewById(R.id.imgButton);
		rel = (RelativeLayout) findViewById(R.id.layoutbelow);
		rel.setVisibility(View.VISIBLE);

		// Getting reference to the SupportMapFragment of activity_main.xml
		MapFragment G_Map = (MapFragment) getFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		GMap = G_Map.getMap();

		GMap.moveCamera(CameraUpdateFactory.newLatLng(URDANETA));
		GMap.animateCamera(CameraUpdateFactory.zoomIn());
		GMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

	}

	public void click_search(View v) {
		ParseObject p = new ParseObject("Locations");
		ParseGeoPoint geo_point = new ParseGeoPoint();
		p.put("location", geo_point);
		p.saveInBackground();

	}

}
