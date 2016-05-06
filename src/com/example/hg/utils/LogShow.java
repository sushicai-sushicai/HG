package com.example.hg.utils;

import android.util.Log;

public class LogShow extends Contacts{
	private final static String TAG="LOGMSG";
	public static void i(String msg){
		if(isPutLog)
			Log.i(TAG, msg);
	}
	public static void e(String msg){
		if(isPutLog) Log.e(TAG, msg);
	}
	public static void d(String msg){
		if(isPutLog) Log.d(TAG, msg);
	}
}
