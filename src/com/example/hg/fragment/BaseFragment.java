package com.example.hg.fragment;

import com.example.hg.app.MyApplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment{
	Activity context;
	MyApplication application;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		context=activity;
		application=(MyApplication) activity.getApplication();
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		init();
	}

	protected abstract void init();
	protected void toast(String text){
		Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
	}
	public void gotoActivity(Class<? extends Activity> cls,Bundle bundle){
		Intent itent=new Intent(getActivity(),cls);
		if(bundle!=null) itent.putExtras(bundle);
		startActivity(itent);
	}
	private final String userinfo="userinfo";
	public void savePreference(String key, Object value) {
		SharedPreferences sp=context.getSharedPreferences(userinfo, Context.MODE_PRIVATE);
		Editor editor=sp.edit();
		if(value instanceof java.lang.String) editor.putString(key, value.toString());
		if(value instanceof java.lang.Boolean) editor.putBoolean(key, (Boolean)value);
		if(value instanceof java.lang.Integer) editor.putInt(key, Integer.parseInt(value.toString()));
		if(value instanceof java.lang.Long) editor.putLong(key, Long.parseLong(value.toString()));		
		editor.commit();		
	}
	public boolean getPreferenceBoolean(String key) {
		SharedPreferences preferences = context.getSharedPreferences(userinfo,
				Context.MODE_PRIVATE);
		return preferences.getBoolean(key, false);
	}
	public String getPreferenceString(String key) {
		SharedPreferences preferences = context.getSharedPreferences(userinfo,
				Context.MODE_PRIVATE);
		return preferences.getString(key, "");
	}
	public long getPreferenceLong(String key) {
		SharedPreferences preferences = context.getSharedPreferences(userinfo,
				Context.MODE_PRIVATE);
		return preferences.getLong(key,0);
	}

}
