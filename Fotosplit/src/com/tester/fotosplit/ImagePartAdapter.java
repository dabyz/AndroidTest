package com.tester.fotosplit;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ImagePartAdapter extends BaseAdapter{
	private Context context;
	private ArrayList<ImagePart> images;
	
	public ImagePartAdapter(Context context, ArrayList<ImagePart> images){
		this.context = context;
		this.images = images;
	}

	@Override
	public int getCount() {
		return images.size();
	}

	@Override
	public Object getItem(int position) {
		return images.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.row_image, parent);
		images.get(position);
		
		
		
		
		return null;
	}

}
