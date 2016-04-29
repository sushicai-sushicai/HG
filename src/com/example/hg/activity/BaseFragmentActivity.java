package com.example.hg.activity;


import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.WindowManager;

public abstract class BaseFragmentActivity extends FragmentActivity{
	FragmentManager fragmentManager;
	protected abstract void init();
	protected void onCreate(Bundle arg0){
		super.onCreate(arg0);	
		fragmentManager=getSupportFragmentManager();
		if(VERSION.SDK_INT>=VERSION_CODES.KITKAT){
			//设置透明状态栏
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			//透明导航栏
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
		init();
	}
	
	
	

}
