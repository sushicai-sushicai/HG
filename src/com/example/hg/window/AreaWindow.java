package com.example.hg.window;

import java.util.List;

import com.example.hg.activity.R;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;

public class AreaWindow extends PopupWindow implements OnItemClickListener {
	private ListView contentView;
//	private AreaAdapter adapter;
	private List<Object> list;
	private Context context;
	
	private int type=1;
	private ClassifyPopwindowCallBack callBack;
	public interface ClassifyPopwindowCallBack{
		/**
		 * type 1,2,3 省，市，区
		 * @param 区域id
		 * @param  cotent 内容
		 * */
		void content(int type,int areaid,String content);
	}
	public AreaWindow(Context context,int type,List<Object> list,ClassifyPopwindowCallBack callBack){
		contentView=(ListView) View.inflate(context, R.layout.listviewlayout,null);
		setContentView(contentView);
		this.type=type;	
		this.list=list;
		this.context=context;
		this.callBack= callBack;
		contentView.setOnItemClickListener(this);
	//	setWidth(LayoutParams.WRAP_CONTENT);
	//	setHeight(LayoutParams.WRAP_CONTENT);
	//	setFocusable(true);
	//	setOutsideTouchable(true);
	    // ColorDrawable dw = new ColorDrawable(0000000000);  
	  //   ColorDrawable dw = new ColorDrawable(context.getResources().getColor(R.color.gray));  
	        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作  
	//        this.setBackgroundDrawable(dw); 
	//	data();
	}
	
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
