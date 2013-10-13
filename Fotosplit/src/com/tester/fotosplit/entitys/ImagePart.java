package com.tester.fotosplit.entitys;

import android.graphics.Bitmap;

public class ImagePart{
	private int realPosition;
	private Bitmap bitmap;

	
	
	public ImagePart() {
		super();
	}


	public ImagePart( int realPostition, Bitmap bitmap) {
		this.realPosition = realPostition;
	}

	public int getRealPosition() {
		return realPosition;
	}

	public void setRealPosition (int realPosition) {
		this.realPosition = realPosition;
	}


	public Bitmap getBitmap() {
		return bitmap;
	}


	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}



	
}
