package com.example.hg.activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends BaseFragmentActivity implements OnCheckedChangeListener {
	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init() {
		setContentView(R.layout.activity_main);
		
	}

}
