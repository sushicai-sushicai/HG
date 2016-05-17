package com.example.hg.action;

import java.util.List;

import com.ssc.hg.app.MyApplication;


import android.app.Activity;
import android.content.Context;
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
}
