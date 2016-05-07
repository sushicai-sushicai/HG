package com.example.hg.activity;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class LoginActivity extends BaseActivity implements OnCheckedChangeListener{
	@ViewInject(R.id.title)
	private TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		
		
	}
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		setContentView(R.layout.login);
		ViewUtils.inject(this);
		title.setText("登陆");
		
		
	}
	
}
