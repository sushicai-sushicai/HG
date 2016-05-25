package com.example.hg.AddressAdapter;

import java.util.List;

import com.example.hg.activity.AddressActivity;
import com.example.hg.activity.R;
import com.example.hg.app.HintDalog;
import com.example.hg.entity.Address;
import com.example.hg.interfaces.SendMsg;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class AddressAdapter extends BBaseAdapter implements SendMsg{
	private boolean isEdit=true;
	private IOK iok;
	public AddressAdapter(Context context, List<Object> list, boolean isEdit){
		super(context, list);
		this.isEdit=isEdit;
		this.iok=iok;
	}
	public void setIOK(IOK iok){
		this.iok=iok;
	}
	public interface IOK{
		void deleteOk(String ok);
	}
	@Override
	public void sendStrng(String msg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendInt(int msg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public View getView(final int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		Address a = (Address) list.get(position);
		Holder h;
		if (v == null) {
			v = inflater.inflate(R.layout.address_item, null);
			h = new Holder();
			h.name = (TextView) v.findViewById(R.id.name);
			h.phone = (TextView) v.findViewById(R.id.phone);
			h.address = (TextView) v.findViewById(R.id.address);
			h.edit = (ImageView) v.findViewById(R.id.edit);
			h.iv_delete = (ImageView) v.findViewById(R.id.iv_delete);
			v.setTag(h);
		} else {
			h = (Holder) v.getTag();
		}
		h.name.setText(a.collectpeople);
		h.phone.setText(a.collectphone);
		h.address.setText(a.collectaddress);
		if (!isEdit) {
			h.edit.setVisibility(View.GONE);
			h.iv_delete.setVisibility(View.GONE);
			return v;
		}
		h.edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				long id = ((Address) list.get(position)).id;
				Bundle bundle = new Bundle();
				bundle.putLong("addid", id);
				if (appContext.isNetWorkConnected()) {
					gotoActivity(AddressActivity.class, false, bundle);
				} else {
					toast(R.string.connection_error+"");
				}

			}
		});
		h.iv_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				long id = ((Address) list.get(position)).id;
				new HintDalog(context, "删除地址", "确认删除地址？", AddressAdapter.this, "" + id)
						.show();
				// new HintDalog(context, "删除地址", "确认删除地址？",
				// AddressAdapter.this,""+id).show();
			}
		});
		return v;
	}
	private class Holder {
		public TextView name;
		public TextView phone;
		public TextView address;
		public ImageView edit;
		public ImageView iv_delete;

	}

}
