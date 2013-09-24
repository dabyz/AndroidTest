package com.tester.fotosplit;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private Uri uri;
	private int cells=3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button buttonPlay = (Button) findViewById(R.id.main_button_play);
		registerForContextMenu(buttonPlay);
	}

	public void select(View view) {
		
		// Construcción Intent
		
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");
		
		

		// Comprobación de disponibilidad de aplicación para el Intent

		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(
				intent, 0);
		boolean isIntentSafe = activities.size() > 0;

		// Se lanza la activity
		if (isIntentSafe) {
			startActivityForResult(intent, 100);
		}

	}
	/**
	 * Is call to start the Activity Image
	 * @param view
	 */
	public void play (View view){
		Intent intent = new Intent (this, ImageActivity.class);
		intent.putExtra("URI", uri.toString());
		
		intent.putExtra("CELLS",cells);
		
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 100) {
			try {
				uri = data.getData();
				InputStream is;

				is = getContentResolver().openInputStream(uri);

				ImageView imageView = (ImageView) findViewById(R.id.main_imageView);
				Bitmap bitmap = BitmapFactory.decodeStream(is);
				imageView.setImageBitmap(bitmap);

				System.out.println("Request Code: " + requestCode);
				System.out.println("Result Code: " + resultCode);
				System.out.println("Data: " + data.getData() != null ? data
						.getData() : "null");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("FotoSplit","onDestroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("FotoSplit","onPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("FotoSplit","onRestar");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("FotoSplit","onResume");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("FotoSplit","onStart");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("FotoSplit","onStop");
	}

}
