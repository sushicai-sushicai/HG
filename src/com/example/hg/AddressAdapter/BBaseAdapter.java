package com.example.hg.AddressAdapter;

import java.util.List;

import com.example.hg.app.MyApplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

public class BBaseAdapter extends BaseAdapter{
	Context context;
	List<Object> list;
	LayoutInflater inflater;
	public MyApplication appContext;
	public BBaseAdapter(Context context,List<Object> list){
		this.context=context;
		this.list=list;
		inflater=LayoutInflater.from(context);
		appContext=(MyApplication) ((Activity)context).getApplication();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 跳转到另一个页面
	 * */
	public void gotoActivity(Class<? extends Activity> cls, boolean finish,
			Bundle bundle) {

		Intent intent = new Intent(context, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		context.startActivity(intent);
		if (finish) {
			((Activity)context).finish();
		}
	}
	protected void toast(String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
