package com.example.hg.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hg.HttpUtils.HttpCallBack.CallBack;
import com.example.hg.app.MyApplication;
import com.example.hg.utils.ProgressBar;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


public class AddAddressActivity extends BaseActivity implements/* ClassifyPopwindowCallBack,*/ OnCheckedChangeListener,android.widget.RadioGroup.OnCheckedChangeListener{
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.more)
	private ImageView more;
	@ViewInject(R.id.rg)
	private RadioGroup rg;
	@ViewInject(R.id.name)
	private EditText name;
	
	private List<Object>list1;
	private List<Object>list2;
	private List<Object>list3;
	
	@ViewInject(R.id.isdefual_address)
	private CheckBox isdefual_address;
	private boolean isEdit=false;
	
	@Override
	protected void init() {
		super.setContentView(R.layout.addadress_activity);
		ViewUtils.inject(this);
		title.setText("添加地址");
		more.setVisibility(View.GONE);
		turn.setVisibility(View.VISIBLE);
		turn.setImageResource(R.drawable.sp_turn);		
		list1=new ArrayList<Object>();
		list2=new ArrayList<Object>();
		list3=new ArrayList<Object>();
		rg.setOnCheckedChangeListener(this);
		isdefual_address.setOnCheckedChangeListener(this);
		Bundle bundle=getIntent().getExtras();//得到activity启动的intent对象数据
		if(bundle!=null && bundle.getLong("addid")!=0){
			long addid=bundle.getLong("addid");
			isEdit=true;
			title.setText("修改地址");
			goOneAddress(addid);
		}
		getdata("area/getProvinces",0,1);
	}
	private void getdata(String requestUrl,int key ,final int type){
		ProgressBar.start(this);
		RequestParams rps=new RequestParams();
		if(key!=0) requestUrl+=key;
		System.out.println("----------------------------"+requestUrl);
		MyApplication.getHtmlUtil().xutils(HttpMethod.POST, requestUrl, rps,new CallBack() {
			
			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onBack(JSONObject json) {
				System.out.println("===================="+json);
				
			}
		});
	}
	/***
	 * private void getdata(String name,int key,final int type){
		GetProgressBar.getProgressBar(this);
		RequestParams params=new RequestParams();
		if(key!=0){
			name=name+key;
		}
		MyApplication.getHtmlUtil().xutils(HttpMethod.GET, name, params, new CallBack() {
			
			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onBack(JSONObject json) {
				// TODO Auto-generated method stub
				try {
					if(json.getString(Contacts.STATUS).equals("1")){
						JSONArray ar=json.getJSONArray("area");
						if(ar.length()>0){
							for (int i = 0; i < ar.length(); i++) {
								JSONObject obj=ar.getJSONObject(i);
								Classify classify=new Classify();
								classify.id=obj.getInt("id");
								
								
								switch (type) {
								case 1:
									classify.context=obj.getString("province");
									list1.add(classify);
									handler.sendEmptyMessage(type);
									break;

								case 2:
									classify.context=obj.getString("city");
									list2.add(classify);
									handler.sendEmptyMessage(type);
									break;
								case 3:
									classify.context=obj.getString("district");
									list3.add(classify);
									handler.sendEmptyMessage(type);
									break;
								}
								
							}
						}
					}else{
						toast(json.getString("msg"));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	 * @param id
	 */
	private void goOneAddress(long id){
		
		//GetProgressBar.getProgressBar(this);
	/*	RequestParams params=new RequestParams();
		
		MyApplication.getHtmlUtil().xutilsc(HttpMethod.POST, "associator/toEditDistribution/"+id, params, new CallBack() {
			
			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onBack(JSONObject json) {
				// TODO Auto-generated method stub
				try {
					if(json.getString(Contacts.STATUS).equals("1")){
						Gson gson=new Gson();
						
					 a=gson.fromJson(json.getJSONObject("address").toString(), Address.class);
					province=json.getJSONObject("province").getString("province");
					
					 mcity=json.getJSONObject("city").getString("city");
					 district=json.getJSONObject("district").getString("district");
					
						switch (a.gender) {
						case 1:
							sex="1";
							boy.setChecked(true);
							girl.setChecked(false);
							break;

						case 0:
							sex="0";
							boy.setChecked(false);
							girl.setChecked(true);
							break;
						}
						handler.sendEmptyMessage(4);
					}else{
						toast(json.getString("msg"));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@OnClick({R.id.turn,R.id.tv_ok})
	public void myClick(View v){
		switch (v.getId()) {
		case R.id.turn:
			finish();
			break;
		case R.id.tv_ok:
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

}
