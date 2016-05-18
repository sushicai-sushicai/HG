package com.example.hg.app;


import com.example.hg.HttpUtils.HtmlUtil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MyApplication extends Application{
	public static boolean isLogin=false;
	private static  HtmlUtil htmlUtil;
	@Override
	public void onCreate() {
		super.onCreate();
		this.init();
	}
	
	private void init(){
		isLogin=getPreferenceBoolean("isLogin");
		htmlUtil=new HtmlUtil(getApplicationContext());
	}
	private boolean getPreferenceBoolean(String key) {
		SharedPreferences preferences = getSharedPreferences("userinfo",MODE_PRIVATE);
		return preferences.getBoolean(key, false);
	}
	public boolean isNetWorkConnected(){
		ConnectivityManager cm=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni=cm.getActiveNetworkInfo();
		return ni!=null && ni.isConnectedOrConnecting();
	}
	public static HtmlUtil getHtmlUtil(){
		return htmlUtil;
	}
}
