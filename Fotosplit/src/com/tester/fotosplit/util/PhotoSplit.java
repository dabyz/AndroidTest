package com.tester.fotosplit.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.tester.fotosplit.entitys.ImagePart;

/**
 * Work with Bitmap
 * 
 * @author David Alegre Viñas
 *
 */

public class PhotoSplit {
	
	private Context context;

	public PhotoSplit() {
		super();
	}	
	
	public PhotoSplit(Context context) {
		super();
		this.context = context;
	}

	/**
	 * Return a matrix cells * cells with the bitmap split
	 * in each cell.
	 * 
	 * @param toUri The Uri to decode the stream of complete picture
	 * @param cells Number of cells in the columns and rows.
	 * @param width The width of each part
	 * @param height The height of each part
	 * 
	 * @return An ArrayList with whole picture splits in parts.
	 */
	public ArrayList<ImagePart> splitPhoto(String toUri, int cells, int width, int height){
		Bitmap bitmap = decodeImage(toUri);
		//The initial coordinates
		int x = 0;
		int y = 0;
		ArrayList<ImagePart> images = new ArrayList<ImagePart>();
		for(int i = 0; i<cells*cells ; i++){
			//Calculate initial position of this part
			x = (i%cells) * width;
			y = (i/cells) * height;
			
			Bitmap bitmapPart = Bitmap.createBitmap(
						bitmap, x, y, width, height
					);
			ImagePart imagePart = new ImagePart();
			imagePart.setBitmap(bitmapPart);
			images.add(imagePart);
		}
		return images;
	}
	
	/**
	 * Return a Bitmap from a String that represent the uri
	 * to obtain it.
	 * @param toUri
	 * @return the Bitmap
	 */
	public Bitmap decodeImage (String toUri){
		Bitmap bitmap = null;
		Uri uri = Uri.parse(toUri);
		InputStream is;
		try {
			is = context.getContentResolver().openInputStream(uri);
			bitmap = BitmapFactory.decodeStream(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}
