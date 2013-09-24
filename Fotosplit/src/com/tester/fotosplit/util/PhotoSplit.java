package com.tester.fotosplit.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import com.tester.fotosplit.ImagePart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/**
 * This Class convert a Photo that receive in a Matrix
 * of photos
 * @author Dabyz
 *
 */

public class PhotoSplit {
	private String toUri;
	private Uri uri;
	private Bitmap bitmapOrigin;
	private ArrayList<ImagePart> images;
	private Context context;
	public PhotoSplit() {
		super();
	}

	public PhotoSplit(String toUri, Bitmap bitmapOrigin,
			ArrayList<ImagePart> images) {
		super();
		this.toUri = toUri;
		this.bitmapOrigin = bitmapOrigin;
		this.images = images;
	}
	
	public PhotoSplit(String toUri, Context context) {
		super();
		this.toUri = toUri;
		this.context = context;
		uri = Uri.parse(toUri);
		InputStream is;
		try {
			is = context.getContentResolver().openInputStream(uri);
			this.bitmapOrigin = BitmapFactory.decodeStream(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		images = new ArrayList<ImagePart>();
	}
	
	

	/**
	 * @return the toUri
	 */
	public String getUri() {
		return toUri;
	}

	/**
	 * @param uri the toUri to set
	 */
	public void setUri(String toUri) {
		this.toUri = toUri;
	}

	/**
	 * @return the bitmapOrigin
	 */
	public Bitmap getBitmapOrigin() {
		return bitmapOrigin;
	}

	/**
	 * @param bitmapOrigin the bitmapOrigin to set
	 */
	public void setBitmapOrigin(Bitmap bitmapOrigin) {
		this.bitmapOrigin = bitmapOrigin;
	}

	/**
	 * @return the images
	 */
	public ArrayList<ImagePart> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(ArrayList<ImagePart> images) {
		this.images = images;
	}

	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(Uri uri) {
		this.uri = uri;
	}
}
