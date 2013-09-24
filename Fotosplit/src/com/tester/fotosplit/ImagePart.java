package com.tester.fotosplit;

import android.graphics.Bitmap;

public class ImagePart{
	private int column;
	private int row;
	private Bitmap bitmap;

	
	
	public ImagePart() {
		super();
	}


	public ImagePart( int column, int row, Bitmap bitmap) {
		this.column = column;
		this.row = row;
	}


	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}


	public Bitmap getBitmap() {
		return bitmap;
	}


	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}


	
}
