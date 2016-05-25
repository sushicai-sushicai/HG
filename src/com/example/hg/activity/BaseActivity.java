package com.example.hg.activity;


import com.example.hg.app.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends Activity{
	
	public MyApplication appContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		appContext=(MyApplication) getApplication();
		init();
	}
	protected abstract void init();
	/*public void gotoActivity(Class<? extends Activity> cla,Bundle bundle){
		Intent inten=new Intent();
	}*/
	public static String userinfo = "userinfo";
	public String getPreferenceString(String key){
		SharedPreferences preferences=getSharedPreferences(userinfo, MODE_PRIVATE);
		return preferences.getString(key,"");
	}
	/**
	 * public void savePreferenceString(String key, String value) {
		SharedPreferences preferences = getSharedPreferences(userinfo,
				MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	 */
	public void savePreferenceString(String arg0,String arg1){
		SharedPreferences sp=getSharedPreferences(userinfo, MODE_PRIVATE);
		Editor editor=sp.edit();
		editor.putString(arg0, arg1);
		editor.commit();
	}
	public void savePreferenceBoolean(String key, boolean value) {
		SharedPreferences preferences = getSharedPreferences(userinfo,
				MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public boolean getPreferenceBoolean(String key) {
		SharedPreferences preferences = getSharedPreferences(userinfo,
				MODE_PRIVATE);
		return preferences.getBoolean(key, false);
	}

	

	public void deleteKey(String key) {
		SharedPreferences preferences = getSharedPreferences(userinfo,
				MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.remove(key);
		editor.commit();
	}

	public void savePreferenceLong(String key, long value) {
		SharedPreferences preferences = getSharedPreferences(userinfo,
				MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public long getPreferenceLong(String key) {
		SharedPreferences preferences = getSharedPreferences(userinfo,
				MODE_PRIVATE);
		return preferences.getLong(key, 0);
	}

	protected void toast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	protected void toast(int text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	/**
	 * 跳转到另一个页面
	 * */
	public void gotoActivity(Class<? extends Activity> cls, boolean finish,
			Bundle bundle) {

		Intent intent = new Intent(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
		if (finish) {
			finish();
		}
	}
	
	public void gotoActivity(Class<? extends Activity> cls, boolean finish) {
		Intent it = new Intent(this, cls);
		startActivity(it);
		if (finish) {
			finish();
		}
	}

}
