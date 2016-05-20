package com.example.hg.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.opengl.Visibility;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class AdressActivity extends BaseActivity{
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.more)
	private ImageView more;
	private List<Object> address;
	@Override
	protected void init() {
		setContentView(R.layout.address_activity);
		ViewUtils.inject(this);
		title.setText("我的配送地址");
		turn.setVisibility(View.VISIBLE);
		turn.setImageResource(R.drawable.sp_turn);
		more.setVisibility(View.INVISIBLE);
		address=new ArrayList<Object>();	
		
	}



	
	
}
