package com.example.hg.utils;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import com.example.hg.view.MyProgressBar;


public class ProgressBar {
	private static MyProgressBar myProgressBar;
	public static MyProgressBar start(Context context){
		if(null==myProgressBar){
			myProgressBar=new MyProgressBar(context);
		}
		myProgressBar.show();
		final AnimationDrawable anim=(AnimationDrawable) myProgressBar.getImageView().getBackground();//加载进度条
		anim.start();
		myProgressBar.setCanceledOnTouchOutside(false);//// 点击空白处不消失
		return myProgressBar;
	}
	public static void dismmisProgress(){
		if(myProgressBar!=null){
			myProgressBar.dismiss();
			myProgressBar=null;
		} 
		
	}
	
}
