package edu.ucuccs.whereinurdaneta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Home extends Activity {

	// Array of strings storing country names
	String[] name_place = new String[] { "Colleges & Universities", "Malls",
			"Hotels", "Terminals", "Restuarants", "Recreational Area" };

	// Array of integers points to images stored in /res/drawable-ldpi/
	int[] img = new int[] { R.drawable.ic_uni, R.drawable.ic_shop,
			R.drawable.ic_restau, R.drawable.ic_bu, R.drawable.ic_hote,
			R.drawable.ic_recrea };

	// flag for Internet connection status
	Boolean isInternetPresent = false;

	// Connection detector class
	InternetConnection cd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// creating connection detector class instance
		cd = new InternetConnection(getApplicationContext());

		// Getting a reference to listview of main.xml layout file
		ListView listView = (ListView) findViewById(R.id.list);

		List<HashMap<String, Object>> data_list = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < 6; i++) {
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("placeName", name_place[i]);
			hm.put("place_image", Integer.toString(img[i]));
			data_list.add(hm);

		}

		// Instantiating an adapter to store each items
		SimpleAdapter adapter = new SimpleAdapter(this, data_list,
				R.layout.listview_layout, new String[] { "place_image",
						"placeName" }, new int[] { R.id.place_image,
						R.id.placeName });

		// Setting the adapter to the listView
		listView.setAdapter(adapter);

		// get Internet status
		isInternetPresent = cd.isConnectingToInternet();
		// check for Internet status
		if (isInternetPresent) {
			// Internet Connection is Present
			// make HTTP requests

			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub

					
						Intent intent = new Intent(Home.this,
								WhereInUrdaneta.class);
						

						// Start SingleItemView Class
						startActivity(intent);
						

				}

			});

		} else {
			// Internet connection is not present
			// Ask user to connect to Internet
			showAlertDialog(Home.this, "No Internet Connection",
					"You don't have internet connection.", false);
		}

	}

	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		// Setting alert dialog icon
		alertDialog.setIcon(R.drawable.alert);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}

}
