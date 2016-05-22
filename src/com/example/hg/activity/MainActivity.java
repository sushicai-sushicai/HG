package com.example.hg.activity;

import com.example.hg.fragment.DiscoverFragment;
import com.example.hg.fragment.HomeFragment;
import com.example.hg.fragment.MyHomeFragment;
import com.example.hg.fragment.OrderListFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends BaseFragmentActivity implements OnCheckedChangeListener {
	FragmentTransaction ft;
	/** 首页 */
	HomeFragment hf;
	/** 订单页 */
	OrderListFragment orderlistf;
	/** 发现 */
	DiscoverFragment dscf;
	/** 个人中心页 */
	MyHomeFragment mf;
	@ViewInject(R.id.rg)
	private RadioGroup rg;
	private int checkedId;
	
	
	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 	}
	


	@Override
	protected void init() {
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		checkedId = R.id.rb_home;
		ft = fm.beginTransaction();
		hf = new HomeFragment();
		ft.add(R.id.fl, hf);
		ft.commit();
		setFragmentItem(checkedId);
		rg.setOnCheckedChangeListener(this);
	}
	private void setFragmentItem(int checkedId) {
		ft = fm.beginTransaction();
		hideAll(ft);
		/*Log.i("a", String.valueOf(checkedId));
		Log.i("rb_home", String.valueOf(R.id.rb_home));
		Log.i("rb_list", String.valueOf(R.id.rb_list));
		Log.i("rb_discover", String.valueOf(R.id.rb_discover));
		Log.i("rb_my", String.valueOf(R.id.rb_my));*/
		
		switch (checkedId) {
		case R.id.rb_home:// 首页
			if (hf == null) {
				hf = new HomeFragment();
				ft.add(R.id.fl, hf);
			} else {
				ft.show(hf);
			}
			break;

		case R.id.rb_list:// 列表
			// OpenNet.toggleWiFi(this, false);
			// OpenNet.toggleMobileData(this, false);
			if (orderlistf == null) {
				orderlistf = new OrderListFragment();
				ft.add(R.id.fl, orderlistf);
			} else {
				ft.show(orderlistf);
			}
			break;
		case R.id.rb_discover:// 发现
			// OpenNet.toggleWiFi(this, true);
			// OpenNet.toggleMobileData(this, true);
			if (dscf == null) {
				dscf = new DiscoverFragment();
				ft.add(R.id.fl, dscf);
			} else {
				ft.show(dscf);
			}
			break;
		case R.id.rb_my:// 我的
			if (mf == null) {
				mf = new MyHomeFragment();
				ft.add(R.id.fl, mf);
			} else {
				ft.show(mf);
			}
			break;
		}
		ft.commit();
	}
	/** 隐藏所有fragment */
	private void hideAll(FragmentTransaction ft) {
		if (hf != null)          ft.hide(hf);
		if (orderlistf != null)	 ft.hide(orderlistf);
		if (dscf != null)        ft.hide(dscf);
		if (mf != null)          ft.hide(mf);
	}

	@Override
	public void onCheckedChanged(RadioGroup rg, int checkedId) {		
		this.checkedId = checkedId;
		setFragmentItem(checkedId);
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

}
