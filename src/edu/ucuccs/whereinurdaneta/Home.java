package edu.ucuccs.whereinurdaneta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends Activity {

	ImageView img_universities;
	ImageView img_recreational;
	ImageView img_restaurant;
	ImageView img_terminal;
	ImageView img_hotel;
	ImageView img_mall;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_home);

		img_universities = (ImageView) findViewById(R.id.imageButton2);
		img_recreational = (ImageView) findViewById(R.id.imageButton3);
		img_restaurant = (ImageView) findViewById(R.id.imageButton4);
		img_terminal = (ImageView) findViewById(R.id.imageButton5);
		img_hotel = (ImageView) findViewById(R.id.imageButton6);
		img_mall = (ImageView) findViewById(R.id.imageButton7);

	}

	public void img_terminal(View v) {

		// TODO Auto-generated method stub
		Intent terminal = new Intent(Home.this, WhereInUrdaneta.class);
		startActivity(terminal);

	}

	public void img_universities(View v) {
		// TODO Auto-generated method stub
		Intent uni = new Intent(Home.this, WhereInUrdaneta.class);
		startActivity(uni);

	}

	public void img_recreational(View v) {
		// TODO Auto-generated method stub
		Intent recreational = new Intent(Home.this, WhereInUrdaneta.class);
		startActivity(recreational);

	}

	public void img_restaurant(View v) {
		// TODO Auto-generated method stub
		Intent restaurant = new Intent(Home.this, WhereInUrdaneta.class);
		startActivity(restaurant);

	}

	public void img_hotel(View v) {
		// TODO Auto-generated method stub
		Intent hotel = new Intent(Home.this, WhereInUrdaneta.class);
		startActivity(hotel);

	}

	public void img_mall(View v) {
		// TODO Auto-generated method stub
		Intent mall = new Intent(Home.this, WhereInUrdaneta.class);
		startActivity(mall);

	}

}
