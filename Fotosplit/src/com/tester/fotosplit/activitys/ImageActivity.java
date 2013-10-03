package com.tester.fotosplit.activitys;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;
import android.widget.Toast;

import com.tester.fotosplit.R;
import com.tester.fotosplit.entitys.ImagePart;
import com.tester.fotosplit.entitys.ImagePartAdapter;
import com.tester.fotosplit.util.PhotoSplit;

public class ImageActivity extends Activity{
	
	private static final int DEFAULT_CELLS = 3;
	
	private GridView grid;
	private ImagePartAdapter adapter;
	private ArrayList<ImagePart> images;
	private PhotoSplit photoSplit;
	private String toUri;
	private int width;
	private int height;
	private int cells;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		grid = (GridView) findViewById(R.id.gridView);
		photoSplit = new PhotoSplit(this);
		cells = getIntent().getIntExtra("CELLS", DEFAULT_CELLS);
//grid.setStretchMode(GridView.AUTO_FIT);
		grid.setNumColumns(cells);
		
		
		
//width = getIntent().getIntExtra("WIDTH", 50)/cells;
		height = getIntent().getIntExtra("HEIGHT", 50)/cells;
		width = height;
		toUri = getIntent().getStringExtra("URI");
		images = photoSplit.splitPhoto(toUri, cells, width, height);
		adapter = new ImagePartAdapter(this, images);
		





		
		
		grid.setHorizontalSpacing(1);
		grid.setVerticalSpacing(1);
		
		
		
		
		grid.setAdapter(adapter);
	}
	
	
	public void toasting (String message){
		Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}

	public GridView getGrid() {
		return grid;
	}

	public void setGrid(GridView grid) {
		this.grid = grid;
	}

	public ImagePartAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(ImagePartAdapter adapter) {
		this.adapter = adapter;
	}

	public ArrayList<ImagePart> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImagePart> images) {
		this.images = images;
	}

	public PhotoSplit getPhotoSplit() {
		return photoSplit;
	}

	public void setPhotoSplit(PhotoSplit photoSplit) {
		this.photoSplit = photoSplit;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCells() {
		return cells;
	}

	public void setCells(int cells) {
		this.cells = cells;
	}

	public String getToUri() {
		return toUri;
	}

	public void setToUri(String toUri) {
		this.toUri = toUri;
	}
	
	
	
}
