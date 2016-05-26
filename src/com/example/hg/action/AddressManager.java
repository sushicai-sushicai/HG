package com.example.hg.action;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hg.AddressAdapter.AddressAdapter;
import com.example.hg.HttpUtils.HttpCallBack.CallBack;
import com.example.hg.activity.R;
import com.example.hg.app.MyApplication;
import com.example.hg.entity.Address;
import com.google.gson.Gson;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class AddressManager extends BaseManger{
	private ListView ulv;
	private AddressAdapter adapter;
	/**
	 * 
	 * @param context
	 * @param handler
	 * @param list
	 * @param ulv
	 * @param isEdit 是否显示编辑按钮
	 */
	public AddressManager(Context context, Handler handler, List<Object> list,ListView ulv,boolean isEdit) {
		super(context, handler, list);
		this.ulv=ulv;
		adapter=new AddressAdapter(context, list, isEdit);
		ulv.setAdapter(adapter);
		View ll=View.inflate(context, R.layout.emptyview, null);
		TextView tv=(TextView) ll.findViewById(R.id.tv);
		ll.setVisibility(View.GONE);
		((ViewGroup)ulv.getParent()).addView(ll);		
		this.ulv.setEmptyView(ll);
		tv.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				getData();
				
			}
		});
	}
	private void getData(){
		RequestParams rps=new RequestParams();
		MyApplication.getHtmlUtil().xutils(HttpMethod.POST, "associator/getDistribution", rps, new CallBack(){
			@Override
			public void onError(String msg) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onBack(JSONObject json) {
				Gson gson=new Gson();
				try {
					if(json.getString("status").equals("1")){
						JSONArray jsonArray=json.getJSONArray("distribution");
						if(jsonArray!=null && jsonArray.length()>0){
							list.clear();
							for (int i = 0; i < jsonArray.length(); i++) {
								Address address=new Address();
								System.out.println(jsonArray.getJSONObject(i));
								address=gson.fromJson(jsonArray.getJSONObject(i).toString(), Address.class);
								list.add(address);
							}
							
						}
						adapter.notifyDataSetChanged();
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


/**
 * private void data(){
		
		@Override
		public void onBack(JSONObject json) {
			// TODO Auto-generated method stub
			Gson gson=new Gson();
			try {
				if(json.getString("status").equals("1")){
					JSONArray ar=json.getJSONArray("distribution");
					if(ar!=null&&ar.length()>0){
						list.clear();
						for (int i = 0; i < ar.length(); i++) {
							Address ad=new Address();
							ad=gson.fromJson(ar.getJSONObject(i).toString(), Address.class);
							list.add(ad);
						}

						adapter.notifyDataSetChanged();
					}
				}else{
					
					
						toast(json.getString("msg"));
				
				}
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

}
 */

}
