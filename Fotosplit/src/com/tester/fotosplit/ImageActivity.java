package com.tester.fotosplit;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.GridView;

public class ImageActivity extends Activity {
	
	private GridView grid;
	private ImagePartAdapter adapter;
	private ArrayList<ImagePart> images;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		images =  
		
		adapter = new ImagePartAdapter(this, images)
		
		grid = (GridView) findViewById(R.id.gridView);
		grid.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}

}
