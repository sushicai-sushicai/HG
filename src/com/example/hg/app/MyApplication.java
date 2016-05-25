package com.example.hg.app;


import com.example.hg.HttpUtils.HtmlUtil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.WindowManager;

public class MyApplication extends Application{
	public static boolean isLogin=false;
	private static  HtmlUtil htmlUtil;
	
	/**屏幕宽度 */
	private static int SCREEN_WIDTH;
	/**屏幕高度 */
	private static int SCREEN_HEIGHT;
	/** 我的经度 */
	public static double myLng = 0;
	/** 我的纬度 */
	public static double myLat = 0;
	public static String myCity = "重庆市";
	public static String myAddress;
	public static String Street;
	public static String myCityCode = "2459";// 5001
	public static String selectCityCode = "2459";// 5001
	public static String selectBaiduCode;// 5001
	
	@Override
	public void onCreate() {
		super.onCreate();
		this.init();
	}
	
	private void init(){
		isLogin=getPreferenceBoolean("isLogin");
		htmlUtil=new HtmlUtil(getApplicationContext());
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		SCREEN_WIDTH=wm.getDefaultDisplay().getWidth();
		SCREEN_HEIGHT=wm.getDefaultDisplay().getHeight();
		isLogin=getPreferenceBoolean("isLogin");
		getloction();//获取地理位置
		
	}
	/**获取地理位置*/
	private void getloction() {
		SharedPreferences myLocation=getSharedPreferences("myLocation",Context.MODE_PRIVATE);
		Editor editor=myLocation.edit();
		myLat=(double)myLocation.getFloat("lat",(float)29.543825);
		myLng=(double)myLocation.getFloat("lng",(float) 106.586306);
		myCity=myLocation.getString("myCity", "重庆市");
		myAddress=myLocation.getString("myCity", "重庆市南岸区南滨路国际金融中心");
		myCityCode = myLocation.getString("myCityCode", "2459");
		editor.commit();
	}
	private boolean getPreferenceBoolean(String key) {
		SharedPreferences preferences = getSharedPreferences("userinfo",MODE_PRIVATE);
		return preferences.getBoolean(key, false);
	}
	/** 手机屏幕宽度 */
	public static int getScreenWidth() {
		return SCREEN_WIDTH;
	}

	/** 手机屏幕高度 */
	public static int getScreenHeight() {
		return SCREEN_HEIGHT;
	}
	public static HtmlUtil getHtmlUtil(){
		return htmlUtil;
	}
	/**
	 * 判断是否网络是否可用
	 * @return
	 */
	public boolean isNetWorkConnected(){
		ConnectivityManager cm=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni=cm.getActiveNetworkInfo();
		return ni!=null && ni.isConnectedOrConnecting();
		
	}
}
