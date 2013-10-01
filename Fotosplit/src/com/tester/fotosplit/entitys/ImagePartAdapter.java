package com.tester.fotosplit.entitys;

import java.util.ArrayList;
import java.util.ResourceBundle;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.tester.fotosplit.R;

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
		View view = inflater.inflate(R.layout.row_image, null);
		view.setId(position);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);

		imageView.setImageBitmap(
				images.get(position).getBitmap());
		
		

		
		view.setOnDragListener(new OnDragListener() {
			
			@Override
			public boolean onDrag(View view, DragEvent event) {
				
				View startView = view;
				
				switch (event.getAction())
				{
				case DragEvent.ACTION_DRAG_STARTED:
					System.out.println("......DragStarted.in" + 
												view.getId());
					
				case DragEvent.ACTION_DRAG_EXITED:
					System.out.println("......View Exited..from." + 
												view.getId());
				case DragEvent.ACTION_DRAG_ENTERED:
					System.out.println("......DragEntered...in.." + 
												view.getId());
				case DragEvent.ACTION_DROP:
					ImageView imageView;
					GridView grid;
					ImagePart imagePart;
					Adapter adapter;
					Bitmap bitmap;
					
					grid = (GridView) event.getLocalState();
					adapter = grid.getAdapter();
					
					imageView = (ImageView)view.findViewById(R.id.imageView1);
					imagePart = (ImagePart)adapter.getItem(startView.getId());
					bitmap = imagePart.getBitmap();
					imageView.setImageBitmap(bitmap);
					
					imageView = (ImageView)startView.findViewById(R.id.imageView1);
					imagePart = (ImagePart)adapter.getItem(view.getId());
					bitmap = imagePart.getBitmap();
					imageView.setImageBitmap(bitmap);
					
				}
				return true;
			}
		});
		
		
		
		return view;
	}

}
