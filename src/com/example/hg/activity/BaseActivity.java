package com.example.hg.activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public abstract class BaseActivity extends Activity{
	public static String userinfo = "userinfo";
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
	
	public String getPreferenceString(String key){
		SharedPreferences preferences=getSharedPreferences(userinfo, MODE_PRIVATE);
		return preferences.getString(key,"");
	}
}
