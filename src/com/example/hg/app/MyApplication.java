package com.example.hg.app;


import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MyApplication extends Application{
	public static boolean isLogin=false;
	@Override
	public void onCreate() {
		super.onCreate();
		this.init();
	}
	
	private void init(){}
	public boolean isNetWorkConnected(){
		ConnectivityManager cm=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni=cm.getActiveNetworkInfo();
		return ni!=null && ni.isConnectedOrConnecting();
	}
}
