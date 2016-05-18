package com.example.hg.HttpUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpCallBack {
	public interface CallBack{
		public void onBack(JSONObject json);
		public void onError(String msg);
	}
}
