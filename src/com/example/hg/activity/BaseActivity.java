package com.example.hg.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class BaseActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		init();
	}
	protected abstract void init();
	/*public void gotoActivity(Class<? extends Activity> cla,Bundle bundle){
		Intent inten=new Intent();
	}*/
}
