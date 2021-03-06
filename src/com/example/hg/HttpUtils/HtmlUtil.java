package com.example.hg.HttpUtils;


import java.util.List;


import org.apache.http.cookie.Cookie;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import com.example.hg.HttpUtils.HttpCallBack.CallBack;
import com.example.hg.activity.LoginActivity;
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
	private void xutil(HttpMethod method,String requestUrl,RequestParams rps,final CallBack collback){
		if(httpUtils==null) httpUtils=new HttpUtils();
		//保存服务器端session的ID
		PreferencesCookieStore cookieStore=new PreferencesCookieStore(context);
		cookieStore.clear();//清除原来的cookie
		httpUtils.configCookieStore(cookieStore);
		List<Cookie> cookie=cookieStore.getCookies();
		httpUtils.configSoTimeout(10*1000);
		String url=dataUrl+requestUrl;
		if(rps!=null){
			rps.setHeader("Cookie","JSESSIONID="+context. getSharedPreferences("userinfo",
					Context.MODE_PRIVATE).getString("token", ""));	
		}
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
	
	public void xutils(HttpMethod mothodname,String requestUrl,RequestParams params,final CallBack callBack){
		System.out.println("==========dataUrl:==="+dataUrl);
		//this.xutil(method, requestUrl, rps, collback);
	}
	/**路径去掉/web*/
	public void xutils2(HttpMethod mothodname, String requestUrl, RequestParams params,final CallBack collback) {
		if(httpUtils==null) httpUtils=new HttpUtils();
		if(params!=null)
			params.setHeader("Cookie","JSESSIONID="+context.getSharedPreferences("userinfo",Context.MODE_PRIVATE).getString("token",""));
		PreferencesCookieStore cookeStore=new PreferencesCookieStore(context);
		cookeStore.clear();//清除原来的cookie
		httpUtils.configCookieStore(cookeStore);
		List<Cookie> cookie=cookeStore.getCookies();
		for(int i=0;i<cookie.size();i++){
			LogShow.d(cookie.get(i).getComment());
		}
		httpUtils.configSoTimeout(10*1000);
		String url=dataUrl+requestUrl;
		System.out.println("----------------------url:"+url);
		httpUtils.send(mothodname, url, params,new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO Auto-generated method stub
				ProgressBar.dismmisProgress();
			}

	

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				ProgressBar.dismmisProgress();
				String str=arg0.result;
				if(StringUtil.isJSONObejcet(str)){
					JSONObject jo=new JSONObject();
					try {
						if(jo.getInt("status")==-1){
							Intent intent=new Intent(context,LoginActivity.class);
							intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
							context.startActivity(intent);
						}
						collback.onBack(jo);
					} catch (org.json.JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
	}


}
