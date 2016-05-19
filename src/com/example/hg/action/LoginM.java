package com.example.hg.action;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import com.example.hg.HttpUtils.HttpCallBack.CallBack;
import com.example.hg.app.MyApplication;
import com.example.hg.entity.Member;
import com.example.hg.pic.ImgManager;
import com.example.hg.utils.Contacts;
import com.example.hg.utils.MD5;
import com.example.hg.utils.ProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.content.Context;
import android.os.Handler;
import android.telephony.gsm.GsmCellLocation;
import android.widget.Toast;
public class LoginM extends BaseManger{
	private boolean isPwd=true;
	protected Handler handler;
	private String sessionid;
	public LoginM (Context context,Handler handler,List<Object> list,String user,String pass,boolean isPwd,String sessionid){
		super(context, handler, list);
		this.isPwd=isPwd;
		this.sessionid=sessionid;
		this.handler=handler;
		doLogin(user,pass);
	}
	private void doLogin(final String user,final String pass){
		ProgressBar.start(context);//启动滚动条
		RequestParams rp=new RequestParams();
		rp.addQueryStringParameter("memphone",user);
		String type=this.isPwd?"password":"sms";
		if(type.equals("password")){
			rp.addQueryStringParameter("mempwd", MD5.parseMD5(pass));
		}else{
			rp.addQueryStringParameter("code", pass);	
			rp.addQueryStringParameter("JSESSIONID", sessionid);	
			//Header header=new Header();	
			rp.setHeader("Cookie","JSESSIONID="+sessionid);
		}
		rp.addQueryStringParameter("type",type);
		MyApplication.getHtmlUtil().xutils(HttpMethod.POST,"member/login",rp,new CallBack() {
			
			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(Contacts.FAIL_0);
			}
			
			@Override
			public void onBack(JSONObject json) {				
				try {
					// TODO Auto-generated method stub
					savePreference("username",user);
					savePreference("password", pass);
					Member member=new Member();
					Gson gson=new Gson();
					member=gson.fromJson(json.getJSONObject("member").toString(), Member.class);
					savePreference("memheadpic", member.memheadpic);
					savePreference("memnick", member.memnick);
					savePreference("memphone",member.memphone);
					savePreference("isLogin", true);
					savePreference("pwd", member.pwd);
					savePreference("time", System.currentTimeMillis());
					ImgManager im=new ImgManager();
					im.readWebImg(member.memheadpic,null);
					MyApplication.isLogin=true;
					
					
				}catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

			
		});
	}
	
}
