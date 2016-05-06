package com.example.hg.activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class LoginActivity extends BaseActivity implements OnCheckedChangeListener{
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
		
	}
	
}
