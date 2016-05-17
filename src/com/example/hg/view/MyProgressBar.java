package com.example.hg.view;



import com.example.hg.activity.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 进度条
 * @author ssc
 *
 */
public class MyProgressBar extends Dialog{
	private ImageView myprogressbar;

	/** 进度条 */
	public MyProgressBar(Context context) {
		super(context, R.style.agreemdialog);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myprogressbar);
		myprogressbar = (ImageView) findViewById(R.id.myprogressbar);
	}
	public ImageView getImageView() {
		return myprogressbar;
	}
}
