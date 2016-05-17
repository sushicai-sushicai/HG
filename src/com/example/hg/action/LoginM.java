package com.example.hg.action;

import java.util.List;

import com.example.hg.utils.ProgressBar;

import android.content.Context;
import android.os.Handler;

public class LoginM extends BaseManger{
	private boolean isPwd=true;
	private String sessionid;
	public LoginM (Context context,Handler handler,List<Object> list,String user,String pass,boolean isPwd,String sessionid){
		super(context, handler, list);
		this.isPwd=isPwd;
		this.sessionid=sessionid;
		doLogin(user,pass);//	getData(user,pass);
	}
	private void doLogin(String user,String pass){
		//GetProgressBar.getProgressBar
		ProgressBar.getProgressBar(context);//启动滚动条
	}
}
