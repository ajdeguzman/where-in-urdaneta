package edu.ucuccs.whereinurdaneta;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class WhereInUrdaneta extends Activity {

	EditText editText;
	ImageView img_btn;

	private GoogleMap GMap;
	private static final LatLng URDANETA = new LatLng(15.9751895, 120.5703162);

	LatLng PSU = new LatLng(15.9876009, 120.5738445);
	LatLng PUNP = new LatLng(15.9847439, 120.5726536);
	LatLng UCU = new LatLng(15.979592, 120.5611147);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_where_in_urdaneta);

		editText = (EditText) findViewById(R.id.editText);
		img_btn = (ImageView) findViewById(R.id.imgButton);

		// Getting reference to the SupportMapFragment of activity_main.xml
		MapFragment G_Map = (MapFragment) getFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		GMap = G_Map.getMap();

		GMap.moveCamera(CameraUpdateFactory.newLatLng(URDANETA));
		GMap.animateCamera(CameraUpdateFactory.zoomIn());
		GMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

		GroundOverlayOptions overlay_punp = new GroundOverlayOptions().image(
				BitmapDescriptorFactory.fromResource(R.drawable.punp_logo))
				.position(PUNP, 300f, 300f);
		GMap.addGroundOverlay(overlay_punp);

		GroundOverlayOptions overlay_UCU = new GroundOverlayOptions().image(
				BitmapDescriptorFactory.fromResource(R.drawable.ucu_logo))
				.position(UCU, 300f, 300f);
		GMap.addGroundOverlay(overlay_UCU);

		GroundOverlayOptions overlay_PSU = new GroundOverlayOptions().image(
				BitmapDescriptorFactory.fromResource(R.drawable.psu_logo))
				.position(PSU, 300f, 300f);
		GMap.addGroundOverlay(overlay_PSU);
		
		
		
		
		// Sir hindi ko po alam yung codes ng pagsesearch.
		/*
		 * public void click_search(View v) {
		 * 
		 * String edittext_search = editText.getText().toString(); if
		 * (edittext_search.equals("location")) {
		 * 
		 * ParseGeoPoint userLocation = (ParseGeoPoint) userObject .get("location");
		 * ParseQuery<ParseObject> query = ParseQuery.getQuery("Locations");
		 * query.whereNear("location", userLocation); query.setLimit(10);
		 * query.findInBackground(new FindCallback<ParseObject>() {
		 * 
		 * @Override public void done(List<ParseObject> arg0, ParseException arg1) {
		 * // TODO Auto-generated method stub
		 * 
		 * for (int i = 0; i < arg0.size(); i++) {
		 * Toast.makeText(getApplicationContext(), arg0.get(i).getInt("location") +
		 * "", Toast.LENGTH_LONG).show(); }
		 * 
		 * }
		 * 
		 * });
		 * 
		 * }
		 */
		
		
		
		
		
		

	}

}
