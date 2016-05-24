package com.example.hg.fragment;

import com.example.hg.HttpUtils.StringUtil;
import com.example.hg.activity.AddressActivity;
import com.example.hg.activity.LoginActivity;
import com.example.hg.activity.MyInformationActivity;
import com.example.hg.activity.R;
import com.example.hg.activity.SystemSettingActivity;
import com.example.hg.app.MyApplication;
import com.example.hg.pic.ImgManager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyHomeFragment extends BaseFragment implements OnClickListener {
	/** 返回 */
	@ViewInject(R.id.turn)
	private ImageView turn;
	/** 更多 */
	@ViewInject(R.id.more)
	private ImageView more;
	/** 头部 */
	@ViewInject(R.id.title)
	private TextView title;

	@ViewInject(R.id.tologin)
	private TextView tologin;
	@ViewInject(R.id.phone)
	private TextView phone;
	@ViewInject(R.id.tv_share)
	private TextView tv_share;
	@ViewInject(R.id.toinformation)
	private ImageView toinformation;
	@ViewInject(R.id.qrcode)
	private ImageView qrcode;
	@ViewInject(R.id.head)
	private ImageView head;
	private ImgManager im;
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(MyApplication.isLogin){
			tologin.setText(getPreferenceString("username"));
			String tel=getPreferenceString("memphone");
			if(tel.length()==11) phone.setText(StringUtil.replacephoneString(tel));
			phone.setVisibility(View.VISIBLE);
			if(im==null) im=new ImgManager();
		//	im.getHead(head);			
		}else{
			tologin.setText("登陆/注册");
			phone.setVisibility(View.GONE);
			if(null==im) im=new ImgManager();
			//im.getHead(null);
		}		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 super.onCreateView(inflater, container, savedInstanceState);
		View view=inflater.inflate(R.layout.myhomelayout, null);
	    ViewUtils.inject(this,view);
		return view;
	}
	protected void init() {
		title.setText("我的");
		turn.setVisibility(View.VISIBLE);
		turn.setImageResource(R.drawable.shezhi);
		more.setImageResource(R.drawable.shezhi);
		more.setOnClickListener(this);

	
		
	}
	//@OnClick({R.id.myaddress,R.id.mycollect,R.id.turn,R.id.more,R.id.tologin,R.id.toinformation,R.id.tv_share})
	@OnClick({R.id.myaddress,R.id.toinformation,R.id.tologin,R.id.toinformation,R.id.more})
	public void myclick(View v){	
		if(!MyApplication.isLogin){
			toast("请登录!");
			gotoActivity(LoginActivity.class, null);	
			return;
		}
		switch (v.getId()) {
		case R.id.myaddress:
			gotoActivity(AddressActivity.class, null);
			break;
		case R.id.toinformation:
			gotoActivity(MyInformationActivity.class, null);

		default:
			break;
		}
	/*	if (!MyApplication.isLogin) {
			toast("请登录");
			gotoActivity(LoginActivity.class, null);
			return ;
		}
		switch (v.getId()) {
		case R.id.myaddress://我的地址
			gotoActivity(AddressActivity.class, null);
			break;
		case R.id.mycollect://我的收藏
			gotoActivity(ColletActivity.class, null);
			break;
		case R.id.turn://站内信
		
			gotoActivity(NotifiesActivity.class, null);
			break;
		

		case R.id.tologin:// 去登录
			gotoActivity(LoginActivity.class, null);
			
			break;
		case R.id.toinformation:// 去个人信息
			gotoActivity(MyInformation.class, null);
			break;
		case R.id.tv_share:// 邀请分享
			gotoActivity(ShareInvite.class, null);
			break;
		}*/
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.more:
			gotoActivity(SystemSettingActivity.class, null);
			break;
		}
	}
}
