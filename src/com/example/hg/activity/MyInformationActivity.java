package com.example.hg.activity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
public class MyInformationActivity extends BaseActivity implements OnCheckedChangeListener{
	@ViewInject(R.id.turn)
	private ImageView turn;

	@Override
	protected void init() {
		setContentView(R.layout.myinformation);
		ViewUtils.inject(this);
		System.out.println("===========================");
		
	}
	@OnClick({R.id.turn})
	public void myClick(View v){
		toast(v.getId()+"");
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

}
