package com.example.hg.activity;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddAddressActivity extends BaseActivity{
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.more)
	private ImageView more;
	@Override
	protected void init() {
		super.setContentView(R.layout.addadress_activity);
		ViewUtils.inject(this);
		title.setText("添加常用联系人");
		more.setVisibility(View.GONE);
		turn.setVisibility(View.VISIBLE);
		turn.setImageResource(R.drawable.sp_turn);
		
		
		
	}
	
	@OnClick({R.id.turn})
	public void myClick(View v){
		switch (v.getId()) {
		case R.id.turn:
			finish();
			break;

		default:
			break;
		}
	}

}
