package edu.ucuccs.whereinurdaneta;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class WhereInUrdaneta extends Activity {

	EditText editText;
	ImageView img_btn;

	private GoogleMap GMap;
	private static final LatLng URDANETA = new LatLng(15.9751895, 120.5703162);

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
	}

}
