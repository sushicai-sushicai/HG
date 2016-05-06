package com.example.hg.app;

import android.app.Application;

public class MyApplication extends Application{
	public static boolean isLogin=false;
	@Override
	public void onCreate() {
		super.onCreate();
		this.init();
	}
	
	private void init(){
	}
}
