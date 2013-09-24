package com.tester.fotosplit;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImagePart extends ImageView{
	private int column;
	private int row;

	public ImagePart(Context context, int column, int row) {
		super(context);
		this.column = column;
		this.row = row;
	}

	public ImagePart(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
	}

	public ImagePart(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ImagePart(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
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


	
}
