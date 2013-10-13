package com.tester.fotosplit.activitys;

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
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tester.fotosplit.R;

public class MainActivity extends Activity {
	
	private Uri uri;
	private int cells=3;
	private int width;
	private int height;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button buttonPlay = (Button) findViewById(R.id.main_button_play);
		registerForContextMenu(buttonPlay);
	}
	
	/**
	 * Is call if button select is pressed.
	 * Open the system gallery to select a picture.
	 * @param view
	 */
	public void select(View view) {
		
		// Intent construction
		
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");
		
		

		// Ask to the System if exists application to handle this intent

		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(
				intent, 0);
		boolean isIntentSafe = activities.size() > 0;

		// Starts actity if and only if isIntentSafe is true
		if (isIntentSafe) {
			startActivityForResult(intent, 100);
		}

	}
	/**
	 * Is call to start the Activity Image
	 * @param view
	 */
	public void play (View view){
		
		if (uri!=null){
		Intent intent = new Intent (this, ImageActivity.class);
		intent.putExtra("URI", uri.toString());
		intent.putExtra("HEIGHT", height);
		intent.putExtra("WIDTH", width);
		intent.putExtra("CELLS",cells);
		
		startActivity(intent);
		}else{
			Toast.makeText(this, "Por Favor seleccione una fotografía...", Toast.LENGTH_LONG).show();
		}
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
				
				height = bitmap.getHeight();
				width = bitmap.getWidth();
				
				System.out.println("Height: " + height+ ", Width: " + width);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		
	}

	@Override
	protected void onStop() {
		super.onStop();
		
	}

}
