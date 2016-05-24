package com.example.hg.activity;

import javax.security.auth.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hg.HttpUtils.CommonUtils;
import com.example.hg.app.MyApplication;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class SystemSettingActivity extends BaseActivity{
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.more)
	private ImageView more;
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.logout)
	private TextView logout;
	@Override
	protected void init() {
		super.setContentView(R.layout.systemsetting);
		ViewUtils.inject(this);
		turn.setImageResource(R.drawable.sp_turn);
		more.setVisibility(View.INVISIBLE);
		title.setText("系统设置");		
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		if(!appContext.isLogin) logout.setVisibility(View.INVISIBLE);
	}
	
	@OnClick({R.id.logout,R.id.turn})
	public void MyClick(View v){
		//toast("ssssssssss");
		switch (v.getId()) {
		case R.id.turn:
			finish();			
			break;
		case R.id.cleanimg:
			CommonUtils.cleanUserCaheFiles();
			toast("缓存已清除");
			break;
		case R.id.logout:
			if(appContext.isNetWorkConnected()){
				getData();
			}else{
				toast(R.string.connection_error);
			}
			finish();
			break;
		default:
			break;
		}
	}
	private void getData() {
		savePreferenceString("memheadpic","");
		savePreferenceString("memnick","");		
		savePreferenceString("pwd", "");
		savePreferenceLong("time",0);
		savePreferenceBoolean("isLogin", false);		
		MyApplication.isLogin = false;
		savePreferenceString("token","");
		finish();
		toast("你已退出登录");
		RequestParams params = new RequestParams();
		MyApplication.getHtmlUtil().xutils2(HttpMethod.POST, "member/logout", params, new Callback() {
			
		});
	}
}
