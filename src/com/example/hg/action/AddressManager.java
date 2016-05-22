package com.example.hg.action;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.hg.AddressAdapter.AddressAdapter;
import com.example.hg.HttpUtils.HttpCallBack.CallBack;
import com.example.hg.activity.R;
import com.example.hg.app.MyApplication;
import com.google.gson.Gson;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;


import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
		View linearLayout=View.inflate(context, R.layout.emptyview, null);
		TextView tv
		
		/*// TODO Auto-generated constructor stub
		this.ulv=ulv;
		adapter=new AddressAdapter(context, list,isEdit,this);
		
		ulv.setAdapter(adapter);
		View ll = View.inflate(context, R.layout.emptyview, null);
		TextView tv = (TextView) ll.findViewById(R.id.tv);
		ll.setVisibility(View.GONE);
		((ViewGroup)ulv.getParent()).addView(ll);
		ulv.setEmptyView(ll);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data();
			}
		});
		
		data();*/
	}

	private void data(){
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
						System.out.println(json);
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
