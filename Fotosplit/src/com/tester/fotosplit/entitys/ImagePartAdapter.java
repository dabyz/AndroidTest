package com.tester.fotosplit.entitys;

import java.util.ArrayList;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.tester.fotosplit.R;

public class ImagePartAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<ImagePart> images;



	public ImagePartAdapter(Context context, ArrayList<ImagePart> images) {
		this.context = context;
		this.images = images;
	}
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public ArrayList<ImagePart> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImagePart> images) {
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
		imageView.setImageBitmap(images.get(position).getBitmap());
		view.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {
				ImageView imageView = (ImageView) view
						.findViewById(R.id.imageView1);
				// ClipData.Item item = new ClipData.Item((CharSequence)
				// view.getTag());
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(
						imageView);
				ClipData clipData = ClipData.newPlainText(
						"Id: " + view.getId(), "TestDaD");
				view.startDrag(clipData, shadow, view, view.getId());

				return true;
			}
		});

		view.setOnDragListener(new OnDragListener() {

			@Override
			public boolean onDrag(View view, DragEvent event) {

				View startView = (View) event.getLocalState();
				
				switch (event.getAction()) {
				case DragEvent.ACTION_DRAG_STARTED:
					
					break;
					
				case DragEvent.ACTION_DRAG_EXITED:
					view.setPressed(false);
					break;
					
				case DragEvent.ACTION_DRAG_ENTERED:
					view.setPressed(true);
					break;
					
				case DragEvent.ACTION_DROP:
					cambiaImagen(startView, view);
					if (compruebaPuzzle()){
						Toast.makeText(view.getContext(), "YOU WINNNNNN", Toast.LENGTH_LONG).show();
						
					}
					break;
					
				}
				return true;
			}
			
			public boolean compruebaPuzzle() {
				boolean result = true;
				for (int i = 0; i<images.size() && result ; i++){
					result = 
							i == images.get(i).getRealPosition();
				}
				
				return result;
				
			}

			public void cambiaImagen(View startView, View view){
				ImageView imageView;
				GridView grid;
				ImagePart imagePart;
				ImagePart imagePartAux;
				ImagePartAdapter adapter;
				Bitmap bitmap;
				grid = (GridView) startView.getParent();
				adapter = (ImagePartAdapter) grid.getAdapter();

				imageView = (ImageView) view.findViewById(R.id.imageView1);
				imagePart = (ImagePart) adapter.getItem(startView.getId());
				bitmap = imagePart.getBitmap();
				imageView.setImageBitmap(bitmap);
				imagePartAux = imagePart;

				imageView = (ImageView) startView.findViewById(R.id.imageView1);
				imagePart = (ImagePart) adapter.getItem(view.getId());
				bitmap = imagePart.getBitmap();
				imageView.setImageBitmap(bitmap);
				adapter.getImages().set(view.getId(),imagePartAux);
				adapter.getImages().set(startView.getId(),imagePart);
			}
			
		});

		return view;
	}
}