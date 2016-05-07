package com.example.hg.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment implements OnClickListener{
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		init();
	}

	protected abstract void init();
	protected void toast(String text){
		Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
	}
	public void gotoActivity(Class<? extends Activity> cls,Bundle bundle){
		Intent itent=new Intent(getActivity(),cls);
		if(bundle!=null) itent.putExtras(bundle);
		startActivity(itent);
	}
}
