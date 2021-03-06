package com.example.hg.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hg.action.AddressManager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


public class AddressActivity extends BaseActivity{
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.more)
	private ImageView more;
	private List<Object> address;
	@ViewInject(R.id.ulv)
	private ListView ulv;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {};
	};
	@Override
	protected void init() {
		setContentView(R.layout.address_activity);
		ViewUtils.inject(this);
		title.setText("我的配送地址");
		turn.setVisibility(View.VISIBLE);
		turn.setImageResource(R.drawable.sp_turn);
		more.setVisibility(View.INVISIBLE);
		address=new ArrayList<Object>();	
		
	}
	@OnClick({R.id.turn,R.id.add_address})
	public void myClick(View view){
		switch (view.getId()) {
		case R.id.turn:
			finish();
			break;
		case R.id.add_address:
			gotoActivity(AddAddressActivity.class,false);
		default:
			break;
		}
	}
	@Override
	protected void onResume(){
		super.onResume();
		new AddressManager(this, handler, address, ulv,true);
	}

	
	
}
