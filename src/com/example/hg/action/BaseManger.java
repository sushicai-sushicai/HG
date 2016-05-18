package com.example.hg.action;

import java.util.List;

import com.example.hg.app.MyApplication;



import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;

public abstract class BaseManger {
	protected Context context;
	protected Handler handler;
	protected List<Object> list;
	protected MyApplication appcontext;
	public BaseManger(Context context,Handler handler,List<Object> list){
		this.context=context;
		this.handler=handler;
		this.list= list;
		appcontext=(MyApplication) ((Activity)context).getApplication();
	};
	private static String userinfo="userinfo";
	public void savePreference(String key, Object value) {
		SharedPreferences sp=context.getSharedPreferences(userinfo, Context.MODE_PRIVATE);
		Editor editor=sp.edit();
		System.out.println(value.getClass());
		if(value instanceof java.lang.String) editor.putString(key, value.toString());
		if(value instanceof java.lang.Boolean) editor.putBoolean(key, (Boolean)value);
		if(value instanceof java.lang.Integer) editor.putInt(key, Integer.parseInt(value.toString()));
		if(value instanceof java.lang.Long) editor.putLong(key, Long.parseLong(value.toString()));
		
		editor.commit();		
	}
	
	
}
