package com.example.hg.HttpUtils;


import java.util.List;

import org.apache.http.cookie.Cookie;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSONException;
import com.example.hg.HttpUtils.HttpCallBack.CallBack;
import com.example.hg.activity.R;
import com.example.hg.utils.Contacts;
import com.example.hg.utils.LogShow;
import com.example.hg.utils.ProgressBar;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.util.PreferencesCookieStore;

public class HtmlUtil extends Contacts{
	/**
	 * 网络请求url
	 */
	private String dataUrl;
	private String imgUrl;
	HttpUtils httpUtils;
	private Context context;
	public HtmlUtil(Context context){
		this.context=context;
		if(ISTEST){
			dataUrl=context.getResources().getString(R.string.testurl);
			imgUrl=context.getResources().getString(R.string.testimgurl);
		}else{
			dataUrl=context.getResources().getString(R.string.dataurl);
			imgUrl=context.getResources().getString(R.string.imgurl);
		}
	}
	public void xutils(HttpMethod method,String requestUrl,RequestParams rps,final CallBack collback){
		if(httpUtils==null) httpUtils=new HttpUtils();
		//保存服务器端session的ID
		PreferencesCookieStore cookieStore=new PreferencesCookieStore(context);
		cookieStore.clear();//清除原来的cookie
		httpUtils.configCookieStore(cookieStore);
		List<Cookie> cookie=cookieStore.getCookies();
		httpUtils.configSoTimeout(10*1000);
		String url=dataUrl+requestUrl;
		LogShow.i(url);
		httpUtils.send(method, url,rps,new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String msg) {
				// TODO Auto-generated method stub
				ProgressBar.dismmisProgress();
				LogShow.e(msg);
				collback.onError(msg);
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				ProgressBar.dismmisProgress();
				String str=arg0.result;
				LogShow.d(str);
				if(StringUtil.isJSONObejcet(str)){
					try {
						collback.onBack(new JSONObject(str));
					} catch (org.json.JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
		});
	}
}
