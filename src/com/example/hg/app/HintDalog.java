package com.example.hg.app;


import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.hg.activity.R;
import com.example.hg.interfaces.SendMsg;

public class HintDalog extends Dialog implements  android.view.View.OnClickListener{
	private Context context;
	private TextView tv_title;
	private TextView tv_hint;
	private SendMsg sendMsg;
	private String msg;
	public HintDalog(Context context,String title ,String hint ,SendMsg sendMsg,String msg) {
		super(context);
		this.context=context;
		this.sendMsg=sendMsg;
		this.msg=msg;
		tv_title.setText(title);
		tv_hint.setText(hint);
		init();
	}
	private void init(){
		setContentView(R.layout.hint_dialog);
		WindowManager.LayoutParams params=getWindow().getAttributes();
		params.width=MyApplication.getScreenHeight();
		params.height=LayoutParams.WRAP_CONTENT;
		getWindow().setAttributes(params);
		getWindow().setBackgroundDrawableResource(R.color.transparent);
		tv_title=(TextView) findViewById(R.id.tv_title);
		tv_hint=(TextView) findViewById(R.id.tv_hint);
		findViewById(R.id.tv_cancel).setOnClickListener(this);
		findViewById(R.id.tv_confirm).setOnClickListener(this);
		setCancelable(true);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
